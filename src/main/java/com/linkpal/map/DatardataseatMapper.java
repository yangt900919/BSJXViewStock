package com.linkpal.map;

import com.linkpal.model.Datardataseat;
import com.linkpal.model.Materialrgoodseat;
import com.linkpal.model.example.DatardataseatExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DatardataseatMapper extends IBaseMapper<Datardataseat> {
    long countByExample(DatardataseatExample example);

    int deleteByExample(DatardataseatExample example);

    int deleteByPrimaryKey(Integer fid);

    int insert(Datardataseat record);

    int insertSelective(Datardataseat record);

    List<Datardataseat> selectByExample(DatardataseatExample example);

    Datardataseat selectByPrimaryKey(Integer fid);

    int updateByExampleSelective(@Param("record") Datardataseat record, @Param("example") DatardataseatExample example);

    int updateByExample(@Param("record") Datardataseat record, @Param("example") DatardataseatExample example);

    int updateByPrimaryKeySelective(Datardataseat record);

    int updateByPrimaryKey(Datardataseat record);

    int getTotalNum(Datardataseat t);
}