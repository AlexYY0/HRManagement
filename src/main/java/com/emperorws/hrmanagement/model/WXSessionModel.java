package com.emperorws.hrmanagement.model;

/**
 * @Author: EmperorWS
 * @Date: 2020/3/17 16:08
 * @Description: 自定义的用于接收微信接口返回的OpenID和Session_key
 **/
public class WXSessionModel {
    private String session_key;
    private String openid;

    public String getSession_key() {
        return session_key;
    }
    public void setSession_key(String session_key) {
        this.session_key = session_key;
    }
    public String getOpenid() {
        return openid;
    }
    public void setOpenid(String openid) {
        this.openid = openid;
    }
}
