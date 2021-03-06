package com.linkpal.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Datascabinet implements Serializable {
    private Integer fid;

    private String fnumber;

    private String fname;

    private Integer fcabinetid;

    private Datacabinet cabinet;

    private Integer fcabinettypeid;

    private Datacabinettype  cabinettype;

    private Integer fstockid;

    private Stock stock;

    private String fremark;

    private Date fcreatetime;

    private static final long serialVersionUID = 1L;

    public  Datascabinet()
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

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname == null ? null : fname.trim();
    }

    public Integer getFcabinetid() {
        return fcabinetid;
    }

    public void setFcabinetid(Integer fcabinetid) {
        this.fcabinetid = fcabinetid;
    }

    public Integer getFcabinettypeid() {
        return fcabinettypeid;
    }

    public void setFcabinettypeid(Integer fcabinettypeid) {
        this.fcabinettypeid = fcabinettypeid;
    }

    public Integer getFstockid() {
        return fstockid;
    }

    public void setFstockid(Integer fstockid) {
        this.fstockid = fstockid;
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

    public Datacabinet getCabinet() {
        return cabinet;
    }

    public void setCabinet(Datacabinet cabinet) {
        this.cabinet = cabinet;
    }

    public Datacabinettype getCabinettype() {
        return cabinettype;
    }

    public void setCabinettype(Datacabinettype cabinettype) {
        this.cabinettype = cabinettype;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }
}