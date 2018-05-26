package com.linkpal.map;

import com.linkpal.model.MaPrint;
import com.linkpal.model.Material;
import org.apache.ibatis.annotations.Param;

import java.util.List;

 public interface MaPrintMapper {

    /***
     * 获取实体对象
     * @param ID
     * @return
     */
     MaPrint getById(int ID);

   

    /**
     * 新增
     * @param
     * @return
     */
     int add(MaPrint t);

    /**
     * 更新
     * @param
     * @return
     */
     int update(MaPrint t);

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
     List<MaPrint> getList(@Param("pageIndex")int pageIndex, @Param("pageSize")int pageSize, @Param("t")Material t);

    /**
     * 获取查询的所有条数
     * @param t
     * @return
     */
     int getTotalNum(Material t);

     List<MaPrint> getboxList(@Param("pageIndex")int pageIndex, @Param("pageSize")int pageSize, @Param("t")MaPrint t);

    /**
     * 获取查询的所有条数
     * @param t
     * @return
     */
     int getboxTotalNum(MaPrint t);
    
    String getCSNo();

}
