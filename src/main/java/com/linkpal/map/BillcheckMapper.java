package com.linkpal.map;

import com.linkpal.model.Billcheck;
import com.linkpal.model.Billget;
import com.linkpal.model.example.BillcheckExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface BillcheckMapper {
    long countByExample(BillcheckExample example);

    int deleteByExample(BillcheckExample example);

    int deleteByPrimaryKey(Integer fid);

    int insert(Billcheck record);

    int insertSelective(Billcheck record);

    List<Billcheck> selectByExample(BillcheckExample example);

    Billcheck selectByPrimaryKey(Integer fid);

    int updateByExampleSelective(@Param("record") Billcheck record, @Param("example") BillcheckExample example);

    int updateByExample(@Param("record") Billcheck record, @Param("example") BillcheckExample example);

    int updateByPrimaryKeySelective(Billcheck record);

    int updateByPrimaryKey(Billcheck record);

    List<Billcheck> getList(Map map);

    int getTotalNum(Map map);

    int deleteBatch(Integer[] ids);

    String getAutoNumber();

    String checkRelation(Map map);

    float getPushDownQty(@Param("fentryid") Integer fentryid,@Param("fid") Integer fid);

    String initAutoboxno(@Param("fonumber") String fonumber);

    int BillCheck(@Param("fid") Integer fid);
}