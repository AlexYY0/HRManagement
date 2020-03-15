package com.emperorws.hrmanagement.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class Appatt implements Serializable {
    private Integer aatid;

    private Integer workid;

    private String category;

    private String reason;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "Asia/Shanghai")
    private Date appbegindate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "Asia/Shanghai")
    private Date appenddate;

    private Integer total;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "Asia/Shanghai")
    private Date appdate;

    private Boolean issubmit;

    private Boolean isapprove;

    private Employee employee;

    private Department department;

    public Integer getAatid() {
        return aatid;
    }

    public void setAatid(Integer aatid) {
        this.aatid = aatid;
    }

    public Integer getWorkid() {
        return workid;
    }

    public void setWorkid(Integer workid) {
        this.workid = workid;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public Date getAppbegindate() {
        return appbegindate;
    }

    public void setAppbegindate(Date appbegindate) {
        this.appbegindate = appbegindate;
    }

    public Date getAppenddate() {
        return appenddate;
    }

    public void setAppenddate(Date appenddate) {
        this.appenddate = appenddate;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Date getAppdate() {
        return appdate;
    }

    public void setAppdate(Date appdate) {
        this.appdate = appdate;
    }

    public Boolean getIssubmit() {
        return issubmit;
    }

    public void setIssubmit(Boolean issubmit) {
        this.issubmit = issubmit;
    }

    public Boolean getIsapprove() {
        return isapprove;
    }

    public void setIsapprove(Boolean isapprove) {
        this.isapprove = isapprove;
    }

    public Employee getEmployee(){
        return this.employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Department getDepartment() {
        return this.department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
