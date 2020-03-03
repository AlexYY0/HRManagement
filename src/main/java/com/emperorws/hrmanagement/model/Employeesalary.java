package com.emperorws.hrmanagement.model;

import java.io.Serializable;

public class Employeesalary implements Serializable {
    private Integer esid;

    private Integer workid;

    private Double basicsalary;

    private Boolean endowment;

    private Boolean medical;

    private Boolean unemployment;

    private Boolean injury;

    private Boolean maternity;

    private Boolean addmedical;

    private Boolean housing;

    private Boolean enterprisep;

    private Integer welid;

    private Integer childedu;

    private Integer conedu;

    private Integer sermedical;

    private Integer housingloan;

    private Integer rental;

    private Integer supportold;

    private Employee employee;

    private Department department;

    private Speadd speadd1;

    private Speadd speadd2;

    private Speadd speadd3;

    private Speadd speadd4;

    private Speadd speadd5;

    private Speadd speadd6;

    private Welfare welfare;

    public Integer getEsid() {
        return esid;
    }

    public void setEsid(Integer esid) {
        this.esid = esid;
    }

    public Integer getWorkid() {
        return workid;
    }

    public void setWorkid(Integer workid) {
        this.workid = workid;
    }

    public Double getBasicsalary() {
        return basicsalary;
    }

    public void setBasicsalary(Double basicsalary) {
        this.basicsalary = basicsalary;
    }

    public Boolean getEndowment() {
        return endowment;
    }

    public void setEndowment(Boolean endowment) {
        this.endowment = endowment;
    }

    public Boolean getMedical() {
        return medical;
    }

    public void setMedical(Boolean medical) {
        this.medical = medical;
    }

    public Boolean getUnemployment() {
        return unemployment;
    }

    public void setUnemployment(Boolean unemployment) {
        this.unemployment = unemployment;
    }

    public Boolean getInjury() {
        return injury;
    }

    public void setInjury(Boolean injury) {
        this.injury = injury;
    }

    public Boolean getMaternity() {
        return maternity;
    }

    public void setMaternity(Boolean maternity) {
        this.maternity = maternity;
    }

    public Boolean getAddmedical() {
        return addmedical;
    }

    public void setAddmedical(Boolean addmedical) {
        this.addmedical = addmedical;
    }

    public Boolean getHousing() {
        return housing;
    }

    public void setHousing(Boolean housing) {
        this.housing = housing;
    }

    public Boolean getEnterprisep() {
        return enterprisep;
    }

    public void setEnterprisep(Boolean enterprisep) {
        this.enterprisep = enterprisep;
    }

    public Integer getWelid() {
        return welid;
    }

    public void setWelid(Integer welid) {
        this.welid = welid;
    }

    public Integer getChildedu() {
        return childedu;
    }

    public void setChildedu(Integer childedu) {
        this.childedu = childedu;
    }

    public Integer getConedu() {
        return conedu;
    }

    public void setConedu(Integer conedu) {
        this.conedu = conedu;
    }

    public Integer getSermedical() {
        return sermedical;
    }

    public void setSermedical(Integer sermedical) {
        this.sermedical = sermedical;
    }

    public Integer getHousingloan() {
        return housingloan;
    }

    public void setHousingloan(Integer housingloan) {
        this.housingloan = housingloan;
    }

    public Integer getRental() {
        return rental;
    }

    public void setRental(Integer rental) {
        this.rental = rental;
    }

    public Integer getSupportold() {
        return supportold;
    }

    public void setSupportold(Integer supportold) {
        this.supportold = supportold;
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

    public Speadd getSpeadd1(){
        return this.speadd1;
    }

    public void setSpeadd1(Speadd speadd1){
        this.speadd1=speadd1;
    }

    public Speadd getSpeadd2(){
        return this.speadd2;
    }

    public void setSpeadd2(Speadd speadd2){
        this.speadd2=speadd2;
    }

    public Speadd getSpeadd3(){
        return this.speadd3;
    }

    public void setSpeadd3(Speadd speadd3){
        this.speadd3=speadd3;
    }

    public Speadd getSpeadd4(){
        return this.speadd4;
    }

    public void setSpeadd4(Speadd speadd4){
        this.speadd4=speadd4;
    }

    public Speadd getSpeadd5(){
        return this.speadd5;
    }

    public void setSpeadd5(Speadd speadd5){
        this.speadd5=speadd5;
    }

    public Speadd getSpeadd6(){
        return this.speadd6;
    }

    public void setSpeadd6(Speadd speadd6){
        this.speadd6=speadd6;
    }

    public Welfare getWelfare(){
        return this.welfare;
    }

    public void setWelfare(Welfare welfare) {
        this.welfare = welfare;
    }
}
