package com.linkpal.model;

import java.io.Serializable;
import java.util.Date;

public class Datacabinettype implements Serializable {
    private Integer fid;

    private String fnumber;

    private String fname;

    private Integer frows;

    private Integer fcolumns;

    private String fremark;

    private Date fcreatetime;

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

    public Integer getFrows() {
        return frows;
    }

    public void setFrows(Integer frows) {
        this.frows = frows;
    }

    public Integer getFcolumns() {
        return fcolumns;
    }

    public void setFcolumns(Integer fcolumns) {
        this.fcolumns = fcolumns;
    }

    public String getFremark() {
        return fremark;
    }

    public void setFremark(String fremark) {
        this.fremark = fremark == null ? null : fremark.trim();
    }

    public Date getFcreatetime() {
        return fcreatetime;
    }

    public void setFcreatetime(Date fcreatetime) {
        this.fcreatetime = fcreatetime;
    }
}