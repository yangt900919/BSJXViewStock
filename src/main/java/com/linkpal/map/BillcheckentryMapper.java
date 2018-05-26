package com.linkpal.map;

import com.linkpal.model.Billcheckentry;
import com.linkpal.model.Billentry;
import com.linkpal.model.Billstockentry;
import com.linkpal.model.example.BillcheckentryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BillcheckentryMapper {
    long countByExample(BillcheckentryExample example);

    int deleteByExample(BillcheckentryExample example);

    int deleteByPrimaryKey(Integer fid);

    int insert(Billcheckentry record);

    int insertSelective(Billcheckentry record);

    List<Billcheckentry> selectByExample(BillcheckentryExample example);

    Billcheckentry selectByPrimaryKey(Integer fid);

    int updateByExampleSelective(@Param("record") Billcheckentry record, @Param("example") BillcheckentryExample example);

    int updateByExample(@Param("record") Billcheckentry record, @Param("example") BillcheckentryExample example);

    int updateByPrimaryKeySelective(Billcheckentry record);

    int updateByPrimaryKey(Billcheckentry record);
    int saveBillUncheck(Billcheckentry record);

    int saveBillInspect(Billcheckentry record);

    int sumQTY(int foid);

    int sumEligQty(int foid);

    int sumUnQty(int foid);

    int sumQTYExceptSelf(@Param("foid") int foid, @Param("fid")  int fid);

    int sumQTYByStatus(int foid);

    int sumEligQtyStatus(int foid);

    int sumUnQtyStatus(int foid);

    int checkStatus(int foid);

    List<Billcheckentry> getDetail(int fbillid);

    int deleteBatch(List<Billcheckentry> billgetentries);
}