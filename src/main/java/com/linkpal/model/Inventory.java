package com.linkpal.model;

import java.io.Serializable;
import java.util.Date;

public class Inventory implements Serializable {
    private Integer fid;

    private Integer fmaid;

    private Material material;

    private Integer fgoodseatid;

    private Goodseat goodseat;

    private Integer fstockid;

    private Stock stock;

    private Integer fcabinetid;

    private Cabinet cabinet;

    private Integer fscabinetid;

    private Scabinet scabinet;

    private Double fqty;

    private Date fdate;

    private Date fmdate;

    private Double fgperiod;

    private String fbatch;

    private static final long serialVersionUID = 1L;

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Integer getFmaid() {
        return fmaid;
    }

    public void setFmaid(Integer fmaid) {
        this.fmaid = fmaid;
    }

    public Integer getFgoodseatid() {
        return fgoodseatid;
    }

    public void setFgoodseatid(Integer fgoodseatid) {
        this.fgoodseatid = fgoodseatid;
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

    public Date getFdate() {
        return fdate;
    }

    public void setFdate(Date fdate) {
        this.fdate = fdate;
    }

    public Date getFmdate() {
        return fmdate;
    }

    public void setFmdate(Date fmdate) {
        this.fmdate = fmdate;
    }

    public Double getFgperiod() {
        return fgperiod;
    }

    public void setFgperiod(Double fgperiod) {
        this.fgperiod = fgperiod;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Goodseat getGoodseat() {
        return goodseat;
    }

    public void setGoodseat(Goodseat goodseat) {
        this.goodseat = goodseat;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public Integer getFcabinetid() {
        return fcabinetid;
    }

    public void setFcabinetid(Integer fcabinetid) {
        this.fcabinetid = fcabinetid;
    }

    public Cabinet getCabinet() {
        return cabinet;
    }

    public void setCabinet(Cabinet cabinet) {
        this.cabinet = cabinet;
    }

    public Integer getFscabinetid() {
        return fscabinetid;
    }

    public void setFscabinetid(Integer fscabinetid) {
        this.fscabinetid = fscabinetid;
    }

    public Scabinet getScabinet() {
        return scabinet;
    }

    public void setScabinet(Scabinet scabinet) {
        this.scabinet = scabinet;
    }

    public String getFbatch() {
        return fbatch;
    }

    public void setFbatch(String fbatch) {
        this.fbatch = fbatch;
    }
}