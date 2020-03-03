package com.emperorws.hrmanagement.model;

import java.io.Serializable;

public class Treatment implements Serializable {
    private Integer tretid;

    private String tretname;

    private Double tretpercent;

    public Integer getTretid() {
        return tretid;
    }

    public void setTretid(Integer tretid) {
        this.tretid = tretid;
    }

    public String getTretname() {
        return tretname;
    }

    public void setTretname(String tretname) {
        this.tretname = tretname == null ? null : tretname.trim();
    }

    public Double getTretpercent() {
        return tretpercent;
    }

    public void setTretpercent(Double tretpercent) {
        this.tretpercent = tretpercent;
    }
}
