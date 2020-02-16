package com.emperorws.hrmanagement.mapper;

import com.emperorws.hrmanagement.model.PermissionRole;
import org.apache.ibatis.annotations.Param;

public interface PermissionRoleMapper {
    int deleteByPrimaryKey(Integer proleid);

    int insert(PermissionRole record);

    int insertSelective(PermissionRole record);

    PermissionRole selectByPrimaryKey(Integer proleid);

    int updateByPrimaryKeySelective(PermissionRole record);

    int updateByPrimaryKey(PermissionRole record);

    void deleteByRoleid(Integer roleid);

    Integer insertRecord(@Param("roleid") Integer roleid, @Param("pids") Integer[] pids);
}
