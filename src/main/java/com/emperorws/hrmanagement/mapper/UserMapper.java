package com.emperorws.hrmanagement.mapper;

import com.emperorws.hrmanagement.model.Employee;
import com.emperorws.hrmanagement.model.Role;
import com.emperorws.hrmanagement.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User loadUserByUsername(String username);

    List<Role> getUserRolesById(Integer userid);

    List<User> getAllUsersByPage(@Param("userid") Integer userid, @Param("page") Integer page, @Param("size") Integer size, @Param("emp") Employee employee);

    Long getTotal(@Param("emp") Employee employee);

    User getUserByWorkid(Integer workid);

    List<User> getAllUsersExceptCurrentUser(Integer userid);

    Integer updateUserPassword(@Param("userid") Integer userid, @Param("encodePassword") String encodePassword);

    User getAllUserInfoByUserid(Integer userid);
}
