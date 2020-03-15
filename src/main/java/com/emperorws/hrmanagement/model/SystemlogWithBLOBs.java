package com.emperorws.hrmanagement.model;

public class SystemlogWithBLOBs extends Systemlog {
    private String logcontent;

    private String description;

    public String getLogcontent() {
        return logcontent;
    }

    public void setLogcontent(String logcontent) {
        this.logcontent = logcontent == null ? null : logcontent.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}