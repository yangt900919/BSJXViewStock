package com.linkpal.map;

import com.linkpal.model.Datainventory;
import com.linkpal.model.Datainventory;
import com.linkpal.model.example.DatainventoryExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface DatainventoryMapper {
    /**
     * 获取所有列表
     * @return
     */
    public List<Datainventory> getAllList();

    /**
     * 获取所查询的列表
     * @param pageIndex
     * @param pageSize
     * @param t
     * @return
     */
    public List<Datainventory> getList(Map map);

    /**
     * 获取查询的所有条数
     * @param t
     * @return
     */
    public int getTotalNum(Map map);

    /**
     * 更新库存数量
     * @param ID
     * @return
     */
    public int updateQty(Map map);

    /**
     * 获取导出列表
     * @param pageIndex
     * @param pageSize
     * @param t
     * @return
     */
    public List<Datainventory> getExportList(Map map);
}