package com.emperorws.hrmanagement.model;

import java.io.Serializable;
import java.util.Objects;

public class Speadd implements Serializable {
    private Integer sadid;

    private String sadname;

    private Double sadmoney;

    public Speadd(){}

    public Speadd(String sadname){
        this.sadname=sadname;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Speadd that = (Speadd) o;
        return Objects.equals(sadname, that.sadname);
    }

    @Override
    public int hashCode() {

        return Objects.hash(sadname);
    }

    public Integer getSadid() {
        return sadid;
    }

    public void setSadid(Integer sadid) {
        this.sadid = sadid;
    }

    public String getSadname() {
        return sadname;
    }

    public void setSadname(String sadname) {
        this.sadname = sadname == null ? null : sadname.trim();
    }

    public Double getSadmoney() {
        return sadmoney;
    }

    public void setSadmoney(Double sadmoney) {
        this.sadmoney = sadmoney;
    }
}
