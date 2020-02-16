package com.emperorws.hrmanagement.mapper;

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

    List<User> getAllUsers(@Param("userid") Integer userid, @Param("keywords") String keywords);

    List<User> getAllUsersExceptCurrentUser(Integer userid);
}
