package com.linkpal.model;



import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Material implements Serializable {


    private String materialnumber;

    private Integer fid;

    private String materialname;

    private String materialmodel;

    private String materialunit;

    private int fqty;

    private Date createtime;

    private static final long serialVersionUID = 1L;

    public Material()
    {
        SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );
        try {
            this.createtime=sdf.parse(sdf.format(new Date()));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public String getMaterialnumber() {
        return materialnumber;
    }

    public void setMaterialnumber(String materialnumber) {
        this.materialnumber = materialnumber == null ? null : materialnumber.trim();
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getMaterialname() {
        return materialname;
    }

    public void setMaterialname(String materialname) {
        this.materialname = materialname == null ? null : materialname.trim();
    }

    public String getMaterialmodel() {
        return materialmodel;
    }

    public void setMaterialmodel(String materialmodel) {
        this.materialmodel = materialmodel == null ? null : materialmodel.trim();
    }

    public String getMaterialunit() {
        return materialunit;
    }

    public void setMaterialunit(String materialunit) {
        this.materialunit = materialunit == null ? null : materialunit.trim();
    }

    public int getFqty() {
        return fqty;
    }

    public void setFqty(int fqty) {
        this.fqty = fqty;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}