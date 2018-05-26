package com.linkpal.model;

/**
 * 基础资料导入模板
 */
public class ImportTemplet {

    private String table_name;//表明
    private String column_name;//字段名
    private String data_type;//数据类型
    private String column_desc;//字段描述

    public String getTable_name() {
        return table_name;
    }

    public void setTable_name(String table_name) {
        this.table_name = table_name;
    }

    public String getColumn_name() {
        return column_name;
    }

    public void setColumn_name(String column_name) {
        this.column_name = column_name;
    }

    public String getData_type() {
        return data_type;
    }

    public void setData_type(String data_type) {
        this.data_type = data_type;
    }

    public String getColumn_desc() {
        return column_desc;
    }

    public void setColumn_desc(String column_desc) {
        this.column_desc = column_desc;
    }
}
