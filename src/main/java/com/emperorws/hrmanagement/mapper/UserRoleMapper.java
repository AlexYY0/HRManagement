package com.emperorws.hrmanagement.mapper;

import com.emperorws.hrmanagement.model.UserRole;
import org.apache.ibatis.annotations.Param;

public interface UserRoleMapper {
    int deleteByPrimaryKey(Integer uroleid);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(Integer uroleid);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);

    void deleteByUserid(Integer userid);

    Integer addRole(@Param("userid") Integer userid, @Param("roleids") Integer[] roleids);
}
