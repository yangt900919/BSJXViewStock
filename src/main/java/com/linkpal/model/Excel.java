package com.linkpal.model;

import org.apache.poi.xssf.usermodel.XSSFCellStyle;

import java.io.Serializable;

public class Excel implements Serializable {

    private String title;//Excel标题
    private String headTextName; //列头（标题）名
    private String propertyName; //对应字段名
    private Integer cols; //合并单元格数
    private XSSFCellStyle cellStyle;
    private String tableName;//表名

    public Excel(){
    }
    public Excel(String title,Integer cols,String tableName)
    {

        this.title=title;
        this.cols=cols;
        this.tableName=tableName;
    }
    public Excel(String headTextName, String propertyName){
        this.headTextName = headTextName;
        this.propertyName = propertyName;
        this.cols=0;
    }
    public Excel(String headTextName, String propertyName, Integer cols) {
        super();
        this.headTextName = headTextName;
        this.propertyName = propertyName;
        this.cols = cols;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHeadTextName() {
        return headTextName;
    }

    public void setHeadTextName(String headTextName) {
        this.headTextName = headTextName;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public Integer getCols() {
        return cols;
    }

    public void setCols(Integer cols) {
        this.cols = cols;
    }

    public XSSFCellStyle getCellStyle() {
        return cellStyle;
    }

    public void setCellStyle(XSSFCellStyle cellStyle) {
        this.cellStyle = cellStyle;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}
