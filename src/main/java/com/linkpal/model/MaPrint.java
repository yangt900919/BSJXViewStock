package com.linkpal.model;

import java.util.Date;

public class MaPrint {

    private Integer fid;
    private String fbillno;

    private String fboxno;

    private  Integer fmaterialid;

    private Material material;

    private String fbatch;

    private  Double fgperiod;

    private String fmdate;

    private String fadate;

    private Double fquqty;

    private Integer fsupplierid;

    private  Supplier supplier;

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getFbillno() {
        return fbillno;
    }

    public void setFbillno(String fbillno) {
        this.fbillno = fbillno;
    }

    public Integer getFmaterialid() {
        return fmaterialid;
    }

    public void setFmaterialid(Integer fmaterialid) {
        this.fmaterialid = fmaterialid;
    }

    public Double getFgperiod() {
        return fgperiod;
    }

    public void setFgperiod(Double fgperiod) {
        this.fgperiod = fgperiod;
    }

    public String getFmdate() {
        return fmdate;
    }

    public void setFmdate(String fmdate) {
        this.fmdate = fmdate;
    }

    public String getFadate() {
        return fadate;
    }

    public void setFadate(String fadate) {
        this.fadate = fadate;
    }

    public Double getFquqty() {
        return fquqty;
    }

    public void setFquqty(Double fquqty) {
        this.fquqty = fquqty;
    }

    public Integer getFsupplierid() {
        return fsupplierid;
    }

    public void setFsupplierid(Integer fsupplierid) {
        this.fsupplierid = fsupplierid;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public String getFbatch() {
        return fbatch;
    }

    public void setFbatch(String fbatch) {
        this.fbatch = fbatch;
    }

    public String getFboxno() {
        return fboxno;
    }

    public void setFboxno(String fboxno) {
        this.fboxno = fboxno;
    }
}
