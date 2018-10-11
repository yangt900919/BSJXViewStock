package com.linkpal.map;

import com.linkpal.model.Datacabinet;
import com.linkpal.model.example.DatacabinetExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DatacabinetMapper extends IBaseMapper<Datacabinet>{
    long countByExample(DatacabinetExample example);

    int deleteByExample(DatacabinetExample example);

    int deleteByPrimaryKey(Integer fid);

    int insert(Datacabinet record);

    int insertSelective(Datacabinet record);

    List<Datacabinet> selectByExample(DatacabinetExample example);

    Datacabinet selectByPrimaryKey(Integer fid);

    int updateByExampleSelective(@Param("record") Datacabinet record, @Param("example") DatacabinetExample example);

    int updateByExample(@Param("record") Datacabinet record, @Param("example") DatacabinetExample example);

    int updateByPrimaryKeySelective(Datacabinet record);

    int updateByPrimaryKey(Datacabinet record);
}