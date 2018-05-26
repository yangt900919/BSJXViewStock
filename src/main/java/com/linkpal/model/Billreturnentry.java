package com.linkpal.model;

import java.io.Serializable;
import java.util.Date;

public class Billreturnentry implements Serializable {
    private Integer fid;

    private Integer fbillid;

    private Integer fentryid;

    private Integer fmaterialid;

    private Integer fstockid;

    private Double fqty;

    private Double freqty;

    private Date fredate;

    private String fnote;

    private static final long serialVersionUID = 1L;

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Integer getFbillid() {
        return fbillid;
    }

    public void setFbillid(Integer fbillid) {
        this.fbillid = fbillid;
    }

    public Integer getFentryid() {
        return fentryid;
    }

    public void setFentryid(Integer fentryid) {
        this.fentryid = fentryid;
    }

    public Integer getFmaterialid() {
        return fmaterialid;
    }

    public void setFmaterialid(Integer fmaterialid) {
        this.fmaterialid = fmaterialid;
    }

    public Integer getFstockid() {
        return fstockid;
    }

    public void setFstockid(Integer fstockid) {
        this.fstockid = fstockid;
    }

    public Double getFqty() {
        return fqty;
    }

    public void setFqty(Double fqty) {
        this.fqty = fqty;
    }

    public Double getFreqty() {
        return freqty;
    }

    public void setFreqty(Double freqty) {
        this.freqty = freqty;
    }

    public Date getFredate() {
        return fredate;
    }

    public void setFredate(Date fredate) {
        this.fredate = fredate;
    }

    public String getFnote() {
        return fnote;
    }

    public void setFnote(String fnote) {
        this.fnote = fnote == null ? null : fnote.trim();
    }
}