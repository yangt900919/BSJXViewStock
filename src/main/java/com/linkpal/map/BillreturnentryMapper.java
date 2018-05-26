package com.linkpal.map;

import com.linkpal.model.Billreturnentry;
import com.linkpal.model.BillreturnentryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BillreturnentryMapper {
    long countByExample(BillreturnentryExample example);

    int deleteByExample(BillreturnentryExample example);

    int deleteByPrimaryKey(Integer fid);

    int insert(Billreturnentry record);

    int insertSelective(Billreturnentry record);

    List<Billreturnentry> selectByExample(BillreturnentryExample example);

    Billreturnentry selectByPrimaryKey(Integer fid);

    int updateByExampleSelective(@Param("record") Billreturnentry record, @Param("example") BillreturnentryExample example);

    int updateByExample(@Param("record") Billreturnentry record, @Param("example") BillreturnentryExample example);

    int updateByPrimaryKeySelective(Billreturnentry record);

    int updateByPrimaryKey(Billreturnentry record);
}