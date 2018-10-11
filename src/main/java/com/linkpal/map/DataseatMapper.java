package com.linkpal.map;

import com.linkpal.model.Dataseat;
import com.linkpal.model.Goodseat;
import com.linkpal.model.example.DataseatExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DataseatMapper extends IBaseMapper<Dataseat> {
    long countByExample(DataseatExample example);

    int deleteByExample(DataseatExample example);

    int deleteByPrimaryKey(Integer fid);

    int insert(Dataseat record);

    int insertSelective(Dataseat record);

    List<Dataseat> selectByExample(DataseatExample example);

    Dataseat selectByPrimaryKey(Integer fid);

    int updateByExampleSelective(@Param("record") Dataseat record, @Param("example") DataseatExample example);

    int updateByExample(@Param("record") Dataseat record, @Param("example") DataseatExample example);

    int updateByPrimaryKeySelective(Dataseat record);

    int updateByPrimaryKey(Dataseat record);

    int getTotalNum(Goodseat t);
}