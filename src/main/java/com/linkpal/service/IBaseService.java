package com.linkpal.service;

import com.linkpal.Excepetion.ImportException;
import com.linkpal.model.Page;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

public interface IBaseService<T> {

    boolean create(T t) throws Exception;

    boolean update(T t) throws Exception;

    boolean delete(int fid) throws Exception;

    List<T> getList();

    T getDetail(String fnumber);

    T getDetail(int fid);

    List<T> getTipList(String fnumber);

    List<T> showCurrentPage(Page page);

    List<T> showTipPageList(String fnumber, Page page);

    /**
     * 基础资料导入
     * @param in 输入流
     * @param file 导入的文件
     * @param t 导入的基础资料对应的model
     * @param insertType 0--新增导入，1--覆盖导入
     * @throws Exception
     */
    public void importInfo(InputStream in, MultipartFile file, T t, int insertType) throws ImportException;
}
