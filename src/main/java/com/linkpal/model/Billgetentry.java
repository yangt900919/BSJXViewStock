package com.linkpal.model;

import org.hibernate.jsr303.tck.tests.metadata.NotEmpty;

import java.io.Serializable;

public class Billgetentry implements Serializable {
    private Integer fid;

    @NotEmpty(message = "物料不能为空")
    private Integer fmaterialid;

    private Material material;

    private String flot;

    private Double fapplyqty;

    private Double frealqty;

    private Double finventory;

    @NotEmpty(message = "仓库不能为空")
    private Integer fsendstockid;

    private Stock estock;

    private String fnote;

    private Integer foid;

    private Integer fentryid;

    private Integer fbillid;

    private static final long serialVersionUID = 1L;

    public Billgetentry()
    {
        this.fmaterialid=0;
        this.fapplyqty=0.00;
        this.frealqty=0.00;
        this.finventory=0.00;
        this.fsendstockid=0;
        this.fentryid=0;
        this.fbillid=0;
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

    public String getFlot() {
        return flot;
    }

    public void setFlot(String flot) {
        this.flot = flot;
    }

    public Double getFapplyqty() {
        return fapplyqty;
    }

    public void setFapplyqty(Double fapplyqty) {
        this.fapplyqty = fapplyqty;
    }

    public Double getFrealqty() {
        return frealqty;
    }

    public void setFrealqty(Double frealqty) {
        this.frealqty = frealqty;
    }

    public Double getFinventory() {
        return finventory;
    }

    public void setFinventory(Double finventory) {
        this.finventory = finventory;
    }

    public Integer getFsendstockid() {
        return fsendstockid;
    }

    public void setFsendstockid(Integer fsendstockid) {
        this.fsendstockid = fsendstockid;
    }

    public String getFnote() {
        return fnote;
    }

    public void setFnote(String fnote) {
        this.fnote = fnote == null ? null : fnote.trim();
    }

    public Integer getFoid() {
        return foid;
    }

    public void setFoid(Integer foid) {
        this.foid = foid;
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

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Stock getEstock() {
        return estock;
    }

    public void setEstock(Stock estock) {
        this.estock = estock;
    }
}