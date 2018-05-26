package com.linkpal.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Organization implements Serializable {
    private Integer fid;

    private String organizationnumber;

    private String organizationname;

    private String organizationaddress;

    private Date createtime;

    private static final long serialVersionUID = 1L;

    public Organization()
    {

        SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );
        try {
            this.createtime=sdf.parse(sdf.format(new Date()));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getOrganizationnumber() {
        return organizationnumber;
    }

    public void setOrganizationnumber(String organizationnumber) {
        this.organizationnumber = organizationnumber == null ? null : organizationnumber.trim();
    }

    public String getOrganizationname() {
        return organizationname;
    }

    public void setOrganizationname(String organizationname) {
        this.organizationname = organizationname == null ? null : organizationname.trim();
    }

    public String getOrganizationaddress() {
        return organizationaddress;
    }

    public void setOrganizationaddress(String organizationaddress) {
        this.organizationaddress = organizationaddress == null ? null : organizationaddress.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}