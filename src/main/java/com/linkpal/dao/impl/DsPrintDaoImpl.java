package com.linkpal.dao.impl;

import com.linkpal.dao.IDsPrintDao;
import com.linkpal.map.DsprintMapper;
import com.linkpal.model.Dsprint;
import com.linkpal.model.example.DsprintExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("DsPrintDaoImpl")
public class DsPrintDaoImpl implements IDsPrintDao {

    @Autowired
    DsprintMapper dsprintMapper;

    @Override
    public boolean create(Dsprint dsprint) throws Exception {
        return dsprintMapper.insert(dsprint)>0;
    }

    @Override
    public boolean update(Dsprint dsprint) throws Exception {
        return dsprintMapper.updateByPrimaryKey(dsprint)>0;
    }

    @Override
    public boolean delete(int fid) throws Exception {
        return dsprintMapper.deleteByPrimaryKey(fid)>0;
    }

    @Override
    public List<Dsprint> getList() {
        return dsprintMapper.selectByExample(new DsprintExample());
    }

    @Override
    public Dsprint getDetail(String fnumber) {

        //DsprintExample dsprintExample=new DsprintExample();
        //dsprintExample.createCriteria().andfnu
        return null;
    }

    @Override
    public Dsprint getDetail(int fid) {
        return dsprintMapper.selectByPrimaryKey(fid);
    }

    @Override
    public List<Dsprint> getTipList(String fnumber) {
        return null;
    }

    @Override
    public List<Dsprint> showCurrentPage(int totalSize, int preSize) {
        return null;
    }

    @Override
    public List<Dsprint> showTipPageList(String fnumber, int totalSize, int perSize) {
        return null;
    }

    @Override
    public int getTotalNum(Dsprint dsprint) {
        return dsprintMapper.getTotalNum(dsprint);
    }

    @Override
    public boolean deleteBatch(Integer[] ids) {
        return dsprintMapper.deleteBatch(ids)>0;
    }

    @Override
    public List<Dsprint> getList(int pageIndex, int pageSize, Dsprint dsprint) {
        return dsprintMapper.getList(pageIndex,pageSize,dsprint);
    }
}
