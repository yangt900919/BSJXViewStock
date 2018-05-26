package com.linkpal.model;

import java.io.Serializable;

public class Department implements Serializable {
    private Integer fid;

    private String fnumber;

    private String fname;

    private String fstock;

    private static final long serialVersionUID = 1L;

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getFnumber() {
        return fnumber;
    }

    public void setFnumber(String fnumber) {
        this.fnumber = fnumber == null ? null : fnumber.trim();
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname == null ? null : fname.trim();
    }

    public String getFstock() {
        return fstock;
    }

    public void setFstock(String fstock) {
        this.fstock = fstock == null ? null : fstock.trim();
    }
}