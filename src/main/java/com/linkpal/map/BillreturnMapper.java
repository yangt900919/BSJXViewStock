package com.linkpal.map;

import com.linkpal.model.Billreturn;
import com.linkpal.model.BillreturnExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BillreturnMapper {
    long countByExample(BillreturnExample example);

    int deleteByExample(BillreturnExample example);

    int deleteByPrimaryKey(Integer fid);

    int insert(Billreturn record);

    int insertSelective(Billreturn record);

    List<Billreturn> selectByExample(BillreturnExample example);

    Billreturn selectByPrimaryKey(Integer fid);

    int updateByExampleSelective(@Param("record") Billreturn record, @Param("example") BillreturnExample example);

    int updateByExample(@Param("record") Billreturn record, @Param("example") BillreturnExample example);

    int updateByPrimaryKeySelective(Billreturn record);

    int updateByPrimaryKey(Billreturn record);
}