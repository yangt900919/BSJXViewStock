package com.linkpal.map;

import com.linkpal.model.Billget;
import com.linkpal.model.example.BillgetExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface BillgetMapper {
    long countByExample(BillgetExample example);

    int deleteByExample(BillgetExample example);

    int deleteByPrimaryKey(Integer fid);

    int insert(Billget record);

    int insertSelective(Billget record);

    List<Billget> selectByExample(BillgetExample example);

    Billget selectByPrimaryKey(Integer fid);

    int updateByExampleSelective(@Param("record") Billget record, @Param("example") BillgetExample example);

    int updateByExample(@Param("record") Billget record, @Param("example") BillgetExample example);

    int updateByPrimaryKeySelective(Billget record);

    int updateByPrimaryKey(Billget record);

     List<Billget> getList(Map map);

     int getTotalNum(Map map);

     int deleteBatch(Integer[] ids);

    String getAutoNumber();

}