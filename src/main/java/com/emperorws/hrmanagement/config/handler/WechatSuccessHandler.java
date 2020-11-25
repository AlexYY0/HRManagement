package com.emperorws.hrmanagement.config.handler;

import com.alibaba.fastjson.JSON;
import com.emperorws.hrmanagement.config.WechatAuthenticationToken;
import com.emperorws.hrmanagement.mapper.UserMapper;
import com.emperorws.hrmanagement.model.RespBean;
import com.emperorws.hrmanagement.model.User;
import com.emperorws.hrmanagement.model.Wxuser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: EmperorWS
 * @Date: 2020/3/19 16:43
 * @Description: 用户认证通过的处理handler
 **/
public class WechatSuccessHandler implements AuthenticationSuccessHandler {
    @Autowired
    UserMapper userMapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        // 使用jwt管理，所以封装用户信息生成jwt响应给前端
        String token =((WechatAuthenticationToken)authentication).getSkey();
        User user=userMapper.isBind(((WechatAuthenticationToken)authentication).getOpenid());
        Wxuser wxuser=new Wxuser();
        if(null==user){
            wxuser.setIs_bind(false);
        } else{
            wxuser.setIs_bind(true);
            wxuser.setUserid(user.getUserid());
            wxuser.setEmpname(user.getEmployee().getEmpname());
        }
        wxuser.setAuthorization(token);
        httpServletResponse.getWriter().write(JSON.toJSONString(RespBean.ok("登录成功",wxuser)));
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
