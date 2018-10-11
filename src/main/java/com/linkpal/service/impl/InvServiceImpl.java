package com.linkpal.service.impl;

import com.linkpal.Excepetion.ImportException;
import com.linkpal.dao.IInvDao;
import com.linkpal.model.Inv;
import com.linkpal.model.Page;
import com.linkpal.service.IInvService;
import com.linkpal.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

@Service("InvServiceImpl")
public class InvServiceImpl implements IInvService {


    @Qualifier("InvDaoImpl")
    @Autowired
    private IInvDao IInvDao;

    @Override
    public boolean deleteBatch(Integer[] ids) {
        return IInvDao.deleteBatch(ids);
    }

    @Override
    public Map<String, Object> getPageList(HttpServletRequest request, Inv t) {
        PageList<Inv> pageList=new PageList<>();
        return pageList.getPageList(IInvDao,request,t,"Inv");
    }

    @Override
    public int close(int ID) {
        return IInvDao.close(ID);
    }

    @Override
    public int closeBatch(Integer[] ids) {
        return IInvDao.closeBatch(ids);
    }

    @Override
    public boolean create(Inv inv) throws Exception {
        return IInvDao.create(inv);
    }

    @Override
    public boolean update(Inv inv) throws Exception {
        return IInvDao.update(inv);
    }

    @Override
    public boolean delete(int fid) throws Exception {
        return IInvDao.delete(fid);
    }

    @Override
    public List<Inv> getList() {
        return null;
    }

    @Override
    public Inv getDetail(String fnumber) {
        return IInvDao.getDetail(fnumber);
    }

    @Override
    public Inv getDetail(int fid) {
        return IInvDao.getDetail(fid);
    }

    @Override
    public List<Inv> getTipList(String fnumber) {
        return null;
    }

    @Override
    public List<Inv> showCurrentPage(Page page) {
        return null;
    }

    @Override
    public List<Inv> showTipPageList(String fnumber, Page page) {
        return null;
    }

    @Override
    public void importInfo(InputStream in, MultipartFile file, Inv inv, int insertType) throws ImportException {

    }
}
