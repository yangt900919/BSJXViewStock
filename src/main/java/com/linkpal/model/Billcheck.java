package com.linkpal.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Billcheck implements Serializable {

    /**
     * 行内码
     */
    private Integer fid;

    /**
     * 单据编号
     */
    private String fnumber;

    @DateTimeFormat(pattern ="yyyy-MM-dd HH:mm:ss")
    private Date fbizdate;

    /**
     * 供应商ID
     */
    private Integer fsupplierid;

    /**
     * 创建用户
     */
    private Integer fcruid;

    /**
     * 审核用户
     */
    private Integer fchuid;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern ="yyyy-MM-dd HH:mm:ss")
    private Date fcretime;

    /**
     * 审核时间
     */
    @DateTimeFormat(pattern ="yyyy-MM-dd HH:mm:ss")
    private Date fchetime;

    /**
     * 状态； 0表示正常，1表示审核,2表示检验
     */
    private Integer fstatus;

    /**
     * 供应商名称
     */
    private String fsuppliername;

    /**
     * 创建人名称
     */
    private String fcreuser;

    /**
     * 审核人名称
     */
    private String fcheuser;

    /**
     * 单据分录
     */
    private List<Billcheckentry> mEntries;

    private List<Billcheckentry> billcheckentries;

    private Supplier supplier;

    private User creator;

    private User auditor;

    private String fboxno;

    private Integer fisqt;

    private static final long serialVersionUID = 1L;

    public Billcheck()
    {

        this.fbizdate=new java.sql.Date(new Date().getTime());
        this.fcretime=new java.sql.Date(new Date().getTime());
        this.fstatus=0;
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

    public Date getFbizdate() {
        return fbizdate;
    }

    public void setFbizdate(Date fbizdate) {
        this.fbizdate = fbizdate;
    }

    public Integer getFsupplierid() {
        return fsupplierid;
    }

    public void setFsupplierid(Integer fsupplierid) {
        this.fsupplierid = fsupplierid;
    }

    public Integer getFcruid() {
        return fcruid;
    }

    public void setFcruid(Integer fcruid) {
        this.fcruid = fcruid;
    }

    public Integer getFchuid() {
        return fchuid;
    }

    public void setFchuid(Integer fchuid) {
        this.fchuid = fchuid;
    }

    public Date getFcretime() {
        return fcretime;
    }

    public void setFcretime(Date fcretime) {
        this.fcretime = fcretime;
    }

    public Date getFchetime() {
        return fchetime;
    }

    public void setFchetime(Date fchetime) {
        this.fchetime = fchetime;
    }

    public Integer getFstatus() {
        return fstatus;
    }

    public void setFstatus(Integer fstatus) {
        this.fstatus = fstatus;
    }

    public String getFsuppliername() {
        return fsuppliername;
    }

    public void setFsuppliername(String fsuppliername) {
        this.fsuppliername = fsuppliername;
    }

    public String getFcreuser() {
        return fcreuser;
    }

    public void setFcreuser(String fcreuser) {
        this.fcreuser = fcreuser;
    }

    public String getFcheuser() {
        return fcheuser;
    }

    public void setFcheuser(String fcheuser) {
        this.fcheuser = fcheuser;
    }

    public List<Billcheckentry> getmEntries() {
        return mEntries;
    }

    public void setmEntries(List<Billcheckentry> mEntries) {
        this.mEntries = mEntries;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
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

    public List<Billcheckentry> getBillcheckentries() {
        return billcheckentries;
    }

    public void setBillcheckentries(List<Billcheckentry> billcheckentries) {
        this.billcheckentries = billcheckentries;
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