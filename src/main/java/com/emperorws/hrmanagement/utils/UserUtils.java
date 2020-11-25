package com.emperorws.hrmanagement.utils;

import com.emperorws.hrmanagement.config.WechatAuthenticationToken;
import com.emperorws.hrmanagement.mapper.UserMapper;
import com.emperorws.hrmanagement.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Author: EmperorWS
 * @Date: 2020/2/14 13:44
 * @Description: 获取当前登录用户的工具类
 **/
@Component
public class UserUtils {
    @Autowired
    private UserMapper userMapper;

    public static UserUtils userUtils;

    @PostConstruct
    public void init() {
        userUtils = this;
    }

    public static User getCurrentUser() {
        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
        WechatAuthenticationToken wechatAuthenticationToken = null;
        if(authentication instanceof WechatAuthenticationToken){
            wechatAuthenticationToken = (WechatAuthenticationToken) authentication;
            return userUtils.userMapper.findUserWithRoleByOpenid(wechatAuthenticationToken.getCredentials());
        }else{
            return ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        }
    }
}
