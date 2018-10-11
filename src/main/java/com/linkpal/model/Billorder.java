package com.linkpal.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Billorder implements Serializable {
    private Integer fbillid;

    private String fnumber;

    private Integer fsupplierid;

    private Supplier supplier;

    private Integer fcustomid;

    private Custom custom;

    private Integer frestockid;

    private ERPStock restock;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fcreatetime;

    private Integer fcruserid;

    private User creator;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fcheckdate;

    private Integer fchuserid;

    private User auditor;

    private Integer fdepartmentid;

    private  Organization organization;

    private Integer fstatus;

    private String fnote;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fbizdate;

    private List<Billorderentry> billorderentries;

    private String fbuyer;

    private static final long serialVersionUID = 1L;

    public  Billorder()
    {
        this.fcreatetime=new java.sql.Date(new Date().getTime());
        this.fbizdate=new java.sql.Date(new Date().getTime());
        this.fstatus=0;
        this.billorderentries=new ArrayList<>();
    }

    public Integer getFbillid() {
        return fbillid;
    }

    public void setFbillid(Integer fbillid) {
        this.fbillid = fbillid;
    }

    public String getFnumber() {
        return fnumber;
    }

    public void setFnumber(String fnumber) {
        this.fnumber = fnumber == null ? null : fnumber.trim();
    }

    public Integer getFsupplierid() {
        return fsupplierid;
    }

    public void setFsupplierid(Integer fsupplierid) {
        this.fsupplierid = fsupplierid;
    }

    public Integer getFcustomid() {
        return fcustomid;
    }

    public void setFcustomid(Integer fcustomid) {
        this.fcustomid = fcustomid;
    }

    public Integer getFrestockid() {
        return frestockid;
    }

    public void setFrestockid(Integer frestockid) {
        this.frestockid = frestockid;
    }

    public Date getFcreatetime() {
        return fcreatetime;
    }

    public void setFcreatetime(Date fcreatetime) {
        this.fcreatetime = fcreatetime;
    }

    public Integer getFcruserid() {
        return fcruserid;
    }

    public void setFcruserid(Integer fcruserid) {
        this.fcruserid = fcruserid;
    }

    public Date getFcheckdate() {
        return fcheckdate;
    }

    public void setFcheckdate(Date fcheckdate) {
        this.fcheckdate = fcheckdate;
    }

    public Integer getFchuserid() {
        return fchuserid;
    }

    public void setFchuserid(Integer fchuserid) {
        this.fchuserid = fchuserid;
    }

    public Integer getFdepartmentid() {
        return fdepartmentid;
    }

    public void setFdepartmentid(Integer fdepartmentid) {
        this.fdepartmentid = fdepartmentid;
    }

    public Integer getFstatus() {
        return fstatus;
    }

    public void setFstatus(Integer fstatus) {
        this.fstatus = fstatus;
    }

    public String getFnote() {
        return fnote;
    }

    public void setFnote(String fnote) {
        this.fnote = fnote == null ? null : fnote.trim();
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Custom getCustom() {
        return custom;
    }

    public void setCustom(Custom custom) {
        this.custom = custom;
    }

    public ERPStock getRestock() {
        return restock;
    }

    public void setRestock(ERPStock restock) {
        this.restock = restock;
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

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public Date getFbizdate() {
        return fbizdate;
    }

    public void setFbizdate(Date fbizdate) {
        this.fbizdate = fbizdate;
    }

    public List<Billorderentry> getBillorderentries() {
        return billorderentries;
    }

    public void setBillorderentries(List<Billorderentry> billorderentries) {
        this.billorderentries = billorderentries;
    }

    public String getFbuyer() {
        return fbuyer;
    }

    public void setFbuyer(String fbuyer) {
        this.fbuyer = fbuyer;
    }
}