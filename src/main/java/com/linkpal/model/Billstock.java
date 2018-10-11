package com.linkpal.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Billstock implements Serializable {


    /**
     * 入库单内码
     */
    private Integer fid;

    /**
     * 供应商ID
     */
    private Integer fsupplierid;

    /**
     * 收料仓库ID
     */
    private Integer fstockid;

    /**
     * 创建人ID
     */
    private Integer fuserid;

    private User creator;



    /**
     * 创建日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fdate;

    /**
     * 审核人ID
     */
    private Integer fchuserid;

    private User auditor;

    /**
     * 审核日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date fchedate;

    /**
     * 状态
     */
    private Integer fstatus;

    /**
     * 入库单编号
     */
    private String fnumber;

    /**
     * 创建人名称
     */
    private String fusername;

    /**
     * 审核人名称
     */
    private String fcheusername;

    /**
     * 仓库信息
     */
    private ERPStock stock;

    /**
     * 供应商信息
     */
    private Supplier supplier;

    private Integer fkeeperid;

    private User keeper;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date fbizdate;

    private String fboxno;

    private Integer fisqt;

    /**
     * 入库单分录
     */
    private List<Billstockentry> mEntries;

    private List<Billstockentry> billstockentries;

    public Billstock()
    {

        this.fstatus=0;
        this.fdate=new java.sql.Date(new Date().getTime());
        this.fbizdate=new java.sql.Date(new Date().getTime());
        this.billstockentries=new ArrayList<>();
    }

    public List<Billstockentry> getmEntries() {
        return mEntries;
    }

    public void setmEntries(List<Billstockentry> mEntries) {
        this.mEntries = mEntries;
    }

    public String getFusername() {
        return fusername;
    }

    public void setFusername(String fusername) {
        this.fusername = fusername;
    }

    public String getFcheusername() {
        return fcheusername;
    }

    public void setFcheusername(String fcheusername) {
        this.fcheusername = fcheusername;
    }

    public ERPStock getStock() {
        return stock;
    }

    public void setStock(ERPStock stock) {
        this.stock = stock;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    private static final long serialVersionUID = 1L;

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Integer getFsupplierid() {
        return fsupplierid;
    }

    public void setFsupplierid(Integer fsupplierid) {
        this.fsupplierid = fsupplierid;
    }

    public Integer getFstockid() {
        return fstockid;
    }

    public void setFstockid(Integer fstockid) {
        this.fstockid = fstockid;
    }

    public Integer getFuserid() {
        return fuserid;
    }

    public void setFuserid(Integer fuserid) {
        this.fuserid = fuserid;
    }

    public Date getFdate() {
        return fdate;
    }

    public void setFdate(Date fdate) {
        this.fdate = fdate;
    }

    public Integer getFchuserid() {
        return fchuserid;
    }

    public void setFchuserid(Integer fchuserid) {
        this.fchuserid = fchuserid;
    }

    public Date getFchedate() {
        return fchedate;
    }

    public void setFchedate(Date fchedate) {
        this.fchedate = fchedate;
    }

    public Integer getFstatus() {
        return fstatus;
    }

    public void setFstatus(Integer fstatus) {
        this.fstatus = fstatus;
    }

    public String getFnumber() {
        return fnumber;
    }

    public void setFnumber(String fnumber) {
        this.fnumber = fnumber == null ? null : fnumber.trim();
    }

    public Integer getFkeeperid() {
        return fkeeperid;
    }

    public void setFkeeperid(Integer fkeeperid) {
        this.fkeeperid = fkeeperid;
    }

    public Date getFbizdate() {
        return fbizdate;
    }

    public void setFbizdate(Date fbizdate) {
        this.fbizdate = fbizdate;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public User getAuditor() {
        return auditor;
    }

    public void setAuditor(User auditor) {
        this.auditor = auditor;
    }

    public User getKeeper() {
        return keeper;
    }

    public void setKeeper(User keeper) {
        this.keeper = keeper;
    }

    public List<Billstockentry> getBillstockentries() {
        return billstockentries;
    }

    public void setBillstockentries(List<Billstockentry> billstockentries) {
        this.billstockentries = billstockentries;
    }

    public String getFboxno() {
        return fboxno;
    }

    public void setFboxno(String fboxno) {
        this.fboxno = fboxno;
    }

    public Integer getFisqt() {
        return fisqt;
    }

    public void setFisqt(Integer fisqt) {
        this.fisqt = fisqt;
    }
}