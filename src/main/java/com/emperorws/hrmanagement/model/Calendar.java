package com.emperorws.hrmanagement.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class Calendar implements Serializable {
    private Integer caleid;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date date;

    private Byte status;

    public Integer getCaleid() {
        return caleid;
    }

    public void setCaleid(Integer caleid) {
        this.caleid = caleid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}
