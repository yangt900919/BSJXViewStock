package com.linkpal.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Bill implements Serializable {

    // 单据内码
    private Integer fbillid;

    // 单据内码
    private String fnumber;

    // 供应商ID
    private int fsupplierid;

    // 收货方ID
    private int fcustomid;

    // 发料仓库ID
    private int frestockid;

    // 创建日期
    private Date fcreatetime;

    // 创建用户ID
    private int fcruserid;

    // 审核日期
    private Date fcheckdate;

    // 审核人ID
    private Integer fchuserid;

    // 部门ID
    private int fdepartmentid;

    // 状态
    private int fstatus;

    // 备注
    private String fnote;

    // 单据分录
    private List<Billentry> mEntries;

    // 创建用户名称
    private String username;

    // 审核人名称
    private String checkname;

    // 供应商名称
    private String suppliername;

    // 收货方名称
    private String customname;

    // 收料仓库名称
    private String stockname;

    // 部门名称
    private String departname;

    private static final long serialVersionUID = 1L;

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

    public int getFsupplierid() {
        return fsupplierid;
    }

    public void setFsupplierid(int fsupplierid) {
        this.fsupplierid = fsupplierid;
    }

    public int getFcustomid() {
        return fcustomid;
    }

    public void setFcustomid(int fcustomid) {
        this.fcustomid = fcustomid;
    }

    public int getFrestockid() {
        return frestockid;
    }

    public void setFrestockid(int frestockid) {
        this.frestockid = frestockid;
    }

    public Date getFcreatetime() {
        return fcreatetime;
    }

    public void setFcreatetime(Date fcreatetime) {
        this.fcreatetime = fcreatetime;
    }

    public int getFcruserid() {
        return fcruserid;
    }

    public void setFcruserid(int fcruserid) {
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

    public int getFdepartmentid() {
        return fdepartmentid;
    }

    public void setFdepartmentid(int fdepartmentid) {
        this.fdepartmentid = fdepartmentid;
    }

    public int getFstatus() {
        return fstatus;
    }

    public void setFstatus(int fstatus) {
        this.fstatus = fstatus;
    }

    public String getFnote() {
        return fnote;
    }

    public void setFnote(String fnote) {
        this.fnote = fnote == null ? null : fnote.trim();
    }

    public List<Billentry> getmEntries() {
        return mEntries;
    }

    public void setmEntries(List<Billentry> mEntries) {
        this.mEntries = mEntries;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCheckname() {
        return checkname;
    }

    public void setCheckname(String checkname) {
        this.checkname = checkname;
    }

    public String getSuppliername() {
        return suppliername;
    }

    public void setSuppliername(String suppliername) {
        this.suppliername = suppliername;
    }

    public String getCustomname() {
        return customname;
    }

    public void setCustomname(String customname) {
        this.customname = customname;
    }

    public String getStockname() {
        return stockname;
    }

    public void setStockname(String stockname) {
        this.stockname = stockname;
    }

    public String getDepartname() {
        return departname;
    }

    public void setDepartname(String departname) {
        this.departname = departname;
    }
}