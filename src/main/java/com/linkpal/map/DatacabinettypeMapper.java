package com.linkpal.map;

import com.linkpal.model.Datacabinettype;
import com.linkpal.model.example.DatacabinettypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DatacabinettypeMapper  extends IBaseMapper<Datacabinettype>{
    long countByExample(DatacabinettypeExample example);

    int deleteByExample(DatacabinettypeExample example);

    int deleteByPrimaryKey(Integer fid);

    int insert(Datacabinettype record);

    int insertSelective(Datacabinettype record);

    List<Datacabinettype> selectByExample(DatacabinettypeExample example);

    Datacabinettype selectByPrimaryKey(Integer fid);

    int updateByExampleSelective(@Param("record") Datacabinettype record, @Param("example") DatacabinettypeExample example);

    int updateByExample(@Param("record") Datacabinettype record, @Param("example") DatacabinettypeExample example);

    int updateByPrimaryKeySelective(Datacabinettype record);

    int updateByPrimaryKey(Datacabinettype record);
}