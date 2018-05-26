package com.linkpal.map;

import com.linkpal.model.Custom;
import com.linkpal.model.example.CustomExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomMapper extends IBaseMapper<Custom>{
    long countByExample(CustomExample example);

    int deleteByExample(CustomExample example);

    int deleteByPrimaryKey(int fid);

    int insert(Custom record);

    int insertSelective(Custom record);

    List<Custom> selectByExample(CustomExample example);

    Custom selectByPrimaryKey(int fid);

    Custom getDetail(String customnumber);

    int updateByExampleSelective(@Param("record") Custom record, @Param("example") CustomExample example);

    int updateByExample(@Param("record") Custom record, @Param("example") CustomExample example);

    int updateByPrimaryKeySelective(Custom record);

    int updateByPrimaryKey(Custom record);

    List<Custom> getTipPageList(int totalSize, int perSize, String fnumber);

    List<Custom> getPageList(int totalSize, int perSize);
}