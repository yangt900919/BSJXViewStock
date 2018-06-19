package com.linkpal.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Inv implements Serializable {
    private Integer fid;

    private String fname;

    private String fdate;

    private Integer fstate;

    private Date fcreatetime;

    private List<Inventry> inventries;

    private static final long serialVersionUID = 1L;

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname == null ? null : fname.trim();
    }

    public String getFdate() {
        return fdate;
    }

    public void setFdate(String fdate) {
        this.fdate = fdate == null ? null : fdate.trim();
    }

    public Integer getFstate() {
        return fstate;
    }

    public void setFstate(Integer fstate) {
        this.fstate = fstate;
    }

    public Date getFcreatetime() {
        return fcreatetime;
    }

    public void setFcreatetime(Date fcreatetime) {
        this.fcreatetime = fcreatetime;
    }

    public List<Inventry> getInventries() {
        return inventries;
    }

    public void setInventries(List<Inventry> inventries) {
        this.inventries = inventries;
    }
}