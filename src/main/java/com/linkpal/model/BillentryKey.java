package com.linkpal.model;

import java.io.Serializable;

public class BillentryKey implements Serializable {
    private Integer fbillid;

    private Integer fentriyid;

    private static final long serialVersionUID = 1L;

    public Integer getFbillid() {
        return fbillid;
    }

    public void setFbillid(Integer fbillid) {
        this.fbillid = fbillid;
    }

    public Integer getFentriyid() {
        return fentriyid;
    }

    public void setFentriyid(Integer fentriyid) {
        this.fentriyid = fentriyid;
    }
}