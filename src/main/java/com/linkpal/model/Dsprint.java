package com.linkpal.model;

import java.io.Serializable;

public class Dsprint implements Serializable {
    private Integer fid;

    private Integer fdataseatid;

    private Dataseat dataseat;

    private Stock stock;

    private Integer fstockid;

    private Datacabinet cabinet;

    private Integer fcabinetid;

    private  Datascabinet scabinet;

    private Integer fscabinetid;

    private Integer fcabinettypeid;

    private Datacabinettype cabinettype;

    private static final long serialVersionUID = 1L;

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Integer getFdataseatid() {
        return fdataseatid;
    }

    public void setFdataseatid(Integer fdataseatid) {
        this.fdataseatid = fdataseatid;
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

    public Integer getFcabinettypeid() {
        return fcabinettypeid;
    }

    public void setFcabinettypeid(Integer fcabinettypeid) {
        this.fcabinettypeid = fcabinettypeid;
    }

    public Datacabinettype getCabinettype() {
        return cabinettype;
    }

    public void setCabinettype(Datacabinettype cabinettype) {
        this.cabinettype = cabinettype;
    }
}