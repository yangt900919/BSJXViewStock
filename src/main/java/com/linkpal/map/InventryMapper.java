package com.linkpal.map;

import com.linkpal.model.Inventry;
import com.linkpal.model.InventryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InventryMapper {
    long countByExample(InventryExample example);

    int deleteByExample(InventryExample example);

    int deleteByPrimaryKey(Integer fid);

    int insert(Inventry record);

    int insertSelective(Inventry record);

    List<Inventry> selectByExample(InventryExample example);

    Inventry selectByPrimaryKey(Integer fid);

    int updateByExampleSelective(@Param("record") Inventry record, @Param("example") InventryExample example);

    int updateByExample(@Param("record") Inventry record, @Param("example") InventryExample example);

    int updateByPrimaryKeySelective(Inventry record);

    int updateByPrimaryKey(Inventry record);
}