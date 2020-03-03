package com.emperorws.hrmanagement.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class Salaryadjustment implements Serializable {
    private Integer said;

    private Integer workid;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date sadata;

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

    public Date getSadata() {
        return sadata;
    }

    public void setSadata(Date sadata) {
        this.sadata = sadata;
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
