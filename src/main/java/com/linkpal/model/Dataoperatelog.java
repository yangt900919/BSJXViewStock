package com.linkpal.model;

import java.io.Serializable;
import java.util.Date;

public class Dataoperatelog implements Serializable {
    private Integer fid;

    private String fnumer;

    private Integer fbillid;

    private Integer fentryid;

    private String fuser;

    private String ftype;

    private Integer fmaterialid;

    private Integer fdataid;

    private Material material;

    private String fdataseat;

    private Date fcreatetime;

    private static final long serialVersionUID = 1L;

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getFnumer() {
        return fnumer;
    }

    public void setFnumer(String fnumer) {
        this.fnumer = fnumer == null ? null : fnumer.trim();
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

    public String getFuser() {
        return fuser;
    }

    public void setFuser(String fuser) {
        this.fuser = fuser == null ? null : fuser.trim();
    }

    public String getFtype() {
        return ftype;
    }

    public void setFtype(String ftype) {
        this.ftype = ftype == null ? null : ftype.trim();
    }

    public Integer getFmaterialid() {
        return fmaterialid;
    }

    public void setFmaterialid(Integer fmaterialid) {
        this.fmaterialid = fmaterialid;
    }

    public Integer getFdataid() {
        return fdataid;
    }

    public void setFdataid(Integer fdataid) {
        this.fdataid = fdataid;
    }

    public String getFdataseat() {
        return fdataseat;
    }

    public void setFdataseat(String fdataseat) {
        this.fdataseat = fdataseat == null ? null : fdataseat.trim();
    }

    public Date getFcreatetime() {
        return fcreatetime;
    }

    public void setFcreatetime(Date fcreatetime) {
        this.fcreatetime = fcreatetime;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }
}