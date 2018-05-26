package com.linkpal.map;

import com.linkpal.model.Goodseat;
import com.linkpal.model.example.GoodseatExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface GoodseatMapper extends IBaseMapper<Goodseat>{
    long countByExample(GoodseatExample example);

    int deleteByExample(GoodseatExample example);

    int deleteByPrimaryKey(Integer fid);

    int insert(Goodseat record);

    int insertSelective(Goodseat record);

    List<Goodseat> selectByExample(GoodseatExample example);

    Goodseat selectByPrimaryKey(Integer fid);

    int updateByExampleSelective(@Param("record") Goodseat record, @Param("example") GoodseatExample example);

    int updateByExample(@Param("record") Goodseat record, @Param("example") GoodseatExample example);

    int updateByPrimaryKeySelective(Goodseat record);

    int updateByPrimaryKey(Goodseat record);

    List<Goodseat> getList();

    List<Goodseat> showCurrentPage(int totalSize, int preSize);

    Goodseat getDetail(String fnumber);

    Goodseat getDetailByID(int fid);

    int getTotalNum(Goodseat t);
}