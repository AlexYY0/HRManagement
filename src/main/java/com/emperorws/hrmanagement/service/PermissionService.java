package com.emperorws.hrmanagement.service;

import com.emperorws.hrmanagement.mapper.PermissionMapper;
import com.emperorws.hrmanagement.mapper.PermissionRoleMapper;
import com.emperorws.hrmanagement.model.Permission;
import com.emperorws.hrmanagement.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: EmperorWS
 * @Date: 2020/2/14 13:53
 * @Description: 权限服务层
 **/
@Service
@CacheConfig(cacheNames = "permissions_cache")
public class PermissionService {
    @Autowired
    PermissionMapper permissionMapper;
    @Autowired
    PermissionRoleMapper permissionRoleMapper;
    public List<Permission> getPermissionsByUserId() {
        return permissionMapper.getPermissionsByUserId(((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserid());
    }

    @Cacheable
    public List<Permission> getAllPermissionsWithRole() {
        return permissionMapper.getAllPermissionsWithRole();
    }

    public List<Permission> getAllPermissions() {
        return permissionMapper.getAllPermissions();
    }

    public List<Integer> getPidsByRoleid(Integer roleid) {
        return permissionMapper.getPidsByRoleid(roleid);
    }

    @Transactional
    public boolean updatePermissionRole(Integer roleid, Integer[] pids) {
        permissionRoleMapper.deleteByRoleid(roleid);
        if (pids == null || pids.length == 0) {
            return true;
        }
        Integer result = permissionRoleMapper.insertRecord(roleid, pids);
        return result==pids.length;
    }
}
