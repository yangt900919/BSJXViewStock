package com.linkpal.model;

import java.io.Serializable;
import java.util.Date;

public class Operatelog implements Serializable {
    private Integer fid;

    private String fnumer;

    private Integer fbillid;

    private Integer fentryid;

    private String fuser;

    private Date fdate;

    private String ftype;

    private Integer fmaterialid;

    private Material material;

    private Double fqty;

    private Double facqty;

    private String fstock;

    private String ferpstock;

    private String fgoodseat;

    private String fmdate;

    private Double fgperiod;

    private String fsrcNumber;

    private String fbatch;

    private Integer fsrc_billid;

    private Integer fsrc_entryid;

    private String fdeviceid;

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

    public Date getFdate() {
        return fdate;
    }

    public void setFdate(Date fdate) {
        this.fdate = fdate;
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

    public Double getFqty() {
        return fqty;
    }

    public void setFqty(Double fqty) {
        this.fqty = fqty;
    }

    public Double getFacqty() {
        return facqty;
    }

    public void setFacqty(Double facqty) {
        this.facqty = facqty;
    }

    public String getFstock() {
        return fstock;
    }

    public void setFstock(String fstock) {
        this.fstock = fstock == null ? null : fstock.trim();
    }

    public String getFgoodseat() {
        return fgoodseat;
    }

    public void setFgoodseat(String fgoodseat) {
        this.fgoodseat = fgoodseat == null ? null : fgoodseat.trim();
    }

    public String getFmdate() {
        return fmdate;
    }

    public void setFmdate(String fmdate) {
        this.fmdate = fmdate;
    }

    public Double getFgperiod() {
        return fgperiod;
    }

    public void setFgperiod(Double fgperiod) {
        this.fgperiod = fgperiod;
    }

    public String getFsrcNumber() {
        return fsrcNumber;
    }

    public void setFsrcNumber(String fsrcNumber) {
        this.fsrcNumber = fsrcNumber == null ? null : fsrcNumber.trim();
    }

    public String getFdeviceid() {
        return fdeviceid;
    }

    public void setFdeviceid(String fdeviceid) {
        this.fdeviceid = fdeviceid == null ? null : fdeviceid.trim();
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

    public String getFbatch() {
        return fbatch;
    }

    public void setFbatch(String fbatch) {
        this.fbatch = fbatch;
    }

    public Integer getFsrc_billid() {
        return fsrc_billid;
    }

    public void setFsrc_billid(Integer fsrc_billid) {
        this.fsrc_billid = fsrc_billid;
    }

    public Integer getFsrc_entryid() {
        return fsrc_entryid;
    }

    public void setFsrc_entryid(Integer fsrc_entryid) {
        this.fsrc_entryid = fsrc_entryid;
    }

    public String getFerpstock() {
        return ferpstock;
    }

    public void setFerpstock(String ferpstock) {
        this.ferpstock = ferpstock;
    }
}