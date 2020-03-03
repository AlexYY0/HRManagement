package com.emperorws.hrmanagement.controller.system;

import com.emperorws.hrmanagement.model.Permission;
import com.emperorws.hrmanagement.model.RespBean;
import com.emperorws.hrmanagement.model.RespPageBean;
import com.emperorws.hrmanagement.model.Role;
import com.emperorws.hrmanagement.service.PermissionService;
import com.emperorws.hrmanagement.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: EmperorWS
 * @Date: 2020/2/24 19:48
 * @Description: 权限管理控制层
 **/
@RestController
@RequestMapping("/system/rolepermission/")
public class PermissionController {
    @Autowired
    RoleService roleService;
    @Autowired
    PermissionService permissionService;

    @GetMapping("/")
    public RespPageBean getAllRolesByPage(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size) {
        return roleService.getAllRolesByPage(page, size);
    }

    @GetMapping("/permissions")
    public List<Permission> getAllPermissions() {
        return permissionService.getAllPermissions();
    }

    @GetMapping("/pids/{roleid}")
    public List<Integer> getPidsByRoleid(@PathVariable Integer roleid) {
        return permissionService.getPidsByRoleid(roleid);
    }

    @PutMapping("/")
    public RespBean updatePermissionRole(Integer roleid, Integer[] pids) {
        if (permissionService.updatePermissionRole(roleid, pids)) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @PostMapping("/role")
    public RespBean addRole(@RequestBody Role role) {
        if (roleService.addRole(role) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    @DeleteMapping("/role/{roleid}")
    public RespBean deleteRoleById(@PathVariable Integer roleid) {
        if (roleService.deleteRoleById(roleid) == 1) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }
}
