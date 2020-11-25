package com.emperorws.hrmanagement.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Department implements Serializable {
    private Integer depid;

    private String depname;

    private Integer parentid;

    private String deppath;

    private Boolean enabled;

    private Boolean isparent;

    private Integer leaderid;

    private List<Department> children = new ArrayList<>();

    private Integer result;

    private String leadername;

    public Department() {
    }

    public Department(String depname) {

        this.depname = depname;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(depname, that.depname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(depname);
    }

    public Integer getDepid() {
        return this.depid;
    }

    public void setDepid(Integer depid) {
        this.depid = depid;
    }

    public String getDepname() {
        return this.depname;
    }

    public void setDepname(String depname) {
        this.depname = depname == null ? null : depname.trim();
    }

    public Integer getParentid() {
        return this.parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public String getDeppath() {
        return this.deppath;
    }

    public void setDeppath(String deppath) {
        this.deppath = deppath == null ? null : deppath.trim();
    }

    public Boolean getEnabled() {
        return this.enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getParent() {
        return this.isparent;
    }

    public void setParent(Boolean parent) {
        this.isparent = parent;
    }

    public Integer getLeaderid() {
        return this.leaderid;
    }

    public void setLeaderid(Integer leaderid) {
        this.leaderid = leaderid;
    }

    public Integer getResult() {
        return this.result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public List<Department> getChildren() {
        return this.children;
    }

    public void setChildren(List<Department> children) {
        this.children = children;
    }

    public String getLeadername() {
        return this.leadername;
    }

    public void setLeadername(String leadername) {
        this.leadername = leadername == null ? null : leadername.trim();
    }
}
