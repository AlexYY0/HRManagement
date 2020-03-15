package com.emperorws.hrmanagement.service;

import com.emperorws.hrmanagement.logger.SystemServiceLog;
import com.emperorws.hrmanagement.mapper.RoleMapper;
import com.emperorws.hrmanagement.model.RespPageBean;
import com.emperorws.hrmanagement.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: EmperorWS
 * @Date: 2020/2/24 19:44
 * @Description: 角色管理服务层
 **/
@Service
public class RoleService {
    @Autowired
    RoleMapper roleMapper;

    @SystemServiceLog(description="获取所有的系统角色信息")
    public List<Role> getAllRoles() {
        return roleMapper.getAllRoles();
    }

    @SystemServiceLog(description="获取所有的系统角色信息")
    public RespPageBean getAllRolesByPage(Integer page, Integer size) {
        if (page != null && size != null) {
            page = (page - 1) * size;
        }
        List<Role> data=roleMapper.getAllRolesByPage(page, size);
        Long total=roleMapper.getTotal();
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        bean.setTotal(total);
        return bean;
    }

    @SystemServiceLog(description="添加新的系统角色信息")
    public Integer addRole(Role role) {
        if (!role.getEnname().startsWith("ROLE_")) {
            role.setEnname("ROLE_" + role.getEnname());
        }
        return roleMapper.insert(role);
    }

    @SystemServiceLog(description="删除旧的系统角色信息")
    public Integer deleteRoleById(Integer roleid) {
        return roleMapper.deleteByPrimaryKey(roleid);
    }
}
