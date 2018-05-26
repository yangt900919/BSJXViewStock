package com.linkpal.dao;

import com.linkpal.model.ImportTemplet;

import java.util.List;


public interface IImportTempletDao {

    /***
     * 获取模板中需要的字段信息
     * @param basic_name 基础资料表明
     * @return 返回基础资料对应的数据库字段信息
     */
    public List<ImportTemplet> getColumnInfo(String basic_name);
}
