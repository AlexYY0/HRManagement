package com.emperorws.hrmanagement.service;

import com.emperorws.hrmanagement.mapper.UserMapper;
import com.emperorws.hrmanagement.mapper.UserRoleMapper;
import com.emperorws.hrmanagement.model.User;
import com.emperorws.hrmanagement.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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

    public List<User> getAllUsers(String keywords) {
        return userMapper.getAllUsers(UserUtils.getCurrentUser().getUserid(),keywords);
    }

    public Integer updateUser(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Transactional
    public boolean updateUserRole(Integer userid, Integer[] roleids) {
        userRoleMapper.deleteByUserid(userid);
        return userRoleMapper.addRole(userid, roleids) == roleids.length;
    }

    public Integer deleteUserById(Integer userid) {
        return userMapper.deleteByPrimaryKey(userid);
    }

    public List<User> getAllUsersExceptCurrentUser() {
        return userMapper.getAllUsersExceptCurrentUser(UserUtils.getCurrentUser().getUserid());
    }
}
