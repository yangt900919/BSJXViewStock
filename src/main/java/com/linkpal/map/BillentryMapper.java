package com.linkpal.map;

import com.linkpal.model.Billentry;
import com.linkpal.model.BillentryKey;
import java.util.List;

import com.linkpal.model.example.BillentryExample;
import org.apache.ibatis.annotations.Param;

public interface BillentryMapper {
    long countByExample(BillentryExample example);

    int deleteByExample(BillentryExample example);

    int deleteByPrimaryKey(BillentryKey key);

    int insert(Billentry record);

    int insertSelective(Billentry record);

    List<Billentry> selectByExample(BillentryExample example);

    Billentry selectByPrimaryKey(BillentryKey key);

    Billentry getDetailByID(int fid);

    int updateByExampleSelective(@Param("record") Billentry record, @Param("example") BillentryExample example);

    int updateByExample(@Param("record") Billentry record, @Param("example") BillentryExample example);

    int updateByPrimaryKeySelective(Billentry record);

    int updateByPrimaryKey(Billentry record);

    int updateByID(Billentry record);

    List<Billentry> getContextShowEntry(int fbillid);

    List<Billentry> getContextShowEntryByNumber(String fnumber);

    int deleteFromID(int fbillid);
}