package com.linkpal.service.impl;

import com.linkpal.Excepetion.ImportException;
import com.linkpal.dao.IDsPrintDao;
import com.linkpal.model.Dsprint;
import com.linkpal.model.Page;
import com.linkpal.service.IDsPrintService;
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
public class DsPrintServiceImpl implements IDsPrintService {


    @Qualifier("DsPrintDaoImpl")
    @Autowired
    private IDsPrintDao dsprintDao;

    @Override
    public boolean create(Dsprint dsprint) throws Exception{
        return dsprintDao.create(dsprint);
    }

    @Override
    public boolean update(Dsprint dsprint)  throws Exception{
        return dsprintDao.update(dsprint);
    }

    @Override
    public boolean delete(int fid) throws Exception{
        return dsprintDao.delete(fid);
    }

    @Override
    public List<Dsprint> getList() {
        return dsprintDao.getList();
    }

    @Override
    public Dsprint getDetail(String fnumber) {
        return dsprintDao.getDetail(fnumber);
    }

    @Override
    public Dsprint getDetail(int fid) {
        return dsprintDao.getDetail(fid);
    }

    @Override
    public List<Dsprint> getTipList(String fnumber) {
        return dsprintDao.getTipList(fnumber);
    }

    @Override
    public List<Dsprint> showCurrentPage(Page page) {
        int totalSize = page.getPageNow() * page.getPageSize();
        return dsprintDao.showCurrentPage(totalSize, totalSize - page.getPageSize());
    }

    @Override
    public List<Dsprint> showTipPageList(String fnumber, Page page) {
        int totalSize = page.getPageNow() * page.getPageSize();
        return dsprintDao.showTipPageList(fnumber,totalSize, totalSize - page.getPageSize());
    }

    @Override
    public void importInfo(InputStream in, MultipartFile file, Dsprint dsprint, int insertType) throws ImportException {

    }

/*    @Override
    public List<DsPrint> getStockDsPrints(int stockid) {
        return dsprintDao.getStockDsPrints(stockid);
    }

    @Override
    public List<DsPrint> getNoCabinetDsPrints(int stockid) {
        return dsprintDao.getNoCabinetDsPrints(stockid);
    }

    @Override
    public List<DsPrint> getCabinetDsPrints(int stockid) {
        return dsprintDao.getCabinetDsPrints(stockid);
    }

    @Override
    public List<DsPrint> getCabinetDsPrints(int stockid, int cabinetid) {
        return dsprintDao.getCabinetDsPrints(stockid, cabinetid);
    }*/

    @Override
    public boolean deleteBatch(Integer[] ids) {
        return dsprintDao.deleteBatch(ids);
    }

    @Override
    public Map<String, Object> getPageList(HttpServletRequest request, Dsprint t) {
        PageList<Dsprint> pageList=new PageList<>();
        return pageList.getPageList(dsprintDao,request,t,"Dsprint");
    }
}
