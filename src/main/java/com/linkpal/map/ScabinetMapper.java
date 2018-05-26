package com.linkpal.map;

import com.linkpal.dao.IBaseDao;
import com.linkpal.model.Scabinet;
import com.linkpal.model.example.ScabinetExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ScabinetMapper extends IBaseMapper<Scabinet>{
    long countByExample(ScabinetExample example);

    int deleteByExample(ScabinetExample example);

    int deleteByPrimaryKey(Integer fid);

    int insert(Scabinet record);

    int insertSelective(Scabinet record);

    List<Scabinet> selectByExample(ScabinetExample example);

    Scabinet selectByPrimaryKey(Integer fid);

    int updateByExampleSelective(@Param("record") Scabinet record, @Param("example") ScabinetExample example);

    int updateByExample(@Param("record") Scabinet record, @Param("example") ScabinetExample example);

    int updateByPrimaryKeySelective(Scabinet record);

    int updateByPrimaryKey(Scabinet record);
}