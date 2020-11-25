package com.emperorws.hrmanagement.model;

import java.io.Serializable;

/**
 * @Author: EmperorWS
 * @Date: 2020/3/18 11:43
 * @Description: 自定义返回的微信实体类
 **/
public class Wxuser implements Serializable {

    private String Authorization;

    private Boolean is_bind;

    private Integer userid;

    private String empname;

    public Wxuser(){
    }

    public Wxuser(String Authorization,Integer usserid,String empname){
        this.Authorization=Authorization;
        this.userid=usserid;
        this.empname=empname;
    }

    public String getAuthorization() {
        return this.Authorization;
    }

    public void setAuthorization(String Authorization) {
        this.Authorization = Authorization;
    }

    public Boolean getIs_bind() {
        return this.is_bind;
    }

    public void setIs_bind(Boolean is_bind) {
        this.is_bind = is_bind;
    }

    public Integer getUserid() {
        return this.userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getEmpname() {
        return this.empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }
}
