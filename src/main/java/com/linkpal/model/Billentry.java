package com.linkpal.model;

import java.io.Serializable;
import java.util.Date;

public class Billentry extends BillentryKey implements Serializable {

    // 物料内码
    private Integer fmaid;

    // 仓库地点内码
    private Integer fstockid;

    // 数量
    private int fqty;

    // 行业务关闭标志
    private int fstate;

    // 品牌
    private String fbrand;

    // 质量标准
    private String fqulity;

    // 交货日期
    private Date fdeldate;

    // 合同号
    private String fcontnum;

    // 收料数量
    private int freceiptqty;

    // 退料数量
    private int frefoundqty;

    // 入库数量
    private int fstoredqty;

    // 评估类型
    private String fjudgetype;

    // 备注
    private String fnote;

    // 物料详情
    private Material material;

    // 仓库详情
    private Stock stock;

    private int fid;

    private static final long serialVersionUID = 1L;

    public int getFmaid() {
        return fmaid;
    }

    public void setFmaid(int fmaid) {
        this.fmaid = fmaid;
    }

    public int getFstockid() {
        return fstockid;
    }

    public void setFstockid(int fstockid) {
        this.fstockid = fstockid;
    }

    public int getFqty() {
        return fqty;
    }

    public void setFqty(int fqty) {
        this.fqty = fqty;
    }

    public int getFstate() {
        return fstate;
    }

    public void setFstate(int fstate) {
        this.fstate = fstate;
    }

    public String getFbrand() {
        return fbrand;
    }

    public void setFbrand(String fbrand) {
        this.fbrand = fbrand == null ? null : fbrand.trim();
    }

    public String getFqulity() {
        return fqulity;
    }

    public void setFqulity(String fqulity) {
        this.fqulity = fqulity == null ? null : fqulity.trim();
    }

    public Date getFdeldate() {
        return fdeldate;
    }

    public void setFdeldate(Date fdeldate) {
        this.fdeldate = fdeldate;
    }

    public String getFcontnum() {
        return fcontnum;
    }

    public void setFcontnum(String fcontnum) {
        this.fcontnum = fcontnum == null ? null : fcontnum.trim();
    }

    public int getFreceiptqty() {
        return freceiptqty;
    }

    public void setFreceiptqty(int freceiptqty) {
        this.freceiptqty = freceiptqty;
    }

    public int getFrefoundqty() {
        return frefoundqty;
    }

    public void setFrefoundqty(int frefoundqty) {
        this.frefoundqty = frefoundqty;
    }

    public int getFstoredqty() {
        return fstoredqty;
    }

    public void setFstoredqty(int fstoredqty) {
        this.fstoredqty = fstoredqty;
    }

    public String getFjudgetype() {
        return fjudgetype;
    }

    public void setFjudgetype(String fjudgetype) {
        this.fjudgetype = fjudgetype == null ? null : fjudgetype.trim();
    }

    public String getFnote() {
        return fnote;
    }

    public void setFnote(String fnote) {
        this.fnote = fnote == null ? null : fnote.trim();
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public void setFmaid(Integer fmaid) {
        this.fmaid = fmaid;
    }

    public void setFstockid(Integer fstockid) {
        this.fstockid = fstockid;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }
}