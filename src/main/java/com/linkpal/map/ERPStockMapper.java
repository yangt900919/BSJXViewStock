package com.linkpal.map;

import com.linkpal.model.ERPStock;
import com.linkpal.model.Material;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ERPStockMapper {

   /***
    * 获取实体对象
    * @param ID
    * @return
    */
    ERPStock getById(int ID);

  

   /**
    * 新增
    * @param
    * @return
    */
    int add(ERPStock t);

   /**
    * 更新
    * @param
    * @return
    */
    int update(ERPStock t);

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

    List<ERPStock> getAllList();

   /***
    * 按查询条件获取列表
    * @param stock
    * @return
    */
    List<ERPStock> getList(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize, @Param("t") ERPStock t);

   /**
    * 获取查询的所有条数
    * @param t
    * @return
    */
    int getTotalNum(ERPStock t);


}
