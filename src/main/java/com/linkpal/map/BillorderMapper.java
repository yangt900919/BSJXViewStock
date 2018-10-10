package com.linkpal.map;

import com.linkpal.model.*;

import java.util.List;
import java.util.Map;

import com.linkpal.model.BillorderExample;
import org.apache.ibatis.annotations.Param;

public interface BillorderMapper {
    long countByExample(BillorderExample example);

    int deleteByExample(BillorderExample example);

    int insert(Billorder record);

    int insertSelective(Billorder record);

    List<Billorder> selectByExample(BillorderExample example);

    Billorder selectByPrimaryKey(Integer fid);

    int updateByExampleSelective(@Param("record") Billorder record, @Param("example") BillorderExample example);

    int updateByExample(@Param("record") Billorder record, @Param("example") BillorderExample example);

    int updateByPrimaryKey(Billorder record);

    List<Billorder> getList(Map map);

    int getTotalNum(Map map);

    int deleteBatch(Integer[] ids);

    int deleteByPrimaryKey(Integer fid);

    String getAutoNumber();

    String checkRelation(Map map);


    float getPushDownQty(@Param("fentryid") Integer fentryid,@Param("fid") Integer fid);

    List<Map<String,Object>> saveBillOrder(Map map);

    void updateStock(Map map);
}