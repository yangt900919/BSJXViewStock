package com.linkpal.map;

import com.linkpal.model.GsPrint;
import com.linkpal.model.Material;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GsPrintMapper {

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
    List<GsPrint> getList(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize, @Param("t") GsPrint t);

   /**
    * 获取查询的所有条数
    * @param t
    * @return
    */
    int getTotalNum(GsPrint t);

    /*List<GsPrint> getboxList(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize, @Param("t") GsPrint t);

   *//**
    * 获取查询的所有条数
    * @param t
    * @return
    *//*
    int getboxTotalNum(GsPrint t);
   
   String getCSNo();*/

}
