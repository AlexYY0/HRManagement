package com.emperorws.hrmanagement.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Employeechange {
    private Integer empcid;

    private Integer workid;

    private Integer afterdepid;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date empchandata;

    private String empchanremark;

    private Department department;

    private Employee employee;

    public Integer getEmpcid() {
        return empcid;
    }

    public void setEmpcid(Integer empcid) {
        this.empcid = empcid;
    }

    public Integer getWorkid() {
        return workid;
    }

    public void setWorkid(Integer workid) {
        this.workid = workid;
    }

    public Integer getAfterdepid() {
        return afterdepid;
    }

    public void setAfterdepid(Integer afterdepid) {
        this.afterdepid = afterdepid;
    }

    public Date getEmpchandata() {
        return empchandata;
    }

    public void setEmpchandata(Date empchandata) {
        this.empchandata = empchandata;
    }

    public String getEmpchanremark() {
        return empchanremark;
    }

    public void setEmpchanremark(String empchanremark) {
        this.empchanremark = empchanremark == null ? null : empchanremark.trim();
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
