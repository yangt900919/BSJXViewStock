package com.linkpal.model;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Date;

public class Billorderentry implements Serializable {
    private Integer fid;

    private Integer fbillid;

    private Integer fentriyid;

    private Integer fmaid;

    private Material material;

    private Integer fstockid;

    private  ERPStock stock;

    private Double fqty;

    private Integer fstate;

    private String fbrand;

    private String fqulity;

    private Date fdeldate;

    private String fcontnum;

    private Double freceiptqty;

    private Double funreceiptqty;

    private Double frefoundqty;

    private Double fstoredqty;

    private String fjudgetype;

    private Double fprice;

    private String fcurrency;

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

    public Integer getFentriyid() {
        return fentriyid;
    }

    public void setFentriyid(Integer fentriyid) {
        this.fentriyid = fentriyid;
    }

    public Integer getFmaid() {
        return fmaid;
    }

    public void setFmaid(Integer fmaid) {
        this.fmaid = fmaid;
    }

    public Integer getFstockid() {
        return fstockid;
    }

    public void setFstockid(Integer fstockid) {
        this.fstockid = fstockid;
    }

    public Double getFqty() {
        return Double.valueOf(new DecimalFormat("0.000000").format(fqty));
    }

    public void setFqty(Double fqty) {
        this.fqty = fqty;
    }

    public Integer getFstate() {
        return fstate;
    }

    public void setFstate(Integer fstate) {
        this.fstate = fstate;
    }

    public String getFbrand() {
        return fbrand;
    }

    public void setFbrand(String fbrand) {
        this.fbrand = fbrand == null ? null : fbrand.trim();
    }

    public String getFqulity() {
        return fqulity;
    }

    public void setFqulity(String fqulity) {
        this.fqulity = fqulity == null ? null : fqulity.trim();
    }

    public Date getFdeldate() {
        return fdeldate;
    }

    public void setFdeldate(Date fdeldate) {
        this.fdeldate = fdeldate;
    }

    public String getFcontnum() {
        return fcontnum;
    }

    public void setFcontnum(String fcontnum) {
        this.fcontnum = fcontnum == null ? null : fcontnum.trim();
    }

    public Double getFreceiptqty() {
        return Double.valueOf(new DecimalFormat("0.000000").format(freceiptqty));
    }

    public void setFreceiptqty(Double freceiptqty) {
        this.freceiptqty = freceiptqty;
    }

    public Double getFrefoundqty() {
        return Double.valueOf(new DecimalFormat("0.000000").format(frefoundqty));
    }

    public void setFrefoundqty(Double frefoundqty) {
        this.frefoundqty = frefoundqty;
    }

    public Double getFstoredqty() {
        return Double.valueOf(new DecimalFormat("0.000000").format(fstoredqty));
    }

    public void setFstoredqty(Double fstoredqty) {
        this.fstoredqty = fstoredqty;
    }

    public String getFjudgetype() {
        return fjudgetype;
    }

    public void setFjudgetype(String fjudgetype) {
        this.fjudgetype = fjudgetype == null ? null : fjudgetype.trim();
    }

    public String getFnote() {
        return fnote;
    }

    public void setFnote(String fnote) {
        this.fnote = fnote == null ? null : fnote.trim();
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public ERPStock getStock() {
        return stock;
    }

    public void setStock(ERPStock stock) {
        this.stock = stock;
    }

    public Double getFprice() {
        return fprice;
    }

    public void setFprice(Double fprice) {
        this.fprice = fprice;
    }

    public String getFcurrency() {
        return fcurrency;
    }

    public void setFcurrency(String fcurrency) {
        this.fcurrency = fcurrency;
    }

    public Double getFunreceiptqty() {
        return Math.abs(Double.valueOf(new DecimalFormat("0.000000").format(funreceiptqty)));
    }

    public void setFunreceiptqty(Double funreceiptqty) {
        this.funreceiptqty = funreceiptqty;
    }
}