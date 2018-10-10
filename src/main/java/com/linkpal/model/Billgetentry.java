package com.linkpal.model;



import java.io.Serializable;
import java.text.DecimalFormat;

public class Billgetentry implements Serializable {
    private Integer fid;

    private Integer fmaterialid;

    private Material material;

    private String flot;

    private Double fapplyqty;

    private Double frealqty;

    private Double finventory;


    private Integer fsendstockid;

    private ERPStock estock;

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
        return Double.valueOf(new DecimalFormat("0.000000").format(fapplyqty));
    }

    public void setFapplyqty(Double fapplyqty) {
        this.fapplyqty = fapplyqty;
    }

    public Double getFrealqty() {
        return frealqty==null?frealqty:Double.valueOf(new DecimalFormat("0.000000").format(frealqty));
    }

    public void setFrealqty(Double frealqty) {
        this.frealqty = frealqty;
    }

    public Double getFinventory() {
        return Double.valueOf(new DecimalFormat("0.000000").format(finventory));
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

    public ERPStock getEstock() {
        return estock;
    }

    public void setEstock(ERPStock estock) {
        this.estock = estock;
    }
}