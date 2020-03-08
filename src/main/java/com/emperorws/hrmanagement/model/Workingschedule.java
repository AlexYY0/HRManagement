package com.emperorws.hrmanagement.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class Workingschedule implements Serializable {
    private Integer wsid;

    private Integer workid;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date firstofweek;

    private Integer sun;

    private Integer mon;

    private Integer tue;

    private Integer wed;

    private Integer thu;

    private Integer fri;

    private Integer sat;

    private Employee employee;

    private Department department;

    private Businesshours businesshours1;

    private Businesshours businesshours2;

    private Businesshours businesshours3;

    private Businesshours businesshours4;

    private Businesshours businesshours5;

    private Businesshours businesshours6;

    private Businesshours businesshours7;

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

    public Date getFirstofweek() {
        return firstofweek;
    }

    public void setFirstofweek(Date firstofweek) {
        this.firstofweek = firstofweek;
    }

    public Integer getSun() {
        return sun;
    }

    public void setSun(Integer sun) {
        this.sun = sun;
    }

    public Integer getMon() {
        return mon;
    }

    public void setMon(Integer mon) {
        this.mon = mon;
    }

    public Integer getTue() {
        return tue;
    }

    public void setTue(Integer tue) {
        this.tue = tue;
    }

    public Integer getWed() {
        return wed;
    }

    public void setWed(Integer wed) {
        this.wed = wed;
    }

    public Integer getThu() {
        return thu;
    }

    public void setThu(Integer thu) {
        this.thu = thu;
    }

    public Integer getFri() {
        return fri;
    }

    public void setFri(Integer fri) {
        this.fri = fri;
    }

    public Integer getSat() {
        return sat;
    }

    public void setSat(Integer sat) {
        this.sat = sat;
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

    public Businesshours getBusinesshours1(){
        return this.businesshours1;
    }

    public void setBusinesshours1(Businesshours businesshours1){
        this.businesshours1=businesshours1;
    }

    public Businesshours getBusinesshours2(){
        return this.businesshours2;
    }

    public void setBusinesshours2(Businesshours businesshours2){
        this.businesshours2=businesshours2;
    }

    public Businesshours getBusinesshours3(){
        return this.businesshours3;
    }

    public void setBusinesshours3(Businesshours businesshours3){
        this.businesshours3=businesshours3;
    }

    public Businesshours getBusinesshours4(){
        return this.businesshours4;
    }

    public void setBusinesshours4(Businesshours businesshours4){
        this.businesshours4=businesshours4;
    }

    public Businesshours getBusinesshours5(){
        return this.businesshours5;
    }

    public void setBusinesshours5(Businesshours businesshours5){
        this.businesshours5=businesshours5;
    }

    public Businesshours getBusinesshours6(){
        return this.businesshours6;
    }

    public void setBusinesshours6(Businesshours businesshours6){
        this.businesshours6=businesshours6;
    }

    public Businesshours getBusinesshours7(){
        return this.businesshours7;
    }

    public void setBusinesshours7(Businesshours businesshours7){
        this.businesshours7=businesshours7;
    }
}
