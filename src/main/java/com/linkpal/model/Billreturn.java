package com.linkpal.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Billreturn implements Serializable {
    private Integer fid;

    private String fnumber;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date fbizdate;

    private Integer fstate;

    private String fbiztype;

    private Integer fsupplierid;

    private Supplier supplier;

    private String fnote;

    private Integer fcreatorid;

    private User creator;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date fcreatedate;

    private Integer fauditorid;

    private User auditor;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date fauditdate;

    private List<Billreturnentry> billreturnentries;
    private static final long serialVersionUID = 1L;

    public  Billreturn()
    {
        this.fcreatedate=new java.sql.Date(new Date().getTime());
        this.fbizdate=new java.sql.Date(new Date().getTime());
        this.fstate=0;
        this.billreturnentries=new ArrayList<>();
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

    public Integer getFstate() {
        return fstate;
    }

    public void setFstate(Integer fstate) {
        this.fstate = fstate;
    }

    public String getFbiztype() {
        return fbiztype;
    }

    public void setFbiztype(String fbiztype) {
        this.fbiztype = fbiztype == null ? null : fbiztype.trim();
    }

    public Integer getFsupplierid() {
        return fsupplierid;
    }

    public void setFsupplierid(Integer fsupplierid) {
        this.fsupplierid = fsupplierid;
    }

    public String getFnote() {
        return fnote;
    }

    public void setFnote(String fnote) {
        this.fnote = fnote == null ? null : fnote.trim();
    }

    public Integer getFcreatorid() {
        return fcreatorid;
    }

    public void setFcreatorid(Integer fcreatorid) {
        this.fcreatorid = fcreatorid;
    }

    public Date getFcreatedate() {
        return fcreatedate;
    }

    public void setFcreatedate(Date fcreatedate) {
        this.fcreatedate = fcreatedate;
    }

    public Integer getFauditorid() {
        return fauditorid;
    }

    public void setFauditorid(Integer fauditorid) {
        this.fauditorid = fauditorid;
    }

    public Date getFauditdate() {
        return fauditdate;
    }

    public void setFauditdate(Date fauditdate) {
        this.fauditdate = fauditdate;
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

    public List<Billreturnentry> getBillreturnentries() {
        return billreturnentries;
    }

    public void setBillreturnentries(List<Billreturnentry> billreturnentries) {
        this.billreturnentries = billreturnentries;
    }
}