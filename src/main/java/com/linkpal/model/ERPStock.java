package com.linkpal.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ERPStock implements Serializable {
    private Integer fid;

    private String fnumber;

    private String fname;

    private Stock stock;

    private Integer fstockid;



    public Date fcreatetime;

    public ERPStock()
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
        this.fnumber = fnumber;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
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