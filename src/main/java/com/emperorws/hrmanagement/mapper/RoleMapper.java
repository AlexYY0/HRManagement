package com.emperorws.hrmanagement.mapper;

import com.emperorws.hrmanagement.model.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer roleid);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer roleid);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<Role> getAllRoles(@Param("page") Integer page, @Param("size") Integer size);

    Long getTotal();
}
