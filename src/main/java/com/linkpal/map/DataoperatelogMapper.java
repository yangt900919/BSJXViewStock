package com.linkpal.map;

import com.linkpal.model.Dataoperatelog;
import com.linkpal.model.Operatelog;
import com.linkpal.model.example.DataoperatelogExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface DataoperatelogMapper {
    long countByExample(DataoperatelogExample example);

    int deleteByExample(DataoperatelogExample example);

    int insert(Dataoperatelog record);

    int insertSelective(Dataoperatelog record);

    List<Dataoperatelog> selectByExample(DataoperatelogExample example);

    int updateByExampleSelective(@Param("record") Dataoperatelog record, @Param("example") DataoperatelogExample example);

    int updateByExample(@Param("record") Dataoperatelog record, @Param("example") DataoperatelogExample example);

    /**
     * 获取所查询的列表
     * @param pageIndex
     * @param pageSize
     * @param t
     * @return
     */
    public List<Dataoperatelog> getList(Map map);

    /**
     * 获取查询的所有条数
     * @param t
     * @return
     */
    public int getTotalNum(Map map);
}