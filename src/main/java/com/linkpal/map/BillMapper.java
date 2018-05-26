package com.linkpal.map;

import com.linkpal.model.Bill;
import com.linkpal.model.example.BillExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BillMapper {
    long countByExample(BillExample example);

    int deleteByExample(BillExample example);

    int insert(Bill record);

    int insertSelective(Bill record);

    List<Bill> selectByExample(BillExample example);

    int updateByExampleSelective(@Param("record") Bill record, @Param("example") BillExample example);

    int updateByExample(@Param("record") Bill record, @Param("example") BillExample example);

    Bill getDetail(String fnumber);

    Bill getContextShowBill(int fbillid);

    List<Bill> getBills();

    int deleteFromID(int fbillid);

    List<Bill> getTipPageList(int totalSize, int perSize, String fnumber);

    List<Bill> getPageList(int totalSize, int perSize);

    int checkBill(int fbillid, int fstatus);
}