package com.linkpal.map;

import com.linkpal.model.*;

import java.util.List;

import com.linkpal.model.BillorderentryExample;
import org.apache.ibatis.annotations.Param;

public interface BillorderentryMapper {
    long countByExample(BillorderentryExample example);

    int deleteByExample(BillorderentryExample example);

    int insert(Billorderentry record);

    int insertSelective(Billorderentry record);

    List<Billorderentry> selectByExample(BillorderentryExample example);

    int updateByExampleSelective(@Param("record") Billorderentry record, @Param("example") BillorderentryExample example);

    int updateByExample(@Param("record") Billorderentry record, @Param("example") BillorderentryExample example);

    int updateByPrimaryKey(Billorderentry record);

    int deleteBatch(List<Billorderentry> billgetentries);

    int deleteByPrimaryKey(Integer fid);

    Billorderentry selectByPrimaryKey(Integer fid);
}