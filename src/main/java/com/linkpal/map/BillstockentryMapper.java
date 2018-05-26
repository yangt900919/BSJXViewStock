package com.linkpal.map;

import com.linkpal.model.Billgetentry;
import com.linkpal.model.Billstockentry;
import com.linkpal.model.example.BillstockentryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BillstockentryMapper {
    long countByExample(BillstockentryExample example);

    int deleteByExample(BillstockentryExample example);

    int deleteByPrimaryKey(Integer fid);

    int insert(Billstockentry record);

    int insertSelective(Billstockentry record);

    List<Billstockentry> selectByExample(BillstockentryExample example);

    Billstockentry selectByPrimaryKey(Integer fid);

    int updateByExampleSelective(@Param("record") Billstockentry record, @Param("example") BillstockentryExample example);

    int updateByExample(@Param("record") Billstockentry record, @Param("example") BillstockentryExample example);

    int updateByPrimaryKeySelective(Billstockentry record);

    int updateByPrimaryKey(Billstockentry record);
    int sumQTY(int foid);

    int checkQty(int fbillid);

    int sumQTYChecked(int fbillid);

    List<Billstockentry> getDetail(int fbillid);

    int checkStatus(int foid);

    int deleteBatch(List<Billstockentry> billgetentries);
}