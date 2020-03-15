package com.emperorws.hrmanagement.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class Salaryadjustment implements Serializable {
    private Integer said;

    private Integer workid;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "Asia/Shanghai")
    private Date sadate;

    private String saremark;

    private Employee employee;

    public Integer getSaid() {
        return said;
    }

    public void setSaid(Integer said) {
        this.said = said;
    }

    public Integer getWorkid() {
        return workid;
    }

    public void setWorkid(Integer workid) {
        this.workid = workid;
    }

    public Date getSadate() {
        return sadate;
    }

    public void setSadate(Date sadate) {
        this.sadate = sadate;
    }

    public String getSaremark() {
        return saremark;
    }

    public void setSaremark(String saremark) {
        this.saremark = saremark == null ? null : saremark.trim();
    }

    public Employee getEmployee() {
        return this.employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
