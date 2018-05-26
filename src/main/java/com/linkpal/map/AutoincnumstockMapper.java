package com.linkpal.map;

import com.linkpal.model.Autoincnum;
import com.linkpal.model.example.AutoincnumExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AutoincnumstockMapper {
    long countByExample(AutoincnumExample example);

    int deleteByExample(AutoincnumExample example);

    int insert(String fnumber);

    int insertSelective(Autoincnum record);

    List<Autoincnum> selectByExample(AutoincnumExample example);

    int updateByExampleSelective(@Param("record") Autoincnum record, @Param("example") AutoincnumExample example);

    int updateByExample(@Param("record") Autoincnum record, @Param("example") AutoincnumExample example);

    String getLargestNum();
}