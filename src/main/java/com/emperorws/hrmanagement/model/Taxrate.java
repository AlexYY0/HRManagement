package com.emperorws.hrmanagement.model;

import java.io.Serializable;

public class Taxrate implements Serializable {
    private Integer trid;

    private Double trmin;

    private Double trmax;

    private Double trpercent;

    private Double quideduction;

    public Integer getTrid() {
        return trid;
    }

    public void setTrid(Integer trid) {
        this.trid = trid;
    }

    public Double getTrmin() {
        return trmin;
    }

    public void setTrmin(Double trmin) {
        this.trmin = trmin;
    }

    public Double getTrmax() {
        return trmax;
    }

    public void setTrmax(Double trmax) {
        this.trmax = trmax;
    }

    public Double getTrpercent() {
        return trpercent;
    }

    public void setTrpercent(Double trpercent) {
        this.trpercent = trpercent;
    }

    public Double getQuideduction() {
        return quideduction;
    }

    public void setQuideduction(Double quideduction) {
        this.quideduction = quideduction;
    }
}
