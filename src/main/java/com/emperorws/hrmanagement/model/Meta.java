package com.emperorws.hrmanagement.model;

import java.io.Serializable;

/**
 * @Author: EmperorWS
 * @Date: 2020/2/14 14:12
 * @Description: 新增的Meta实体类，为后面打包成权限json准备
 **/
public class Meta implements Serializable {
    private Boolean keepalive;

    private Boolean requireauth;

    public Boolean getKeepalive() {
        return keepalive;
    }

    public void setKeepalive(Boolean keepalive) {
        this.keepalive = keepalive;
    }

    public Boolean getRequireauth() {
        return requireauth;
    }

    public void setRequireauth(Boolean requireauth) {
        this.requireauth = requireauth;
    }
}
