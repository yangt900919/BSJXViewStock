package com.linkpal.map;

import com.linkpal.model.Supplier;
import com.linkpal.model.example.SupplierExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SupplierMapper extends IBaseMapper<Supplier>{
    long countByExample(SupplierExample example);

    int deleteByExample(SupplierExample example);

    int deleteByPrimaryKey(int fid);

    int insert(Supplier record);

    int insertSelective(Supplier record);

    List<Supplier> selectByExample(SupplierExample example);

    Supplier selectByPrimaryKey(int fid);

    Supplier getSupplierDetail(String suppliernumber);

    int updateByExampleSelective(@Param("record") Supplier record, @Param("example") SupplierExample example);

    int updateByExample(@Param("record") Supplier record, @Param("example") SupplierExample example);

    int updateByPrimaryKeySelective(Supplier record);

    int updateByPrimaryKey(Supplier record);

    List<Supplier> getTipPageList(int totalSize, int perSize, String fnumber);

    List<Supplier> getPageList(int totalSize, int perSize);
}