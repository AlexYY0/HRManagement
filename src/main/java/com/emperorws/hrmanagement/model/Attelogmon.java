package com.emperorws.hrmanagement.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class Attelogmon implements Serializable {
    private Integer attelogmonid;

    private Integer workid;

    private Double totalh;

    private Double normalh;

    private Double absenth;

    private Double leaveh;

    private Double vacateh;

    private Double businessh;

    private Double overtimeh;

    private Employee employee;

    private Department department;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date firstday;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date endday;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "Asia/Shanghai")
    private Date caldate;

    public Integer getAttelogmonid() {
        return attelogmonid;
    }

    public void setAttelogmonid(Integer attelogmonid) {
        this.attelogmonid = attelogmonid;
    }

    public Integer getWorkid() {
        return workid;
    }

    public void setWorkid(Integer workid) {
        this.workid = workid;
    }

    public Double getTotalh() {
        return totalh;
    }

    public void setTotalh(Double totalh) {
        this.totalh = totalh;
    }

    public Double getNormalh() {
        return normalh;
    }

    public void setNormalh(Double normalh) {
        this.normalh = normalh;
    }

    public Double getAbsenth() {
        return absenth;
    }

    public void setAbsenth(Double absenth) {
        this.absenth = absenth;
    }

    public Double getLeaveh() {
        return leaveh;
    }

    public void setLeaveh(Double leaveh) {
        this.leaveh = leaveh;
    }

    public Double getVacateh() {
        return vacateh;
    }

    public void setVacateh(Double vacateh) {
        this.vacateh = vacateh;
    }

    public Double getBusinessh() {
        return businessh;
    }

    public void setBusinessh(Double businessh) {
        this.businessh = businessh;
    }

    public Double getOvertimeh() {
        return overtimeh;
    }

    public void setOvertimeh(Double overtimeh) {
        this.overtimeh = overtimeh;
    }

    public Date getFirstday() {
        return firstday;
    }

    public void setFirstday(Date firstday) {
        this.firstday = firstday;
    }

    public Date getEndday() {
        return endday;
    }

    public void setEndday(Date endday) {
        this.endday = endday;
    }

    public Date getCaldate() {
        return caldate;
    }

    public void setCaldate(Date caldate) {
        this.caldate = caldate;
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
