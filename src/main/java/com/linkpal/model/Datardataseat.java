package com.linkpal.model;

import java.io.Serializable;
import java.util.Date;

public class Datardataseat implements Serializable {
    private Integer fid;

    private Integer fdataid;

    private Material material;

    private Integer fdataseatid;

    private Dataseat dataseat;


    private Stock stock;

    private Integer fstockid;

    private Datacabinet cabinet;

    private Integer fcabinetid;

    private  Datascabinet scabinet;

    private Integer fscabinetid;

    private String fremark;

    private Date fcreatetime;

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

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public Integer getFstockid() {
        return fstockid;
    }

    public void setFstockid(Integer fstockid) {
        this.fstockid = fstockid;
    }

    public Datacabinet getCabinet() {
        return cabinet;
    }

    public void setCabinet(Datacabinet cabinet) {
        this.cabinet = cabinet;
    }

    public Integer getFcabinetid() {
        return fcabinetid;
    }

    public void setFcabinetid(Integer fcabinetid) {
        this.fcabinetid = fcabinetid;
    }

    public Datascabinet getScabinet() {
        return scabinet;
    }

    public void setScabinet(Datascabinet scabinet) {
        this.scabinet = scabinet;
    }

    public Integer getFscabinetid() {
        return fscabinetid;
    }

    public void setFscabinetid(Integer fscabinetid) {
        this.fscabinetid = fscabinetid;
    }
}