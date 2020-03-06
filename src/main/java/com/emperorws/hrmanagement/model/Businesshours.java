package com.emperorws.hrmanagement.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class Businesshours implements Serializable {
    private Integer busihoursid;

    private String busihoursname;

    @JsonFormat(pattern = "HH:mm:ss",timezone = "Asia/Shanghai")
    private Date begintime;

    @JsonFormat(pattern = "HH:mm:ss",timezone = "Asia/Shanghai")
    private Date endtime;

    public Integer getBusihoursid() {
        return busihoursid;
    }

    public void setBusihoursid(Integer busihoursid) {
        this.busihoursid = busihoursid;
    }

    public String getBusihoursname() {
        return busihoursname;
    }

    public void setBusihoursname(String busihoursname) {
        this.busihoursname = busihoursname == null ? null : busihoursname.trim();
    }

    public Date getBegintime() {
        return begintime;
    }

    public void setBegintime(Date begintime) {
        this.begintime = begintime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }
}
