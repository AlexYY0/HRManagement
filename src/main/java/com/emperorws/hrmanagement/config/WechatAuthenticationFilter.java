package com.emperorws.hrmanagement.config;

import com.alibaba.fastjson.JSONObject;
import com.emperorws.hrmanagement.exception.BasicException;
import com.emperorws.hrmanagement.exception.ExceptionEnum;
import com.emperorws.hrmanagement.exception.ParamException;
import com.emperorws.hrmanagement.model.WXSessionModel;
import com.emperorws.hrmanagement.utils.HttpClientUtil;
import com.emperorws.hrmanagement.utils.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Author: EmperorWS
 * @Date: 2020/3/19 11:17
 * @Description: 用于用户认证的filter，但是真正的认证逻辑会委托给{@link WechatAuthenticationManager}
 **/
public class WechatAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
    @Value("${wx.appid}")
    private String appid;
    @Value("${wx.secret}")
    private String secret;
    @Value("${token.expirationMilliSeconds}")
    private long expirationMilliSeconds;

    @Autowired
    private RedisUtil redisUtil;

    protected WechatAuthenticationFilter(String defaultFilterProcessesUrl) {
        super(defaultFilterProcessesUrl);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {
        String code = httpServletRequest.getParameter("code");
        if(StringUtils.isBlank(code)){
            throw new ParamException(ExceptionEnum.PARAM_EXCEPTION.customMessage("code is null"));
        }
        String url = "https://api.weixin.qq.com/sns/jscode2session";
        Map<String, String> param = new HashMap<>();
        param.put("appid", appid);
        param.put("secret", secret);
        param.put("js_code", code);
        param.put("grant_type", "authorization_code");
        String wxResult= HttpClientUtil.doGet(url,param);
        if(StringUtils.isBlank(wxResult)||null==wxResult){
            throw new BasicException(ExceptionEnum.WX_AUTH_FAILED.customMessage("wx auth failed"));
        }
        WXSessionModel wxSessionModel= JSONObject.parseObject(wxResult,WXSessionModel.class);

        String skey= UUID.randomUUID().toString();
        redisUtil.set(skey,wxSessionModel.getOpenid() + "---" + wxSessionModel.getSession_key(),expirationMilliSeconds);
        return this.getAuthenticationManager().authenticate(new WechatAuthenticationToken(wxSessionModel.getOpenid(),skey));
    }
}
