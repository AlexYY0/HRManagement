package com.emperorws.hrmanagement.config;

import com.emperorws.hrmanagement.exception.BasicException;
import com.emperorws.hrmanagement.exception.ExceptionEnum;
import com.emperorws.hrmanagement.model.Role;
import com.emperorws.hrmanagement.model.User;
import com.emperorws.hrmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: EmperorWS
 * @Date: 2020/3/19 13:47
 * @Description: 真正执行认证逻辑的manager, {@link WechatAuthenticationFilter}会将认证委托给{@link WechatAuthenticationManager}来做
 **/
@Component
public class WechatAuthenticationManager implements AuthenticationManager {
    @Autowired
    UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        WechatAuthenticationToken wechatAuthenticationToken = null;
        if(authentication instanceof WechatAuthenticationToken){
            wechatAuthenticationToken = (WechatAuthenticationToken) authentication;
        }
        User user=userService.findUserWithRoleByOpenid(wechatAuthenticationToken.getOpenid());
        if(null==user){
            return new WechatAuthenticationToken(wechatAuthenticationToken.getOpenid(),wechatAuthenticationToken.getSkey(),null);
        }
        List<Role> roles=user.getRoles();
        List<SimpleGrantedAuthority> authorities = roles.stream().map(role -> new SimpleGrantedAuthority(role.getEnname())).collect(Collectors.toList());
        return new WechatAuthenticationToken(wechatAuthenticationToken.getOpenid(),wechatAuthenticationToken.getSkey(),authorities);
    }
}
