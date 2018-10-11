package com.linkpal.model;

import java.io.Serializable;
import java.util.Date;

public class Inventry implements Serializable {
    private Integer fid;

    private Integer fparentid;

    private Integer fmaterialid;

    private Material material;

    private Integer fgoodseatid;

    private Goodseat goodseat;

    private Double fqty;

    private Double finvqty;

    private Date fcreatetime;

    private static final long serialVersionUID = 1L;

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Integer getFparentid() {
        return fparentid;
    }

    public void setFparentid(Integer fparentid) {
        this.fparentid = fparentid;
    }

    public Integer getFmaterialid() {
        return fmaterialid;
    }

    public void setFmaterialid(Integer fmaterialid) {
        this.fmaterialid = fmaterialid;
    }

    public Integer getFgoodseatid() {
        return fgoodseatid;
    }

    public void setFgoodseatid(Integer fgoodseatid) {
        this.fgoodseatid = fgoodseatid;
    }

    public Double getFqty() {
        return fqty;
    }

    public void setFqty(Double fqty) {
        this.fqty = fqty;
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

    public Goodseat getGoodseat() {
        return goodseat;
    }

    public void setGoodseat(Goodseat goodseat) {
        this.goodseat = goodseat;
    }

    public Double getFinvqty() {
        return finvqty;
    }

    public void setFinvqty(Double finvqty) {
        this.finvqty = finvqty;
    }
}