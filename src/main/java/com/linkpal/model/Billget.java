package com.linkpal.model;


import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Billget implements Serializable {
    private Integer fid;



    private String fnumber;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fdodate;

    private Integer fstate;

    private Integer fdepartmentid;

    private Organization organization;


    private Integer fsendstockid;

    private ERPStock stock;


    private Integer fgeterid;

    private User getuser;


    private Integer fsenderid;

    private User senduser;

    private Integer fcreaterid;

    private User creator;

    private Date fcreatedate;

    private Integer fauditorid;

    private User auditor;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date fauditdate;

    private String fbiztype;

    private Integer fcustomid;

    private Custom custom;

    List<Billgetentry> billgetentries;

    private Integer fisqt;

    private static final long serialVersionUID = 1L;

    public Billget()
    {
        SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );
//        try {
        this.fid=0;
            this.fcreatedate=new java.sql.Date(new Date().getTime());
            this.fdepartmentid=0;
            this.fsendstockid=0;
            this.fgeterid=0;
            this.fsenderid=0;
            this.fcreaterid=0;
            this.fauditorid=0;
            this.fcustomid=0;
            this.fstate=0;
            this.fdodate=new java.sql.Date(new Date().getTime());
            this.billgetentries=new ArrayList<>();
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
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

    public Date getFdodate() {
        return fdodate;
    }

    public void setFdodate(Date fdodate) {
        this.fdodate = fdodate;
    }

    public Integer getFstate() {
        return fstate;
    }

    public void setFstate(Integer fstate) {
        this.fstate = fstate;
    }

    public Integer getFdepartmentid() {
        return fdepartmentid;
    }

    public void setFdepartmentid(Integer fdepartmentid) {
        this.fdepartmentid = fdepartmentid;
    }

    public Integer getFsendstockid() {
        return fsendstockid;
    }

    public void setFsendstockid(Integer fsendstockid) {
        this.fsendstockid = fsendstockid;
    }

    public Integer getFgeterid() {
        return fgeterid;
    }

    public void setFgeterid(Integer fgeterid) {
        this.fgeterid = fgeterid;
    }

    public Integer getFsenderid() {
        return fsenderid;
    }

    public void setFsenderid(Integer fsenderid) {
        this.fsenderid = fsenderid;
    }

    public Integer getFcreaterid() {
        return fcreaterid;
    }

    public void setFcreaterid(Integer fcreaterid) {
        this.fcreaterid = fcreaterid;
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

    public String getFbiztype() {
        return fbiztype;
    }

    public void setFbiztype(String fbiztype) {
        this.fbiztype = fbiztype == null ? null : fbiztype.trim();
    }

    public Integer getFcustomid() {
        return fcustomid;
    }

    public void setFcustomid(Integer fcustomid) {
        this.fcustomid = fcustomid;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public ERPStock getStock() {
        return stock;
    }

    public void setStock(ERPStock stock) {
        this.stock = stock;
    }

    public User getGetuser() {
        return getuser;
    }

    public void setGetuser(User getuser) {
        this.getuser = getuser;
    }

    public User getSenduser() {
        return senduser;
    }

    public void setSenduser(User senduser) {
        this.senduser = senduser;
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

    public Custom getCustom() {
        return custom;
    }

    public void setCustom(Custom custom) {
        this.custom = custom;
    }

    public List<Billgetentry> getBillgetentries() {
        return billgetentries;
    }

    public void setBillgetentries(List<Billgetentry> billgetentries) {
        this.billgetentries = billgetentries;
    }

    public Integer getFisqt() {
        return fisqt;
    }

    public void setFisqt(Integer fisqt) {
        this.fisqt = fisqt;
    }
}