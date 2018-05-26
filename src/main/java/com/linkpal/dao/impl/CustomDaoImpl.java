package com.linkpal.dao.impl;

import com.linkpal.dao.ICustomDao;
import com.linkpal.map.CustomMapper;
import com.linkpal.model.Custom;
import com.linkpal.model.Page;
import com.linkpal.model.example.CustomExample;
import com.linkpal.model.example.CustomExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomDaoImpl implements ICustomDao {

    @Autowired
    CustomMapper customMapper;

    @Override
    public List<Custom> getTipList(String customnumber) {
        CustomExample example = new CustomExample();
        example.createCriteria().andCustomnumberLike("%" + customnumber + "%");
        return customMapper.selectByExample(example);
    }

    @Override
    public List<Custom> showCurrentPage(int totalSize, int perSize) {
        return customMapper.getPageList(totalSize, perSize);
    }

    @Override
    public List<Custom> showTipPageList(String fnumber, int totalSize, int perSize) {
        return customMapper.getTipPageList(totalSize, perSize, "%" + fnumber + "%");
    }

    @Override
    public int getTotalNum(Custom custom) {

        CustomExample example=new CustomExample();
        if(custom.getCustomnumber()!=null&&!(custom.getCustomnumber().equals("")))
            example.createCriteria().andCustomnumberLike("%"+custom.getCustomnumber()+"%");
        if(custom.getCustomname()!=null&&!(custom.getCustomname().equals("")))
            example.createCriteria().andCustomnameLike("%"+custom.getCustomname()+"%");
        return (int) customMapper.countByExample(example);
    }

    @Override
    public boolean deleteBatch(Integer[] ids) {
        return customMapper.deleteBatch(ids)>0;
    }

    @Override
    public List<Custom> getList(int pageIndex, int pageSize, Custom custom) {
        return customMapper.getList(pageIndex,pageSize,custom);
    }

    @Override
    public Custom getDetail(String customnumber) {
        CustomExample example = new CustomExample();
        example.createCriteria().andCustomnameEqualTo(customnumber);
        List<Custom> list=customMapper.selectByExample(example);
        return list.size()>0?list.get(0):null;
    }

    @Override
    public Custom getDetail(int fid) {
        return customMapper.selectByPrimaryKey(fid);
    }

    @Override
    public boolean create(Custom custom) {
        return customMapper.insert(custom) > 0;
    }

    @Override
    public boolean update(Custom custom) {
        return customMapper.updateByPrimaryKey(custom) > 0;
    }

    @Override
    public boolean delete(int fid) {
        return customMapper.deleteByPrimaryKey(fid) > 0;
    }

    @Override
    public List<Custom> getList() {
        return customMapper.selectByExample(new CustomExample());
    }
}
