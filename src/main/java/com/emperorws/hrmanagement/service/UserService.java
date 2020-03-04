package com.emperorws.hrmanagement.service;

import com.emperorws.hrmanagement.mapper.UserMapper;
import com.emperorws.hrmanagement.mapper.UserRoleMapper;
import com.emperorws.hrmanagement.model.Employee;
import com.emperorws.hrmanagement.model.RespPageBean;
import com.emperorws.hrmanagement.model.User;
import com.emperorws.hrmanagement.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: EmperorWS
 * @Date: 2020/2/14 13:44
 * @Description: 这个类的作用，主要是用户的服务层
 **/
@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserRoleMapper userRoleMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.loadUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在!");
        }
        user.setRoles(userMapper.getUserRolesById(user.getUserid()));
        return user;
    }

    public RespPageBean getAllUsersByPage(Integer page, Integer size, Employee employee) {
        if (page != null && size != null) {
            page = (page - 1) * size;
        }
        List<User> data = userMapper.getAllUsersByPage(UserUtils.getCurrentUser().getUserid(), page, size, employee);
        Long total = userMapper.getTotal(employee)-1;
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        bean.setTotal(total);
        return bean;
    }

    public Integer updateUser(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Transactional
    public boolean updateUserRole(Integer userid, Integer[] roleids) {
        userRoleMapper.deleteByUserid(userid);
        if (roleids == null || roleids.length == 0) {
            return true;
        }
        return userRoleMapper.addRole(userid, roleids) == roleids.length;
    }

    public Integer deleteUserById(Integer userid) {
        return userMapper.deleteByPrimaryKey(userid);
    }

    public List<User> getAllUsersExceptCurrentUser() {
        return userMapper.getAllUsersExceptCurrentUser(UserUtils.getCurrentUser().getUserid());
    }

    public boolean updateUserPassword(String oldpassword, String password, Integer userid){
        User user = userMapper.selectByPrimaryKey(userid);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (encoder.matches(oldpassword, user.getPassword())) {
            String encodePassword = encoder.encode(password);
            Integer result = userMapper.updateUserPassword(userid, encodePassword);
            if (result == 1) {
                return true;
            }
        }
        return false;
    }

    public Boolean getUserByUsername(String username){
        User result = userMapper.loadUserByUsername(username);
        if(result==null)
            return false;
        return true;
    }

    public Boolean getUserByPassword(String password,Integer userid){
        User user = userMapper.selectByPrimaryKey(userid);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (encoder.matches(password, user.getPassword()))
            return true;
        else
            return false;
    }

    public Boolean getUserByWorkid(Integer workid){
        User result = userMapper.getUserByWorkid(workid);
        if(result==null)
            return false;
        return true;
    }

    public Integer addUser(User user){
        String username=user.getUsername();
        String password=user.getPassword();
        if (userMapper.loadUserByUsername(username) != null) {
            return -1;
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encode = encoder.encode(password);
        user.setPassword(encode);
        return userMapper.insert(user);
    }
}
