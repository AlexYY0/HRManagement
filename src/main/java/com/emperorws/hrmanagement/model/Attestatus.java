package com.emperorws.hrmanagement.model;

import java.io.Serializable;

public class Attestatus implements Serializable {
    private Integer attestaid;

    private String attestaname;

    public Integer getAttestaid() {
        return attestaid;
    }

    public void setAttestaid(Integer attestaid) {
        this.attestaid = attestaid;
    }

    public String getAttestaname() {
        return attestaname;
    }

    public void setAttestaname(String attestaname) {
        this.attestaname = attestaname == null ? null : attestaname.trim();
    }
}
