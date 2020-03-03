package com.emperorws.hrmanagement.model;

import java.io.Serializable;
import java.util.Objects;

public class Welfare implements Serializable {
    private Integer welid;

    private String welname;

    private Double traffic;

    private Double catering;

    private Double communication;

    private Double bonus;

    private Double other;

    public Welfare(){}

    public Welfare(String welname){
        this.welname=welname;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Welfare that = (Welfare) o;
        return Objects.equals(welname, that.welname);
    }

    @Override
    public int hashCode() {

        return Objects.hash(welname);
    }

    public Integer getWelid() {
        return welid;
    }

    public void setWelid(Integer welid) {
        this.welid = welid;
    }

    public String getWelname() {
        return welname;
    }

    public void setWelname(String welname) {
        this.welname = welname == null ? null : welname.trim();
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

    public Double getBonus() {
        return bonus;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }

    public Double getOther() {
        return other;
    }

    public void setOther(Double other) {
        this.other = other;
    }
}
