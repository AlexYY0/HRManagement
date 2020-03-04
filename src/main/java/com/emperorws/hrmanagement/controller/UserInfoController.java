package com.emperorws.hrmanagement.controller;

import com.emperorws.hrmanagement.model.RespBean;
import com.emperorws.hrmanagement.model.User;
import com.emperorws.hrmanagement.service.UserService;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Author: EmperorWS
 * @Date: 2020/3/4 12:49
 * @Description: 员工修改个人信息控制层
 **/
@RestController
@RequestMapping("/user")
public class UserInfoController {
    @Autowired
    UserService userService;

    @GetMapping("/info")
    public User getCurrentUser(Authentication authentication) {
        return ((User) authentication.getPrincipal());
    }

    @PutMapping("/info")
    public RespBean updateHr(@RequestBody User user, Authentication authentication) {
        if (userService.updateUser(user) == 1) {
            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(user, authentication.getCredentials(), authentication.getAuthorities()));
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @PutMapping("/password")
    public RespBean updateUserPassword(@RequestBody Map<String, Object> info) {
        String oldpassword = (String) info.get("oldpassword");
        String password = (String) info.get("password");
        Integer userid = (Integer) info.get("userid");
        if (userService.updateUserPassword(oldpassword, password, userid)) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @GetMapping("/check/username/{username}")
    public Boolean getUserByUsername(@PathVariable String username){
        return userService.getUserByUsername(username);
    }

    @GetMapping("/check/password")
    public Boolean getUserByPassword(String password,Integer userid){
        return userService.getUserByPassword(password,userid);
    }

    @GetMapping("/token")
    public String getToken(){
        String accessKey = "HHpVv8wj2T-IGv8JrjZFArdSUy6QGMxuo10k7Hnd";
        String secretKey = "qoAkFOku7m6wouAwum45Ef-SiCTrOarj5QTgZQ3y";
        String bucket = "emperorws";
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        return upToken;
    }
}
