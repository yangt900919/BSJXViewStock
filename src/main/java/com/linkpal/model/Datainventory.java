package com.linkpal.model;

import java.io.Serializable;

public class Datainventory implements Serializable {
    private Integer fid;

    private Integer fdataid;

    private Integer fdataseatid;

    private Double fqty;

    private String fdate;

    private Material material;

    private Dataseat dataseat;

    private ERPStock erpstock;

    private Integer ferpstockid;

    private Integer fcabinetid;

    private Cabinet cabinet;

    private Integer fscabinetid;

    private Scabinet scabinet;

    private Integer fstockid;

    private Stock stock;

    private static final long serialVersionUID = 1L;

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Integer getFdataid() {
        return fdataid;
    }

    public void setFdataid(Integer fdataid) {
        this.fdataid = fdataid;
    }

    public Integer getFdataseatid() {
        return fdataseatid;
    }

    public void setFdataseatid(Integer fdataseatid) {
        this.fdataseatid = fdataseatid;
    }

    public Double getFqty() {
        return fqty;
    }

    public void setFqty(Double fqty) {
        this.fqty = fqty;
    }

    public String getFdate() {
        return fdate;
    }

    public void setFdate(String fdate) {
        this.fdate = fdate == null ? null : fdate.trim();
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Dataseat getDataseat() {
        return dataseat;
    }

    public void setDataseat(Dataseat dataseat) {
        this.dataseat = dataseat;
    }

    public ERPStock getStock() {
        return erpstock;
    }

    public void setStock(ERPStock erpstock) {
        this.erpstock = erpstock;
    }

    public Integer getFstockid() {
        return ferpstockid;
    }

    public void setFstockid(Integer ferpstockid) {
        this.ferpstockid = ferpstockid;
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

    public ERPStock getErpstock() {
        return erpstock;
    }

    public void setErpstock(ERPStock erpstock) {
        this.erpstock = erpstock;
    }

    public Integer getFerpstockid() {
        return ferpstockid;
    }

    public void setFerpstockid(Integer ferpstockid) {
        this.ferpstockid = ferpstockid;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }
}