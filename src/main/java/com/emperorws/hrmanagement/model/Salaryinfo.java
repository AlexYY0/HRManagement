package com.emperorws.hrmanagement.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class Salaryinfo implements Serializable {
    private Integer siid;

    private Integer workid;

    private Double basicsalary;

    private Double absenteeism;

    private Double overtime;

    private Double busitrip;

    private Double endowment;

    private Double medical;

    private Double unemployment;

    private Double injury;

    private Double maternity;

    private Double addmedical;

    private Double housing;

    private Double enterprisep;

    private Double childedu;

    private Double conedu;

    private Double sermedical;

    private Double housingloan;

    private Double rental;

    private Double supportold;

    private Double traffic;

    private Double catering;

    private Double communication;

    private Double other;

    private Double bonus;

    private Double sums;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date salfirstday;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date salendday;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "Asia/Shanghai")
    private Date payoffdate;

    private Employee employee;

    private Department department;

    public Integer getSiid() {
        return siid;
    }

    public void setSiid(Integer siid) {
        this.siid = siid;
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

    public Double getAbsenteeism() {
        return absenteeism;
    }

    public void setAbsenteeism(Double absenteeism) {
        this.absenteeism = absenteeism;
    }

    public Double getOvertime() {
        return overtime;
    }

    public void setOvertime(Double overtime) {
        this.overtime = overtime;
    }

    public Double getBusitrip() {
        return busitrip;
    }

    public void setBusitrip(Double busitrip) {
        this.busitrip = busitrip;
    }

    public Double getEndowment() {
        return endowment;
    }

    public void setEndowment(Double endowment) {
        this.endowment = endowment;
    }

    public Double getMedical() {
        return medical;
    }

    public void setMedical(Double medical) {
        this.medical = medical;
    }

    public Double getUnemployment() {
        return unemployment;
    }

    public void setUnemployment(Double unemployment) {
        this.unemployment = unemployment;
    }

    public Double getInjury() {
        return injury;
    }

    public void setInjury(Double injury) {
        this.injury = injury;
    }

    public Double getMaternity() {
        return maternity;
    }

    public void setMaternity(Double maternity) {
        this.maternity = maternity;
    }

    public Double getAddmedical() {
        return addmedical;
    }

    public void setAddmedical(Double addmedical) {
        this.addmedical = addmedical;
    }

    public Double getHousing() {
        return housing;
    }

    public void setHousing(Double housing) {
        this.housing = housing;
    }

    public Double getEnterprisep() {
        return enterprisep;
    }

    public void setEnterprisep(Double enterprisep) {
        this.enterprisep = enterprisep;
    }

    public Double getChildedu() {
        return childedu;
    }

    public void setChildedu(Double childedu) {
        this.childedu = childedu;
    }

    public Double getConedu() {
        return conedu;
    }

    public void setConedu(Double conedu) {
        this.conedu = conedu;
    }

    public Double getSermedical() {
        return sermedical;
    }

    public void setSermedical(Double sermedical) {
        this.sermedical = sermedical;
    }

    public Double getHousingloan() {
        return housingloan;
    }

    public void setHousingloan(Double housingloan) {
        this.housingloan = housingloan;
    }

    public Double getRental() {
        return rental;
    }

    public void setRental(Double rental) {
        this.rental = rental;
    }

    public Double getSupportold() {
        return supportold;
    }

    public void setSupportold(Double supportold) {
        this.supportold = supportold;
    }

    public Double getTraffic() {
        return traffic;
    }

    public void setTraffic(Double traffic) {
        this.traffic = traffic;
    }

    public Double getCatering() {
        return catering;
    }

    public void setCatering(Double catering) {
        this.catering = catering;
    }

    public Double getCommunication() {
        return communication;
    }

    public void setCommunication(Double communication) {
        this.communication = communication;
    }

    public Double getOther() {
        return other;
    }

    public void setOther(Double other) {
        this.other = other;
    }

    public Double getBonus() {
        return bonus;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }

    public Double getSums() {
        return sums;
    }

    public void setSums(Double sums) {
        this.sums = sums;
    }

    public Date getSalfirstday() {
        return salfirstday;
    }

    public void setSalfirstday(Date salfirstday) {
        this.salfirstday = salfirstday;
    }

    public Date getSaendday() {
        return salendday;
    }

    public void setSaendday(Date salendday) {
        this.salendday = salendday;
    }

    public Date getPayoffdate() {
        return payoffdate;
    }

    public void setPayoffdate(Date payoffdate) {
        this.payoffdate = payoffdate;
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
