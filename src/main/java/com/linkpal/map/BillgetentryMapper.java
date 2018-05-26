package com.linkpal.map;

import com.linkpal.model.Billgetentry;
import com.linkpal.model.example.BillgetentryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BillgetentryMapper {
    long countByExample(BillgetentryExample example);

    int deleteByExample(BillgetentryExample example);

    int deleteByPrimaryKey(Integer fid);

    int insert(Billgetentry record);

    int insertSelective(Billgetentry record);

    List<Billgetentry> selectByExample(BillgetentryExample example);

    Billgetentry selectByPrimaryKey(Integer fid);

    int updateByExampleSelective(@Param("record") Billgetentry record, @Param("example") BillgetentryExample example);

    int updateByExample(@Param("record") Billgetentry record, @Param("example") BillgetentryExample example);

    int updateByPrimaryKeySelective(Billgetentry record);

    int updateByPrimaryKey(Billgetentry record);

    int insertBatch(List<Billgetentry> billgetentries);

    int deleteBatch(List<Billgetentry> billgetentries);
}