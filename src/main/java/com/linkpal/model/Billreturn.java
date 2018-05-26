package com.linkpal.model;

import java.io.Serializable;
import java.util.Date;

public class Billreturn implements Serializable {
    private Integer fid;

    private String fnumber;

    private Date fbizdate;

    private Integer fstate;

    private String fbiztype;

    private Integer fsupplierid;

    private String fnote;

    private Integer fcreatorid;

    private Date fcreatedate;

    private Integer fauditorid;

    private Date fauditdate;

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

    public Date getFbizdate() {
        return fbizdate;
    }

    public void setFbizdate(Date fbizdate) {
        this.fbizdate = fbizdate;
    }

    public Integer getFstate() {
        return fstate;
    }

    public void setFstate(Integer fstate) {
        this.fstate = fstate;
    }

    public String getFbiztype() {
        return fbiztype;
    }

    public void setFbiztype(String fbiztype) {
        this.fbiztype = fbiztype == null ? null : fbiztype.trim();
    }

    public Integer getFsupplierid() {
        return fsupplierid;
    }

    public void setFsupplierid(Integer fsupplierid) {
        this.fsupplierid = fsupplierid;
    }

    public String getFnote() {
        return fnote;
    }

    public void setFnote(String fnote) {
        this.fnote = fnote == null ? null : fnote.trim();
    }

    public Integer getFcreatorid() {
        return fcreatorid;
    }

    public void setFcreatorid(Integer fcreatorid) {
        this.fcreatorid = fcreatorid;
    }

    public Date getFcreatedate() {
        return fcreatedate;
    }

    public void setFcreatedate(Date fcreatedate) {
        this.fcreatedate = fcreatedate;
    }

    public Integer getFauditorid() {
        return fauditorid;
    }

    public void setFauditorid(Integer fauditorid) {
        this.fauditorid = fauditorid;
    }

    public Date getFauditdate() {
        return fauditdate;
    }

    public void setFauditdate(Date fauditdate) {
        this.fauditdate = fauditdate;
    }
}