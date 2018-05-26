package com.linkpal.dao.impl;

import com.linkpal.dao.IPermissionDao;
import com.linkpal.map.PermissionMapper;
import com.linkpal.model.Permission;
import com.linkpal.model.example.PermissionExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("PermissionDaoImpl")
public class PermissionDaoImpl implements IPermissionDao {

    @Autowired
    PermissionMapper permissionMapper;
    @Override
    public boolean deleteBatch(Integer[] ids) {
        return permissionMapper.deleteBatch(ids)>0;
    }

    @Override
    public List<Permission> getList(int pageIndex, int pageSize, Permission t) {
        return permissionMapper.getList(pageIndex,pageSize,t);
    }

    @Override
    public boolean create(Permission permission) throws Exception {
        return permissionMapper.insert(permission)>0;
    }

    @Override
    public boolean update(Permission permission) throws Exception {
        return permissionMapper.updateByPrimaryKey(permission)>0;
    }

    @Override
    public boolean delete(int fid) throws Exception {
        return permissionMapper.deleteByPrimaryKey(fid)>0;
    }

    @Override
    public List<Permission> getList() {
        return permissionMapper.selectByExample(new PermissionExample());
    }

    @Override
    public Permission getDetail(String fnumber) {

        PermissionExample example=new PermissionExample();

        example.createCriteria().andFnumberEqualTo(fnumber);

        List<Permission> list=permissionMapper.selectByExample(example);

        if(list.size()>0)return list.get(0);
        else return  null;

    }

    @Override
    public Permission getDetail(int fid) {
        return permissionMapper.selectByPrimaryKey(fid);
    }

    @Override
    public List<Permission> getTipList(String fnumber) {
        return null;
    }

    @Override
    public List<Permission> showCurrentPage(int totalSize, int preSize) {
        return null;
    }

    @Override
    public List<Permission> showTipPageList(String fnumber, int totalSize, int perSize) {
        return null;
    }

    @Override
    public int getTotalNum(Permission t) {
        PermissionExample example=new PermissionExample();

        if(t.getFnumber()!=null||!(t.getFnumber().equals("")))
        {
            example.createCriteria().andFnumberLike("%"+t.getFnumber()+"%");
        }
        if(t.getFname()!=null||!(t.getFname().equals("")))
            example.createCriteria().andFnameLike("%"+t.getFname()+"%");
        return (int) permissionMapper.countByExample(example);
    }
}
