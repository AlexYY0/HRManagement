package com.emperorws.hrmanagement.config;

import com.emperorws.hrmanagement.config.handler.WechatSuccessHandler;
import com.emperorws.hrmanagement.exception.BasicException;
import com.emperorws.hrmanagement.exception.ExceptionEnum;
import com.emperorws.hrmanagement.exception.NotLoginException;
import com.emperorws.hrmanagement.model.RespBean;
import com.emperorws.hrmanagement.model.User;
import com.emperorws.hrmanagement.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: EmperorWS
 * @Date: 2020/2/14 16:46
 * @Description: SpringBoot Security的配置类，配置用户登录，登出的访问控制权限
 **/
@Configuration
public class MultiSecurityConfig {
    @Configuration
    @Order(1)
    public static class WechatConfigurerAdapter extends WebSecurityConfigurerAdapter{
        @Autowired
        CustomFilterInvocationSecurityMetadataSource customFilterInvocationSecurityMetadataSource;
        @Autowired
        CustomUrlDecisionManager customUrlDecisionManager;

        @Autowired
        private WechatAuthenticationManager wechatAuthenticationManager;
        @Bean
        public WechatAuthenticationFilter wechatAuthenticationFilter(){
            WechatAuthenticationFilter wechatAuthenticationFilter = new WechatAuthenticationFilter("/wechatapi/wxlogin");
            wechatAuthenticationFilter.setAuthenticationManager(wechatAuthenticationManager);
            wechatAuthenticationFilter.setAuthenticationSuccessHandler(wechatSuccessHandler());
            return wechatAuthenticationFilter;
        }
        @Bean
        public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter(){
            return new JwtAuthenticationTokenFilter();
        }
        @Bean
        public WechatSuccessHandler wechatSuccessHandler(){
            return new WechatSuccessHandler();
        }

        @Override
        public void configure(WebSecurity web) throws Exception {
            web.ignoring().antMatchers("/login","/css/**","/js/**","/index.html","/img/**","/fonts/**","/favicon.ico","/verifyCode");
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            // 使用WxAppletAuthenticationFilter替换默认的认证过滤器UsernamePasswordAuthenticationFilter
            http.addFilterAt(wechatAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                    // 在WxAppletAuthenticationFilter前面添加用于验证jwt，识别用户是否登录的过滤器
                    .addFilterBefore(jwtAuthenticationTokenFilter(), WechatAuthenticationFilter.class);
            http.csrf()
                    .disable()
                    .sessionManagement()
                    // 不创建Session, 使用jwt来管理用户的登录状态
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and()
                    .antMatcher("/wechatapi/**")
                    .authorizeRequests()
                        .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                            @Override
                            public <O extends FilterSecurityInterceptor> O postProcess(O object) {
                                object.setAccessDecisionManager(customUrlDecisionManager);
                                object.setSecurityMetadataSource(customFilterInvocationSecurityMetadataSource);
                                return object;
                            }
                        })
                    .anyRequest().authenticated()
                    .and()
                    .exceptionHandling()
                    //没有认证时，在这里处理结果，不要重定向
                    .authenticationEntryPoint(new AuthenticationEntryPoint(){
                        @Override
                        public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
                            throw new NotLoginException(ExceptionEnum.NOT_LOGIN);
                        }
                    })
                    .accessDeniedHandler(new AccessDeniedHandler() {
                        @Override
                        public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
                            // 删除框架抛出的异常，改为自定义异常
                            httpServletRequest.removeAttribute("org.springframework.boot.web.servlet.error.DefaultErrorAttributes.ERROR");
                            throw new BasicException(ExceptionEnum.ACCESS_DENIED);
                        }
                    });
        }
    }

    @Configuration
    public static class WebConfigurerAdapter extends WebSecurityConfigurerAdapter{
        @Autowired
        UserService userService;
        @Autowired
        CustomFilterInvocationSecurityMetadataSource customFilterInvocationSecurityMetadataSource;
        @Autowired
        CustomUrlDecisionManager customUrlDecisionManager;
        @Autowired
        VerificationCodeFilter verificationCodeFilter;

        @Bean
        PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userService);
        }

        @Override
        public void configure(WebSecurity web) throws Exception {
            web.ignoring().antMatchers("/login","/css/**","/js/**","/index.html","/img/**","/fonts/**","/favicon.ico","/verifyCode");
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.addFilterBefore(verificationCodeFilter, UsernamePasswordAuthenticationFilter.class);
            http.authorizeRequests()
                    .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                        @Override
                        public <O extends FilterSecurityInterceptor> O postProcess(O object) {
                            object.setAccessDecisionManager(customUrlDecisionManager);
                            object.setSecurityMetadataSource(customFilterInvocationSecurityMetadataSource);
                            return object;
                        }
                    })
                    .and()
                    .formLogin()
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .loginProcessingUrl("/doLogin")
                    .loginPage("/login")
                    .successHandler(new AuthenticationSuccessHandler() {
                        @Override
                        public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication authentication) throws IOException, ServletException {
                            resp.setContentType("application/json;charset=utf-8");
                            PrintWriter out = resp.getWriter();
                            User user = (User) authentication.getPrincipal();
                            user.setPassword(null);
                            user.setOpenid(null);
                            RespBean ok = RespBean.ok("登录成功!", user);
                            String s = new ObjectMapper().writeValueAsString(ok);
                            out.write(s);
                            out.flush();
                            out.close();
                        }
                    })
                    .failureHandler(new AuthenticationFailureHandler() {
                        @Override
                        public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse resp, AuthenticationException exception) throws IOException, ServletException {
                            resp.setContentType("application/json;charset=utf-8");
                            PrintWriter out = resp.getWriter();
                            RespBean respBean = RespBean.error("登录失败!");
                            if (exception instanceof LockedException) {
                                respBean.setMsg("账户被锁定，请联系管理员!");
                            } else if (exception instanceof CredentialsExpiredException) {
                                respBean.setMsg("密码过期，请联系管理员!");
                            } else if (exception instanceof AccountExpiredException) {
                                respBean.setMsg("账户过期，请联系管理员!");
                            } else if (exception instanceof DisabledException) {
                                respBean.setMsg("账户被禁用，请联系管理员!");
                            } else if (exception instanceof BadCredentialsException) {
                                respBean.setMsg("用户名或者密码输入错误，请重新输入!");
                            }
                            out.write(new ObjectMapper().writeValueAsString(respBean));
                            out.flush();
                            out.close();
                        }
                    })
                    .permitAll()
                    .and()
                    .logout()
                    .logoutSuccessHandler(new LogoutSuccessHandler() {
                        @Override
                        public void onLogoutSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication authentication) throws IOException, ServletException {
                            resp.setContentType("application/json;charset=utf-8");
                            PrintWriter out = resp.getWriter();
                            out.write(new ObjectMapper().writeValueAsString(RespBean.ok("注销成功!")));
                            out.flush();
                            out.close();
                        }
                    })
                    .permitAll()
                    .and()
                    .csrf().disable().exceptionHandling()
                    //没有认证时，在这里处理结果，不要重定向
                    .authenticationEntryPoint(new AuthenticationEntryPoint() {
                        @Override
                        public void commence(HttpServletRequest req, HttpServletResponse resp, AuthenticationException authException) throws IOException, ServletException {
                            resp.setContentType("application/json;charset=utf-8");
                            resp.setStatus(401);
                            PrintWriter out = resp.getWriter();
                            RespBean respBean = RespBean.error("访问失败!");
                            if (authException instanceof InsufficientAuthenticationException) {
                                respBean.setMsg("请求失败，请联系管理员!");
                            }
                            out.write(new ObjectMapper().writeValueAsString(respBean));
                            out.flush();
                            out.close();
                        }
                    });
            http.sessionManagement()
                    .maximumSessions(1)
                    .expiredUrl("/login");
        }
    }
}
