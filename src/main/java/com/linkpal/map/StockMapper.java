package com.linkpal.map;

import com.linkpal.dao.IBaseDao;
import com.linkpal.model.Stock;
import com.linkpal.model.example.StockExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StockMapper extends IBaseMapper<Stock>{
    long countByExample(StockExample example);

    int deleteByExample(StockExample example);

    int deleteByPrimaryKey(Integer fid);

    int insert(Stock record);

    int insertSelective(Stock record);

    List<Stock> selectByExample(StockExample example);

    Stock selectByPrimaryKey(Integer fid);

    int updateByExampleSelective(@Param("record") Stock record, @Param("example") StockExample example);

    int updateByExample(@Param("record") Stock record, @Param("example") StockExample example);

    int updateByPrimaryKeySelective(Stock record);

    int updateByPrimaryKey(Stock record);

    List<Stock> getTipPageList(int totalSize, int perSize, String fnumber);

    List<Stock> getPageList(int totalSize, int perSize);
}