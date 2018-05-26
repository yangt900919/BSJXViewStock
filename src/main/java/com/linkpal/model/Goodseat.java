package com.linkpal.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Goodseat implements Serializable {
    private Integer fid;

    private String fnumber;

    private Scabinet scabinet;

    private Integer fscabinetid;

    private Cabinet cabinet;
    private Integer fcabinetid;
    private Stock stock;//仓库
    private Integer fstockid ;

    private Cabinettype cabinettype;

    private Integer fcabinettypeid;

    private String fremark;

    private Integer fstate;

    private Date fcreatetime;

    private static final long serialVersionUID = 1L;

    public Goodseat()
    {
        SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );
        try {
            this.fcreatetime=sdf.parse(sdf.format(new Date()));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

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

    public Scabinet getScabinet() {
        return scabinet;
    }

    public void setScabinet(Scabinet scabinet) {
        this.scabinet = scabinet;
    }

    public Cabinet getCabinet() {
        return cabinet;
    }

    public void setCabinet(Cabinet cabinet) {
        this.cabinet = cabinet;
    }

    public Integer getFcabinetid() {
        return fcabinetid;
    }

    public void setFcabinetid(Integer fcabinetid) {
        this.fcabinetid = fcabinetid;
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

    public Cabinettype getCabinettype() {
        return cabinettype;
    }

    public void setCabinettype(Cabinettype cabinettype) {
        this.cabinettype = cabinettype;
    }

    public Integer getFcabinettypeid() {
        return fcabinettypeid;
    }

    public void setFcabinettypeid(Integer fcabinettypeid) {
        this.fcabinettypeid = fcabinettypeid;
    }
}