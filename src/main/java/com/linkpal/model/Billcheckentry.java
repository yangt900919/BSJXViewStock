package com.linkpal.model;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Date;

public class Billcheckentry implements Serializable {

    /**
     * 行内码
     */
    private Integer fid;

    /**
     * 原单单号（采购订单分录行内码）
     */
    private Integer foid;

    private Integer fobillid;

    private String fonumber;

    /**
     * 收料通知请检单分录ID
     */
    private Integer fentryid;

    public void setFbillid(int fbillid) {
        this.fbillid = fbillid;
    }

    public void setFstockid(int fstockid) {
        this.fstockid = fstockid;
    }

    public Material getfMaterial() {
        return fMaterial;
    }

    public void setfMaterial(Material fMaterial) {
        this.fMaterial = fMaterial;
    }

    public ERPStock getfStock() {
        return fStock;
    }

    public void setfStock(ERPStock fStock) {
        this.fStock = fStock;
    }

    private Integer fmaid;

    /**
     * 收料数量

     */
    private Double fqty;

    /**
     * 收料通知请检单请检单单据内码
     */
    private int fbillid;

    /**
     * 生产日期
     */
    private Date fdate;

    /**
     * 合格数量
     */
    private Double feligqty;

    /**
     * 不合格数量
     */
    private Double funqty;

    /**
     * 不合格原因
     */
    private String freason;

    /**
     * 处理结果
     */
    private String fresult;

    /**
     * 批号
     */
    private String fbatch;

    /**
     * 保质期
     */
    private Double fguartime;

    /**
     * 收料仓库
     */
    private int fstockid;

    /**
     * 交货日期
     */
    private Date fdeltime;

    /**
     * 物料信息
     */
    private Material fMaterial;

    private ERPStock fStock;




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

    public Integer getFentryid() {
        return fentryid;
    }

    public void setFentryid(Integer fentryid) {
        this.fentryid = fentryid;
    }

    public Double getFqty() {
        return Double.valueOf(new DecimalFormat("0.000000").format(fqty));
    }

    public void setFqty(Double fqty) {
        this.fqty = fqty;
    }

    public Date getFdate() {
        return fdate;
    }

    public void setFdate(Date fdate) {
        this.fdate = fdate;
    }

    public Integer getFbillid() {
        return fbillid;
    }

    public void setFbillid(Integer fbillid) {
        this.fbillid = fbillid;
    }

    public Double getFeligqty() {
        return feligqty==null?feligqty:Double.valueOf(new DecimalFormat("0.000000").format(feligqty));
    }

    public void setFeligqty(Double feligqty) {
        this.feligqty = feligqty;
    }

    public Double getFunqty() {
        return funqty==null?funqty:Double.valueOf(new DecimalFormat("0.000000").format(funqty));
    }

    public void setFunqty(Double funqty) {
        this.funqty = funqty;
    }

    public String getFreason() {
        return freason;
    }

    public void setFreason(String freason) {
        this.freason = freason == null ? null : freason.trim();
    }

    public String getFresult() {
        return fresult;
    }

    public void setFresult(String fresult) {
        this.fresult = fresult == null ? null : fresult.trim();
    }

    public String getFbatch() {
        return fbatch;
    }

    public void setFbatch(String fbatch) {
        this.fbatch = fbatch == null ? null : fbatch.trim();
    }

    public Double getFguartime() {
        return fguartime;
    }

    public void setFguartime(Double fguartime) {
        this.fguartime = fguartime;
    }

    public Date getFdeltime() {
        return fdeltime;
    }

    public void setFdeltime(Date fdeltime) {
        this.fdeltime = fdeltime;
    }

    public Integer getFstockid() {
        return fstockid;
    }

    public void setFstockid(Integer fstockid) {
        this.fstockid = fstockid;
    }

    public Integer getFmaid() {
        return fmaid;
    }

    public void setFmaid(Integer fmaid) {
        this.fmaid = fmaid;
    }
}