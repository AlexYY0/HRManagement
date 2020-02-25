package com.emperorws.hrmanagement.controller.config;

import com.emperorws.hrmanagement.model.Permission;
import com.emperorws.hrmanagement.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: EmperorWS
 * @Date: 2020/2/15 15:15
 * @Description: 获取角色对应的权限资源json
 **/
@RestController
@RequestMapping("/system/config")
public class SystemConfigController {
    @Autowired
    PermissionService permissionService;
    @GetMapping("/permission")
    public List<Permission> getPermissionsByUserId() {
        return permissionService.getPermissionsByUserId();
    }
}
