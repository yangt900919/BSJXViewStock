package com.linkpal.map;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IBaseMapper<T> {

    /**
     * 批量删除
     * @param ids
     * @return
     */
    public int deleteBatch(Integer[] ids);




    /***
     * 按查询条件获取列表
     * @param
     * @return
     */
    public List<T> getList(@Param("pageIndex")int pageIndex, @Param("pageSize")int pageSize, @Param("t")T t);

/*    *//**
     * 获取查询的所有条数
     * @param t
     * @return
     *//*
    public int getTotalNum(T t);*/
}
