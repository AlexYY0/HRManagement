package com.emperorws.hrmanagement.controller.system;

import com.emperorws.hrmanagement.model.*;
import com.emperorws.hrmanagement.service.RoleService;
import com.emperorws.hrmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: EmperorWS
 * @Date: 2020/2/25 16:06
 * @Description: 系统用户管理控制层
 **/
@RestController
@RequestMapping("/system/userrole")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;

    @GetMapping("/roles")
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    @PutMapping("/role")
    public RespBean updateUserRole(Integer userid, Integer[] roleids) {
        if (userService.updateUserRole(userid, roleids)) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @GetMapping("/")
    public RespPageBean getAllUsersByPage(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "8") Integer size, Employee employee) {
        return userService.getAllUsersByPage(page, size, employee);
    }

    @PutMapping("/")
    public RespBean updateUser(@RequestBody User user) {
        if (userService.updateUser(user) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @DeleteMapping("/{userid}")
    public RespBean deleteUserById(@PathVariable Integer userid) {
        if (userService.deleteUserById(userid) == 1) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

    @GetMapping("/find")
    public Boolean getUserByWorkid(Integer workid){
        return userService.getUserByWorkid(workid);
    }

    @PostMapping("/user")
    public RespBean addUser(@RequestBody User user){
        if (userService.addUser(user) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }
}
