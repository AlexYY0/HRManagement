package com.emperorws.hrmanagement.config;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @Author: EmperorWS
 * @Date: 2020/3/19 11:13
 * @Description: 自定义的微信小程序验证Token结构
 **/
public class WechatAuthenticationToken extends AbstractAuthenticationToken {
    private String openid;
    private String skey;

    public WechatAuthenticationToken(String openid,String skey) {
        super(null);
        this.openid=openid;
        this.skey=skey;
    }

    public WechatAuthenticationToken(String openid, String skey, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.openid = openid;
        this.skey = skey;
        super.setAuthenticated(true);
    }

    public WechatAuthenticationToken(String openid, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.openid=openid;
        super.setAuthenticated(true); // must use super, as we override
    }

    @Override
    public String getCredentials() {
        return this.openid;
    }

    @Override
    public Object getPrincipal() {
        return this.skey;
    }

    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        if (isAuthenticated) {
            throw new IllegalArgumentException(
                    "Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");
        }
        super.setAuthenticated(false);
    }

    @Override
    public void eraseCredentials() {
        super.eraseCredentials();
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getSkey() {
        return skey;
    }

    public void setSkey(String skey) {
        this.skey = skey;
    }
}
