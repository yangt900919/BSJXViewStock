package com.linkpal.map;

import com.linkpal.model.Cabinet;
import com.linkpal.model.example.CabinetExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CabinetMapper extends IBaseMapper<Cabinet>{
    long countByExample(CabinetExample example);

    int deleteByExample(CabinetExample example);

    int deleteByPrimaryKey(Integer fid);

    int insert(Cabinet record);

    int insertSelective(Cabinet record);

    List<Cabinet> selectByExample(CabinetExample example);

    Cabinet selectByPrimaryKey(Integer fid);

    int updateByExampleSelective(@Param("record") Cabinet record, @Param("example") CabinetExample example);

    int updateByExample(@Param("record") Cabinet record, @Param("example") CabinetExample example);

    int updateByPrimaryKeySelective(Cabinet record);

    int updateByPrimaryKey(Cabinet record);
}