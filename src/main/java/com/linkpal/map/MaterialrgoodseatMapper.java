package com.linkpal.map;

import com.linkpal.model.Goodseat;
import com.linkpal.model.Materialrgoodseat;
import com.linkpal.model.example.MaterialrgoodseatExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface MaterialrgoodseatMapper extends IBaseMapper<Materialrgoodseat>{
    long countByExample(MaterialrgoodseatExample example);

    int deleteByExample(MaterialrgoodseatExample example);

    int deleteByPrimaryKey(Integer fid);

    int insert(Materialrgoodseat record);

    int insertSelective(Materialrgoodseat record);

    List<Materialrgoodseat> selectByExample(MaterialrgoodseatExample example);

    Materialrgoodseat selectByPrimaryKey(Integer fid);

    int updateByExampleSelective(@Param("record") Materialrgoodseat record, @Param("example") MaterialrgoodseatExample example);

    int updateByExample(@Param("record") Materialrgoodseat record, @Param("example") MaterialrgoodseatExample example);

    int updateByPrimaryKeySelective(Materialrgoodseat record);

    int updateByPrimaryKey(Materialrgoodseat record);

    int getTotalNum(Materialrgoodseat t);

    void ajustGoodsSeat(Map map);
}