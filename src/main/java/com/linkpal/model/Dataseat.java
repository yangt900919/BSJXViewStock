package com.linkpal.model;

import java.io.Serializable;
import java.util.Date;

public class Dataseat implements Serializable {
    private Integer fid;

    private String fnumber;

    private Integer fscabinetid;

    private Datascabinet scabinet;

    private Datacabinet cabinet;

    private Integer fcabinetid;

    private Datacabinettype cabinettype;

    private  Integer fcabinettypeid;

    private Stock stock;

    private Integer fstockid;


    private String fremark;

    private Integer fstate;

    private Date fcreatetime;

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

    public Integer getFscabinetid() {
        return fscabinetid;
    }

    public void setFscabinetid(Integer fscabinetid) {
        this.fscabinetid = fscabinetid;
    }

    public String getFremark() {
        return fremark;
    }

    public void setFremark(String fremark) {
        this.fremark = fremark == null ? null : fremark.trim();
    }

    public Integer getFstate() {
        return fstate;
    }

    public void setFstate(Integer fstate) {
        this.fstate = fstate;
    }

    public Date getFcreatetime() {
        return fcreatetime;
    }

    public void setFcreatetime(Date fcreatetime) {
        this.fcreatetime = fcreatetime;
    }

    public Datascabinet getScabinet() {
        return scabinet;
    }

    public void setScabinet(Datascabinet scabinet) {
        this.scabinet = scabinet;
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

    public Datacabinettype getCabinettype() {
        return cabinettype;
    }

    public void setCabinettype(Datacabinettype cabinettype) {
        this.cabinettype = cabinettype;
    }

    public Integer getFcabinettypeid() {
        return fcabinettypeid;
    }

    public void setFcabinettypeid(Integer fcabinettypeid) {
        this.fcabinettypeid = fcabinettypeid;
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
}