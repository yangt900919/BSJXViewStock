package com.linkpal.service;

import com.linkpal.model.GsPrint;
import com.linkpal.model.Material;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface IGsPrintService {

    /***
     * 获取实体对象
     * @param ID
     * @return
     */
     GsPrint getById(int ID);



    /**
     * 新增
     * @param
     * @return
     */
     int add(GsPrint t);

    /**
     * 更新
     * @param
     * @return
     */
     int update(GsPrint t);

    /**
     * 删除
     * @param ID
     * @return
     */
     int delete(int ID);


    /**
     * 批量删除
     * @param IDS
     * @return
     */
     int deleteBatch(Integer[] ids);



    /***
     * 按查询条件获取列表
     * @param stock
     * @return
     */
     Map<String,Object> getPageList(HttpServletRequest request, GsPrint t);

    /**
     * 获取查询的所有条数
     * @param t
     * @return
     */
     int getTotalNum(GsPrint t);



}
