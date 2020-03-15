package com.emperorws.hrmanagement.model;

import java.io.Serializable;

public class Salaryscheme implements Serializable {
    private Integer ssid;

    private String ssname;

    private String compmethod;

    public Integer getSsid() {
        return ssid;
    }

    public void setSsid(Integer ssid) {
        this.ssid = ssid;
    }

    public String getSsname() {
        return ssname;
    }

    public void setSsname(String ssname) {
        this.ssname = ssname == null ? null : ssname.trim();
    }

    public String getCompmethod() {
        return compmethod;
    }

    public void setCompmethod(String compmethod) {
        this.compmethod = compmethod == null ? null : compmethod.trim();
    }
}
