package com.emperorws.hrmanagement.controller;

import com.emperorws.hrmanagement.logger.SystemControllerLog;
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
    @SystemControllerLog(description="获取当前系统用户信息")
    public User getCurrentUser(Authentication authentication) {
        return ((User) authentication.getPrincipal());
    }

    @PutMapping("/info")
    @SystemControllerLog(description="修改当前的系统用户信息")
    public RespBean updateUser(@RequestBody User user, Authentication authentication) {
        if (userService.updateUser(user) == 1) {
            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(user, authentication.getCredentials(), authentication.getAuthorities()));
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @PutMapping("/password")
    @SystemControllerLog(description="修改当前的系统用户密码信息")
    public RespBean updateUserPassword(@RequestBody Map<String, Object> info,Authentication authentication) {
        String oldpassword = (String) info.get("oldpassword");
        String password = (String) info.get("password");
        User user = (User) authentication.getPrincipal();
        if (userService.updateUserPassword(oldpassword, password, user.getUserid())) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @GetMapping("/check/username/{username}")
    @SystemControllerLog(description="通过用户名获取系统用户信息")
    public Boolean getUserByUsername(@PathVariable String username){
        return userService.getUserByUsername(username);
    }

    @GetMapping("/check/password")
    @SystemControllerLog(description="获取当前的系统用户密码信息")
    public Boolean getUserByPassword(String password,Integer userid){
        return userService.getUserByPassword(password,userid);
    }

    @GetMapping("/token")
    @SystemControllerLog(description="获取上传文件到云端的令牌")
    public String getToken(){
        String accessKey = "HHpVv8wj2T-IGv8JrjZFArdSUy6QGMxuo10k7Hnd";
        String secretKey = "qoAkFOku7m6wouAwum45Ef-SiCTrOarj5QTgZQ3y";
        String bucket = "emperorws";
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        return upToken;
    }
}
