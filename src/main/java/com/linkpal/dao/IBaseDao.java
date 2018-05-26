package com.linkpal.dao;

import com.linkpal.model.Bill;
import com.linkpal.model.Cabinet;
import com.linkpal.model.Page;

import java.util.List;

public interface IBaseDao<T> {

    boolean create(T t) throws Exception;

    boolean update(T t) throws Exception;

    boolean delete(int fid) throws Exception;

    List<T> getList();

    T getDetail(String fnumber);

    T getDetail(int fid);

    List<T> getTipList(String fnumber);

    List<T> showCurrentPage(int totalSize, int preSize);

    List<T> showTipPageList(String fnumber, int totalSize, int perSize);

    public int getTotalNum(T t);


    public boolean deleteBatch(Integer[] ids);


    /***
     * 按查询条件获取列表
     * @param
     * @return
     */
    public List<T> getList(int pageIndex, int pageSize, T t);
}
