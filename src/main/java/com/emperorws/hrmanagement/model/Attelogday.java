package com.emperorws.hrmanagement.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class Attelogday implements Serializable {
    private Integer attelogdayid;

    private Integer workid;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date clockinday;

    @JsonFormat(pattern = "HH:mm:ss",timezone = "Asia/Shanghai")
    private Date signintime;

    @JsonFormat(pattern = "HH:mm:ss",timezone = "Asia/Shanghai")
    private Date signouttime;

    private Integer clockinflag;

    private Double needhours;

    private Double workinghours;

    private Employee employee;

    private Department department;

    private Attestatus attestatus;

    private Businesshours businesshours;

    public Integer getAttelogdayid() {
        return attelogdayid;
    }

    public void setAttelogdayid(Integer attelogdayid) {
        this.attelogdayid = attelogdayid;
    }

    public Integer getWorkid() {
        return workid;
    }

    public void setWorkid(Integer workid) {
        this.workid = workid;
    }

    public Date getClockinday() {
        return clockinday;
    }

    public void setClockinday(Date clockinday) {
        this.clockinday = clockinday;
    }

    public Date getSignintime() {
        return signintime;
    }

    public void setSignintime(Date signintime) {
        this.signintime = signintime;
    }

    public Date getSignouttime() {
        return signouttime;
    }

    public void setSignouttime(Date signouttime) {
        this.signouttime = signouttime;
    }

    public Integer getClockinflag() {
        return clockinflag;
    }

    public void setClockinflag(Integer clockinflag) {
        this.clockinflag = clockinflag;
    }

    public Double getNeedhours() {
        return needhours;
    }

    public void setNeedhours(Double needhours) {
        this.needhours = needhours;
    }

    public Double getWorkinghours() {
        return workinghours;
    }

    public void setWorkinghours(Double workinghours) {
        this.workinghours = workinghours;
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

    public Attestatus getAttestatus(){
        return this.attestatus;
    }

    public void setAttestatus(Attestatus attestatus){
        this.attestatus=attestatus;
    }

    public Businesshours getBusinesshours() {
        return this.businesshours;
    }

    public void setBusinesshours(Businesshours businesshours) {
        this.businesshours = businesshours;
    }
}
