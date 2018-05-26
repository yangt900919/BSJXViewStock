package com.linkpal.service.impl;

import com.linkpal.Excepetion.ImportException;
import com.linkpal.dao.IGoodseatDao;
import com.linkpal.model.Goodseat;
import com.linkpal.model.Material;
import com.linkpal.model.Page;
import com.linkpal.service.IGoodseatService;
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
public class GoodseatServiceImpl implements IGoodseatService {

    @Qualifier("goodseatDaoImpl")
    @Autowired
    IGoodseatDao goodseatDao;

    @Override
    public boolean create(Goodseat goodseat) throws Exception{
        return goodseatDao.create(goodseat);
    }

    @Override
    public boolean update(Goodseat goodseat)  throws Exception{
        return goodseatDao.update(goodseat);
    }

    @Override
    public boolean delete(int fid) throws Exception{
        return goodseatDao.delete(fid);
    }

    @Override
    public List<Goodseat> getList() {
        return goodseatDao.getList();
    }

    @Override
    public Goodseat getDetail(String fnumber) {
        return goodseatDao.getDetail(fnumber);
    }

    @Override
    public Goodseat getDetail(int fid) {
        return goodseatDao.getDetail(fid);
    }

    @Override
    public List<Goodseat> getTipList(String fnumber) {
        return goodseatDao.getTipList(fnumber);
    }

    @Override
    public List<Goodseat> showCurrentPage(Page page) {
        int totalSize = page.getPageNow() * page.getPageSize();
        return goodseatDao.showCurrentPage(totalSize, totalSize - page.getPageSize());
    }

    @Override
    public List<Goodseat> showTipPageList(String fnumber, Page page) {
        int totalSize = page.getPageNow() * page.getPageSize();
        return goodseatDao.showTipPageList(fnumber,totalSize, totalSize - page.getPageSize());
    }

    @Override
    public void importInfo(InputStream in, MultipartFile file, Goodseat goodseat, int insertType) throws ImportException {

    }

/*    @Override
    public List<Goodseat> getStockGoodseats(int stockid) {
        return goodseatDao.getStockGoodseats(stockid);
    }

    @Override
    public List<Goodseat> getNoCabinetGoodseats(int stockid) {
        return goodseatDao.getNoCabinetGoodseats(stockid);
    }

    @Override
    public List<Goodseat> getCabinetGoodseats(int stockid) {
        return goodseatDao.getCabinetGoodseats(stockid);
    }

    @Override
    public List<Goodseat> getCabinetGoodseats(int stockid, int cabinetid) {
        return goodseatDao.getCabinetGoodseats(stockid, cabinetid);
    }*/

    @Override
    public boolean deleteBatch(Integer[] ids) {
        return goodseatDao.deleteBatch(ids);
    }

    @Override
    public Map<String, Object> getPageList(HttpServletRequest request, Goodseat t) {
        PageList<Goodseat> pageList=new PageList<>();
        return pageList.getPageList(goodseatDao,request,t,"GoodSeat");
    }
}
