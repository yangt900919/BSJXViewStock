package com.linkpal.service.impl;

import com.linkpal.Excepetion.ImportException;
import com.linkpal.dao.ISupplierDao;
import com.linkpal.model.Organization;
import com.linkpal.model.Page;
import com.linkpal.model.Supplier;
import com.linkpal.service.ISupplierService;
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
public class SupplierServiceImpl implements ISupplierService {

    @Qualifier("supplierDaoImpl")
    @Autowired
    ISupplierDao supplierDao;

    @Override
    public Supplier getDetail(String suppliernumber) {
        return supplierDao.getDetail(suppliernumber);
    }

    @Override
    public Supplier getDetail(int fid) {
        return supplierDao.getDetail(fid);
    }

    @Override
    public List<Supplier> getTipList(String suppliernumber) {
        return supplierDao.getTipList(suppliernumber);
    }

    @Override
    public List<Supplier> showCurrentPage(Page page) {
        int totalSize = page.getPageNow() * page.getPageSize();
        return supplierDao.showCurrentPage(totalSize, totalSize - page.getPageSize());
    }

    @Override
    public List<Supplier> showTipPageList(String fnumber, Page page) {
        int totalSize = page.getPageNow() * page.getPageSize();
        return supplierDao.showTipPageList(fnumber, totalSize, totalSize - page.getPageSize());
    }

    @Override
    public void importInfo(InputStream in, MultipartFile file, Supplier supplier, int insertType) throws ImportException {

    }

    @Override
    public boolean create(Supplier supplier) throws Exception {
        return supplierDao.create(supplier);
    }

    @Override
    public boolean update(Supplier supplier) throws Exception {
        return supplierDao.update(supplier);
    }

    @Override
    public boolean delete(int fid) throws Exception {
        return supplierDao.delete(fid);
    }

    @Override
    public List<Supplier> getList() {
        return supplierDao.getList();
    }

    @Override
    public boolean deleteBatch(Integer[] ids) {
        return supplierDao.deleteBatch(ids);
    }

    @Override
    public Map<String, Object> getPageList(HttpServletRequest request, Supplier t) {
        PageList<Supplier> plist=new PageList<>();
        return plist.getPageList(supplierDao,request,t,"Supplier");
    }
}
