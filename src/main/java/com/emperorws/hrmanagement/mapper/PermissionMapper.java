package com.emperorws.hrmanagement.mapper;

import com.emperorws.hrmanagement.model.Permission;

import java.util.List;

public interface PermissionMapper {
    int deleteByPrimaryKey(Integer pid);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Integer pid);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);

    List<Permission> getPermissionsByUserId(Integer userid);

    List<Permission> getAllPermissionsWithRole();

    List<Permission> getAllPermissions();

    List<Integer> getPidsByRoleid(Integer roleid);
}
