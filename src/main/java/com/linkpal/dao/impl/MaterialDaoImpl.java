package com.linkpal.dao.impl;

import com.linkpal.dao.IMaterialDao;
import com.linkpal.map.MaterialMapper;
import com.linkpal.model.Material;
import com.linkpal.model.Page;
import com.linkpal.model.example.MaterialExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Component
public class MaterialDaoImpl implements IMaterialDao {

    @Autowired
    MaterialMapper materialMapper;

    @Override
    public List<Material> getTipList(String code) {
        MaterialExample example = new MaterialExample();
        example.createCriteria().andMaterialnumberLike("%" + code + "%");
        return materialMapper.selectByExample(example);
    }

    @Override
    public List<Material> showCurrentPage(int totalSize, int perSize) {
        return materialMapper.getPageList(perSize, totalSize);
    }

    @Override
    public List<Material> showTipPageList(String fnumber, int totalSize, int perSize) {
        return materialMapper.getTipPageList(perSize, totalSize, "%" + fnumber + "%");
    }

    @Override
    public int getTotalNum(Material material) {

        MaterialExample example=new MaterialExample();
        if(material.getMaterialnumber()!=null&&!(material.getMaterialnumber().equals("")))
            example.createCriteria().andMaterialnumberLike("%"+material.getMaterialnumber()+"%");
        if(material.getMaterialname()!=null&&!(material.getMaterialname().equals("")))
            example.createCriteria().andMaterialnameLike("%"+material.getMaterialname()+"%");
        return (int) materialMapper.countByExample(example);
    }

    @Override
    public boolean deleteBatch(Integer[] ids) {
        return materialMapper.deleteBatch(ids)>0;
    }

    @Override
    public List<Material> getList(int pageIndex, int pageSize, Material material) {
        return materialMapper.getList(pageIndex,pageSize,material);
    }

    @Override
    public Material getDetail(String materialnumber) {
        return materialMapper.getDetail(materialnumber);
    }

    @Override
    public Material getDetail(int fid) {
        return materialMapper.selectByPrimaryKey(fid);
    }

    @Override
    public List<Material> getList() {
        MaterialExample example = new MaterialExample();
        return materialMapper.selectByExample(example);
    }

    @Override
    @Transactional
    public boolean delete(int fid) {
        int row = materialMapper.deleteByPrimaryKey(fid);
        return row > 0;
    }

    @Override
    public boolean update(Material material) {
        MaterialExample example = new MaterialExample();
        example.createCriteria().andFidEqualTo(material.getFid());
        int row = materialMapper.updateByExample(material, example);
        return row > 0;
    }

    @Override
    @Transactional
    public boolean create(Material material) {
        return materialMapper.insert(material) > 0;
    }

    @Override
    public List<Material> getnoStList() {
        return materialMapper.getnoStList();
    }
}
