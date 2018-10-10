package com.linkpal.map;

import com.linkpal.model.Datascabinet;
import com.linkpal.model.example.DatascabinetExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DatascabinetMapper extends IBaseMapper<Datascabinet>{
    long countByExample(DatascabinetExample example);

    int deleteByExample(DatascabinetExample example);

    int deleteByPrimaryKey(Integer fid);

    int insert(Datascabinet record);

    int insertSelective(Datascabinet record);

    List<Datascabinet> selectByExample(DatascabinetExample example);

    Datascabinet selectByPrimaryKey(Integer fid);

    int updateByExampleSelective(@Param("record") Datascabinet record, @Param("example") DatascabinetExample example);

    int updateByExample(@Param("record") Datascabinet record, @Param("example") DatascabinetExample example);

    int updateByPrimaryKeySelective(Datascabinet record);

    int updateByPrimaryKey(Datascabinet record);
}