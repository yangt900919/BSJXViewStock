package com.linkpal.model;

public class GsPrint {

    private Integer fid;

    private Integer fgoodseatid;

    private Goodseat goodseat;

    private Stock stock;

    private Integer fstockid;

    private Cabinet cabinet;

    private Integer fcabinetid;

    private  Scabinet scabinet;

    private Integer fscabinetid;

    private Integer fcabinettypeid;

    private Cabinettype cabinettype;

    private String fcharge;

    private String fmatype;

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
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

    public Scabinet getScabinet() {
        return scabinet;
    }

    public void setScabinet(Scabinet scabinet) {
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

    public Cabinettype getCabinettype() {
        return cabinettype;
    }

    public void setCabinettype(Cabinettype cabinettype) {
        this.cabinettype = cabinettype;
    }

    public String getFcharge() {
        return fcharge;
    }

    public void setFcharge(String fcharge) {
        this.fcharge = fcharge;
    }

    public String getFmatype() {
        return fmatype;
    }

    public void setFmatype(String fmatype) {
        this.fmatype = fmatype;
    }
}
