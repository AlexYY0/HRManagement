package com.emperorws.hrmanagement.service;

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
    public RespPageBean getAllRoles(Integer page, Integer size) {
        if (page != null && size != null) {
            page = (page - 1) * size;
        }
        List<Role> data=roleMapper.getAllRoles(page, size);
        Long total=roleMapper.getTotal();
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        bean.setTotal(total);
        return bean;
    }

    public Integer addRole(Role role) {
        if (!role.getEnname().startsWith("ROLE_")) {
            role.setEnname("ROLE_" + role.getEnname());
        }
        return roleMapper.insert(role);
    }

    public Integer deleteRoleById(Integer roleid) {
        return roleMapper.deleteByPrimaryKey(roleid);
    }
}
