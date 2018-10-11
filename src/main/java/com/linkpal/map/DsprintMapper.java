package com.linkpal.map;

import com.linkpal.model.Dataseat;
import com.linkpal.model.Dsprint;
import com.linkpal.model.Goodseat;
import com.linkpal.model.example.DsprintExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DsprintMapper extends IBaseMapper<Dsprint> {
    long countByExample(DsprintExample example);

    int deleteByExample(DsprintExample example);

    int deleteByPrimaryKey(Integer fid);

    int insert(Dsprint record);

    int insertSelective(Dsprint record);

    List<Dsprint> selectByExample(DsprintExample example);

    Dsprint selectByPrimaryKey(Integer fid);

    int updateByExampleSelective(@Param("record") Dsprint record, @Param("example") DsprintExample example);

    int updateByExample(@Param("record") Dsprint record, @Param("example") DsprintExample example);

    int updateByPrimaryKeySelective(Dsprint record);

    int updateByPrimaryKey(Dsprint record);

    int getTotalNum(Dataseat t);
}