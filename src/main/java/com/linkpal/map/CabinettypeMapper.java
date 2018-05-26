package com.linkpal.map;

import com.linkpal.model.Cabinettype;
import com.linkpal.model.example.CabinettypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CabinettypeMapper extends IBaseMapper<Cabinettype>{
    long countByExample(CabinettypeExample example);

    int deleteByExample(CabinettypeExample example);

    int deleteByPrimaryKey(Integer fid);

    int insert(Cabinettype record);

    int insertSelective(Cabinettype record);

    List<Cabinettype> selectByExample(CabinettypeExample example);

    Cabinettype selectByPrimaryKey(Integer fid);

    int updateByExampleSelective(@Param("record") Cabinettype record, @Param("example") CabinettypeExample example);

    int updateByExample(@Param("record") Cabinettype record, @Param("example") CabinettypeExample example);

    int updateByPrimaryKeySelective(Cabinettype record);

    int updateByPrimaryKey(Cabinettype record);
}