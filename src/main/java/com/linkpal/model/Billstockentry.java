package com.linkpal.model;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.List;

public class Billstockentry implements Serializable {
    /**
     * 行内码
     */
    private Integer fid;

    /**
     * 原单单号（收料通知请检单分录行内码ID）
     */
    private Integer foid;

    /**
     * 入库数量
     */
    private Double fqty;

    /**
     * 已入库数量
     */
    private Double factqty;

    /**
     * 入库单分录ID
     */
    private Integer fentryid;

    /**
     * 物料信息
     */
    private Material material;

    /**
     * 入库单单据内码ID
     */
    private int fbillid;


    private String fbatch;

    private Integer fobillid;

    private String fonumber;

    private Integer fmaterialid;

    private Integer fstockid;

    private ERPStock stock;


    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public void setFbillid(int fbillid) {
        this.fbillid = fbillid;
    }

    public List<Billstockentry> getmEntries() {
        return mEntries;
    }

    public void setmEntries(List<Billstockentry> mEntries) {
        this.mEntries = mEntries;
    }

    /**
     * 入库单分录
     */

    private List<Billstockentry> mEntries;

    private static final long serialVersionUID = 1L;

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Integer getFoid() {
        return foid;
    }

    public void setFoid(Integer foid) {
        this.foid = foid;
    }

    public Double getFqty() {
        return Double.valueOf(new DecimalFormat("0.000000").format(fqty));
    }

    public void setFqty(Double fqty) {
        this.fqty = fqty;
    }

    public Double getFactqty() {
        return factqty==null?factqty:Double.valueOf(new DecimalFormat("0.000000").format(factqty));
    }

    public void setFactqty(Double factqty) {
        this.factqty = factqty;
    }

    public Integer getFentryid() {
        return fentryid;
    }

    public void setFentryid(Integer fentryid) {
        this.fentryid = fentryid;
    }

    public Integer getFbillid() {
        return fbillid;
    }

    public void setFbillid(Integer fbillid) {
        this.fbillid = fbillid;
    }

    public String getFbatch() {
        return fbatch;
    }

    public void setFbatch(String fbatch) {
        this.fbatch = fbatch == null ? null : fbatch.trim();
    }

    public Integer getFobillid() {
        return fobillid;
    }

    public void setFobillid(Integer fobillid) {
        this.fobillid = fobillid;
    }

    public String getFonumber() {
        return fonumber;
    }

    public void setFonumber(String fonumber) {
        this.fonumber = fonumber == null ? null : fonumber.trim();
    }

    public Integer getFmaterialid() {
        return fmaterialid;
    }

    public void setFmaterialid(Integer fmaterialid) {
        this.fmaterialid = fmaterialid;
    }

    public Integer getFstockid() {
        return fstockid;
    }

    public void setFstockid(Integer fstockid) {
        this.fstockid = fstockid;
    }

    public ERPStock getStock() {
        return stock;
    }

    public void setStock(ERPStock stock) {
        this.stock = stock;
    }
}