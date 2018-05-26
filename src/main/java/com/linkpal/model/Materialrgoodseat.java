package com.linkpal.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Materialrgoodseat implements Serializable {
    private Integer fid;

    private Integer fmaterialid;

    private Material material;

    private Integer fgoodseatid;

    private Goodseat goodseat;

    private Stock stock;

    private Integer fstockid;

    private Cabinet cabinet;

    private Integer fcabinetid;

    private  Scabinet scabinet;

    private Integer fscabinetid;

    private String fremark;

    private Date fcreatetime;

    private static final long serialVersionUID = 1L;

    public Materialrgoodseat()
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

    public Integer getFmaterialid() {
        return fmaterialid;
    }

    public void setFmaterialid(Integer fmaterialid) {
        this.fmaterialid = fmaterialid;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Integer getFgoodseatid() {
        return fgoodseatid;
    }

    public void setFgoodseatid(Integer fgoodseatid) {
        this.fgoodseatid = fgoodseatid;
    }

    public Goodseat getGoodseat() {
        return goodseat;
    }

    public void setGoodseat(Goodseat goodseat) {
        this.goodseat = goodseat;
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

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public Cabinet getCabinet() {
        return cabinet;
    }

    public void setCabinet(Cabinet cabinet) {
        this.cabinet = cabinet;
    }

    public Scabinet getScabinet() {
        return scabinet;
    }

    public void setScabinet(Scabinet scabinet) {
        this.scabinet = scabinet;
    }

    public Integer getFstockid() {
        return fstockid;
    }

    public void setFstockid(Integer fstockid) {
        this.fstockid = fstockid;
    }

    public Integer getFcabinetid() {
        return fcabinetid;
    }

    public void setFcabinetid(Integer fcabinetid) {
        this.fcabinetid = fcabinetid;
    }

    public Integer getFscabinetid() {
        return fscabinetid;
    }

    public void setFscabinetid(Integer fscabinetid) {
        this.fscabinetid = fscabinetid;
    }
}