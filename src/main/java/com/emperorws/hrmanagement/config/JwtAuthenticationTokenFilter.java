package com.emperorws.hrmanagement.config;

import com.alibaba.fastjson.JSON;
import com.emperorws.hrmanagement.model.RespBean;
import com.emperorws.hrmanagement.model.Role;
import com.emperorws.hrmanagement.model.User;
import com.emperorws.hrmanagement.service.UserService;
import com.emperorws.hrmanagement.utils.RedisUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: EmperorWS
 * @Date: 2020/3/19 10:09
 * @Description: JWT令牌拦截过滤链,用来校验请求头中的jwt是否有效，以此为依据来认证用户是否登录
 **/
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    @Autowired
    UserService userService;
    @Autowired
    RedisUtil redisUtil;
    @Value("${token.expirationMilliSeconds}")
    private long expirationMilliSeconds;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");
        response.setCharacterEncoding("utf-8");
        if (null == authHeader || !authHeader.startsWith("Bearer ")){
            filterChain.doFilter(request,response);//token格式不正确
            return;
        }
        String authToken = authHeader.substring("Bearer ".length());

        if (!redisUtil.hasKey(authToken)){
            //token 不存在 返回错误信息
            response.setContentType("application/json;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.write(new ObjectMapper().writeValueAsString(RespBean.error("token错误，不存在，请重进小程序。")));
            out.flush();
            out.close();
            return;
        }
        //获取缓存中的信息
        String value=redisUtil.get(authToken);
        String[] values = value.split("---");
        String openid = values[0];
        if (openid != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            User user=userService.findUserWithRoleByOpenid(openid);
            if(null==user){
                SecurityContextHolder.getContext().setAuthentication(new WechatAuthenticationToken(openid,authToken,null));
            }else {
                List<Role> roles = user.getRoles();
                List<SimpleGrantedAuthority> authorities = roles.stream().map(role -> new SimpleGrantedAuthority(role.getEnname())).collect(Collectors.toList());
                SecurityContextHolder.getContext().setAuthentication(new WechatAuthenticationToken(openid, authToken, authorities));
            }
        }
        //更新缓存的过期时间
        if(redisUtil.ttl(authToken)<600000){
            redisUtil.expire(authToken,expirationMilliSeconds);
        }
        filterChain.doFilter(request, response);
    }
}
