package com.linkpal.dao.impl;

import com.linkpal.dao.IOrganizationDao;
import com.linkpal.map.OrganizationMapper;
import com.linkpal.model.Organization;
import com.linkpal.model.Page;
import com.linkpal.model.example.OrganizationExample;
import com.linkpal.model.example.OrganizationExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrganizationDaoImpl implements IOrganizationDao {

    @Autowired
    OrganizationMapper organizationMapper;

    @Override
    public boolean create(Organization organization) {
        return organizationMapper.insert(organization) > 0;
    }

    @Override
    public boolean update(Organization organization) {
        return organizationMapper.updateByPrimaryKey(organization) > 0;
    }

    @Override
    public boolean delete(int fid) {
        return organizationMapper.deleteByPrimaryKey(fid) > 0;
    }

    @Override
    public List<Organization> getList() {
        return organizationMapper.selectByExample(new OrganizationExample());
    }

    @Override
    public Organization getDetail(String organizationnumber) {
        return organizationMapper.getDetail(organizationnumber);
    }

    @Override
    public Organization getDetail(int fid) {
        return organizationMapper.selectByPrimaryKey(fid);
    }

    @Override
    public List<Organization> getTipList(String fnumber) {
        OrganizationExample example = new OrganizationExample();
        example.createCriteria().andOrganizationnumberLike("%" + fnumber + "%");
        return organizationMapper.selectByExample(example);
    }

    @Override
    public List<Organization> showCurrentPage(int totalSize, int perSize) {
        return organizationMapper.getPageList(perSize, totalSize);
    }

    @Override
    public List<Organization> showTipPageList(String fnumber, int totalSize, int perSize) {
        return organizationMapper.getTipPageList(perSize, totalSize, "%" + fnumber + "%");
    }

    @Override
    public int getTotalNum(Organization organization) {

       OrganizationExample example=new OrganizationExample();
        if(organization.getOrganizationnumber()!=null&&!(organization.getOrganizationnumber().equals("")))
            example.createCriteria().andOrganizationnumberLike("%"+organization.getOrganizationnumber()+"%");
        if(organization.getOrganizationname()!=null&&!(organization.getOrganizationname().equals("")))
            example.createCriteria().andOrganizationnameLike("%"+organization.getOrganizationname()+"%");
        return (int) organizationMapper.countByExample(example);
    }

    @Override
    public boolean deleteBatch(Integer[] ids) {
        return organizationMapper.deleteBatch(ids)>0;
    }

    @Override
    public List<Organization> getList(int pageIndex, int pageSize, Organization organization) {
        return organizationMapper.getList(pageIndex,pageSize,organization);
    }

}
