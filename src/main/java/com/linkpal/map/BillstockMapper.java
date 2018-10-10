package com.linkpal.map;

import com.linkpal.model.Billget;
import com.linkpal.model.Billstock;
import com.linkpal.model.example.BillstockExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface BillstockMapper {
    long countByExample(BillstockExample example);

    int deleteByExample(BillstockExample example);

    int deleteByPrimaryKey(Integer fid);

    int insert(Billstock record);

    int insertSelective(Billstock record);

    List<Billstock> selectByExample(BillstockExample example);

    Billstock selectByPrimaryKey(Integer fid);

    int updateByExampleSelective(@Param("record") Billstock record, @Param("example") BillstockExample example);

    int updateByExample(@Param("record") Billstock record, @Param("example") BillstockExample example);

    int updateByPrimaryKeySelective(Billstock record);

    int updateByPrimaryKey(Billstock record);
    List<Billstock> getUnCompleteBills(int userid);

    List<Billstock> getList(Map map);

    String getAutoNumber();

    int getTotalNum(Map map);

    int deleteBatch(Integer[] ids);

    void BillStockRewrite_Order(Map map);
}