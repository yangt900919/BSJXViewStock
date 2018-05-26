package com.linkpal.service.impl;

import com.linkpal.Excepetion.ImportException;
import com.linkpal.dao.IStockDao;
import com.linkpal.model.Page;
import com.linkpal.model.Stock;
import com.linkpal.service.IStockService;
import com.linkpal.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

@Service
public class StockServiceImpl implements IStockService {

    @Qualifier("stockDaoImpl")
    @Autowired
    IStockDao stockDao;

    @Override
    public List<Stock> getTipList(String stocknumber) {
        return stockDao.getTipList(stocknumber);
    }

    @Override
    public List<Stock> showCurrentPage(Page page) {
        int totalSize = page.getPageNow() * page.getPageSize();
        return stockDao.showCurrentPage(totalSize, totalSize - page.getPageSize());
    }

    @Override
    public List<Stock> showTipPageList(String fnumber, Page page) {
        int totalSize = page.getPageNow() * page.getPageSize();
        return stockDao.showTipPageList(fnumber, totalSize, totalSize - page.getPageSize());
    }

    @Override
    public void importInfo(InputStream in, MultipartFile file, Stock stock, int insertType) throws ImportException {

    }

    @Override
    public List<Stock> getList() {
        return stockDao.getList();
    }

    @Override
    public boolean create(Stock stock) throws Exception {
        return stockDao.create(stock);
    }

    @Override
    public boolean update(Stock stock) throws Exception {
        return stockDao.update(stock);
    }

    @Override
    public boolean delete(int fid) throws Exception {
        return stockDao.delete(fid);
    }

    @Override
    public Stock getDetail(String stocknumber) {
        return stockDao.getDetail(stocknumber);
    }

    @Override
    public Stock getDetail(int fid) {
        return stockDao.getDetail(fid);
    }

    @Override
    public boolean deleteBatch(Integer[] ids) {
        return stockDao.deleteBatch(ids);
    }

    @Override
    public Map<String, Object> getPageList(HttpServletRequest request, Stock t) {
        PageList<Stock> pageList=new PageList<>();
        return pageList.getPageList(stockDao,request,t,"Stock");
    }
}
