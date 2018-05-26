package com.linkpal.map;

import com.linkpal.model.Operatelog;
import com.linkpal.model.OperatelogExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface OperatelogMapper {
    long countByExample(OperatelogExample example);

    int deleteByExample(OperatelogExample example);

    int insert(Operatelog record);

    int insertSelective(Operatelog record);

    List<Operatelog> selectByExample(OperatelogExample example);

    int updateByExampleSelective(@Param("record") Operatelog record, @Param("example") OperatelogExample example);

    int updateByExample(@Param("record") Operatelog record, @Param("example") OperatelogExample example);

    /**
     * 获取所查询的列表
     * @param pageIndex
     * @param pageSize
     * @param t
     * @return
     */
    public List<Operatelog> getList(Map map);

    /**
     * 获取查询的所有条数
     * @param t
     * @return
     */
    public int getTotalNum(Map map);
}