package com.linkpal.service.impl;

import com.linkpal.Excepetion.ImportException;
import com.linkpal.dao.IDataseatDao;
import com.linkpal.model.Dataseat;
import com.linkpal.model.Page;
import com.linkpal.service.IDataseatService;
import com.linkpal.service.IDataseatService;
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
public class DataseatServiceImpl implements IDataseatService {

    @Qualifier("dataseatDaoImpl")
    @Autowired
    IDataseatDao goodseatDao;

    @Override
    public boolean create(Dataseat goodseat) throws Exception{
        return goodseatDao.create(goodseat);
    }

    @Override
    public boolean update(Dataseat goodseat)  throws Exception{
        return goodseatDao.update(goodseat);
    }

    @Override
    public boolean delete(int fid) throws Exception{
        return goodseatDao.delete(fid);
    }

    @Override
    public List<Dataseat> getList() {
        return goodseatDao.getList();
    }

    @Override
    public Dataseat getDetail(String fnumber) {
        return goodseatDao.getDetail(fnumber);
    }

    @Override
    public Dataseat getDetail(int fid) {
        return goodseatDao.getDetail(fid);
    }

    @Override
    public List<Dataseat> getTipList(String fnumber) {
        return goodseatDao.getTipList(fnumber);
    }

    @Override
    public List<Dataseat> showCurrentPage(Page page) {
        int totalSize = page.getPageNow() * page.getPageSize();
        return goodseatDao.showCurrentPage(totalSize, totalSize - page.getPageSize());
    }

    @Override
    public List<Dataseat> showTipPageList(String fnumber, Page page) {
        int totalSize = page.getPageNow() * page.getPageSize();
        return goodseatDao.showTipPageList(fnumber,totalSize, totalSize - page.getPageSize());
    }

    @Override
    public void importInfo(InputStream in, MultipartFile file, Dataseat goodseat, int insertType) throws ImportException {

    }

/*    @Override
    public List<Dataseat> getStockDataseats(int stockid) {
        return goodseatDao.getStockDataseats(stockid);
    }

    @Override
    public List<Dataseat> getNoCabinetDataseats(int stockid) {
        return goodseatDao.getNoCabinetDataseats(stockid);
    }

    @Override
    public List<Dataseat> getCabinetDataseats(int stockid) {
        return goodseatDao.getCabinetDataseats(stockid);
    }

    @Override
    public List<Dataseat> getCabinetDataseats(int stockid, int cabinetid) {
        return goodseatDao.getCabinetDataseats(stockid, cabinetid);
    }*/

    @Override
    public boolean deleteBatch(Integer[] ids) {
        return goodseatDao.deleteBatch(ids);
    }

    @Override
    public Map<String, Object> getPageList(HttpServletRequest request, Dataseat t) {
        PageList<Dataseat> pageList=new PageList<>();
        return pageList.getPageList(goodseatDao,request,t,"Dataseat");
    }
}
