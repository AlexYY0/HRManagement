package com.emperorws.hrmanagement.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class Workingschedule implements Serializable {
    private Integer wsid;

    private Integer workid;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date today;

    private Integer todaysche;

    private String longitude;

    private String latitude;

    private Businesshours businesshours;

    private Attelogday attelogday;

    public Workingschedule(){
    }

    public Workingschedule(Integer workid,Date today,Integer todaysche){
        this.workid=workid;
        this.today=today;
        this.todaysche=todaysche;
    }

    public Integer getWsid() {
        return wsid;
    }

    public void setWsid(Integer wsid) {
        this.wsid = wsid;
    }

    public Integer getWorkid() {
        return workid;
    }

    public void setWorkid(Integer workid) {
        this.workid = workid;
    }

    public Date getToday() {
        return today;
    }

    public void setToday(Date today) {
        this.today = today;
    }

    public Integer getTodaysche() {
        return todaysche;
    }

    public void setTodaysche(Integer todaysche) {
        this.todaysche = todaysche;
    }

    public Businesshours getBusinesshours(){
        return this.businesshours;
    }

    public void setBusinesshours(Businesshours businesshours){
        this.businesshours=businesshours;
    }

    public Attelogday getAttelogday() {
        return this.attelogday;
    }

    public void setAttelogday(Attelogday attelogday) {
        this.attelogday = attelogday;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
}
