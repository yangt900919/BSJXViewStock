package com.linkpal.model;

import java.io.Serializable;
import java.util.Date;

public class Rolerpermission implements Serializable {
    private Integer fid;

    private Integer froleid;

    private Integer fpermissionid;

    private Date fcreatetime;

    private static final long serialVersionUID = 1L;

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Integer getFroleid() {
        return froleid;
    }

    public void setFroleid(Integer froleid) {
        this.froleid = froleid;
    }

    public Integer getFpermissionid() {
        return fpermissionid;
    }

    public void setFpermissionid(Integer fpermissionid) {
        this.fpermissionid = fpermissionid;
    }

    public Date getFcreatetime() {
        return fcreatetime;
    }

    public void setFcreatetime(Date fcreatetime) {
        this.fcreatetime = fcreatetime;
    }
}