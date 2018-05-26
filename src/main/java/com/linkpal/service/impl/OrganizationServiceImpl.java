package com.linkpal.service.impl;

import com.linkpal.Excepetion.ImportException;
import com.linkpal.dao.IOrganizationDao;
import com.linkpal.model.Cabinet;
import com.linkpal.model.Organization;
import com.linkpal.model.Page;
import com.linkpal.model.example.OrganizationExample;
import com.linkpal.service.IOrganizationService;
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
public class OrganizationServiceImpl implements IOrganizationService {

    @Qualifier("organizationDaoImpl")
    @Autowired
    IOrganizationDao organizationDao;

    @Override
    public boolean create(Organization organization) throws Exception {
        return organizationDao.create(organization);
    }

    @Override
    public boolean update(Organization organization) throws Exception {
        return organizationDao.update(organization);
    }

    @Override
    public boolean delete(int fid) throws Exception {
        return organizationDao.delete(fid);
    }

    @Override
    public List<Organization> getList() {
        return organizationDao.getList();
    }

    @Override
    public Organization getDetail(String organizationnumber) {
        return organizationDao.getDetail(organizationnumber);
    }

    @Override
    public Organization getDetail(int fid) {
        return organizationDao.getDetail(fid);
    }

    @Override
    public List<Organization> getTipList(String fnumber) {
        return null;
    }

    @Override
    public List<Organization> showCurrentPage(Page page) {
        int totalSize = page.getPageNow() * page.getPageSize();
        return organizationDao.showCurrentPage(totalSize, totalSize - page.getPageSize());
    }

    @Override
    public List<Organization> showTipPageList(String fnumber, Page page) {
        int totalSize = page.getPageNow() * page.getPageSize();
        return organizationDao.showTipPageList(fnumber, totalSize, totalSize - page.getPageSize());
    }

    @Override
    public void importInfo(InputStream in, MultipartFile file, Organization organization, int insertType) throws ImportException {

    }

    @Override
    public boolean deleteBatch(Integer[] ids) {
        return organizationDao.deleteBatch(ids);
    }

    @Override
    public Map<String, Object> getPageList(HttpServletRequest request, Organization t) {
        PageList<Organization> plist=new PageList<>();
        return plist.getPageList(organizationDao,request,t,"Organization");
    }
}
