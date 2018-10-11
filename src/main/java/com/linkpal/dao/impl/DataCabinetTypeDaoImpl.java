package com.linkpal.dao.impl;

import com.linkpal.dao.IDataCabinetTypeDao;
import com.linkpal.map.DatacabinettypeMapper;
import com.linkpal.map.DatacabinettypeMapper;
import com.linkpal.model.Datacabinettype;
import com.linkpal.model.example.DatacabinettypeExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("DataCabinetTypeDaoImpl")
public class DataCabinetTypeDaoImpl implements IDataCabinetTypeDao {

    @Autowired
    DatacabinettypeMapper cabinettypeMapper;

    @Override
    public boolean deleteBatch(Integer[] ids) {
        return cabinettypeMapper.deleteBatch(ids)>0;
    }

    @Override
    public List<Datacabinettype> getList(int pageIndex, int pageSize, Datacabinettype t) {
        return cabinettypeMapper.getList(pageIndex,pageSize,t);
    }

    @Override
    public boolean create(Datacabinettype cabinettype) throws Exception {
        return cabinettypeMapper.insert(cabinettype)>0;
    }

    @Override
    public boolean update(Datacabinettype cabinettype) throws Exception {
        return cabinettypeMapper.updateByPrimaryKey(cabinettype)>0;
    }

    @Override
    public boolean delete(int fid) throws Exception {
        return cabinettypeMapper.deleteByPrimaryKey(fid)>0;
    }

    @Override
    public List<Datacabinettype> getList() {

       return cabinettypeMapper.selectByExample(new DatacabinettypeExample());
    }

    @Override
    public Datacabinettype getDetail(String fnumber) {

        DatacabinettypeExample example=new DatacabinettypeExample();
        example.createCriteria().andFnumberEqualTo(fnumber);
        List<Datacabinettype> list=cabinettypeMapper.selectByExample(example);
        if(list.size()>0) return list.get(0);
        else return null;
    }

    @Override
    public Datacabinettype getDetail(int fid) {
        return cabinettypeMapper.selectByPrimaryKey(fid);
    }

    @Override
    public List<Datacabinettype> getTipList(String fnumber) {
        return null;
    }

    @Override
    public List<Datacabinettype> showCurrentPage(int totalSize, int preSize) {
        return null;
    }

    @Override
    public List<Datacabinettype> showTipPageList(String fnumber, int totalSize, int perSize) {
        return null;
    }

    @Override
    public int getTotalNum(Datacabinettype t) {

        DatacabinettypeExample example=new DatacabinettypeExample();
        if(t.getFnumber()!=null&&!(t.getFnumber().equals("")))
            example.createCriteria().andFnumberLike("%"+t.getFnumber()+"%");
        if(t.getFname()!=null&&!(t.getFname().equals("")))
            example.createCriteria().andFnameLike("%"+t.getFname()+"%");
        return (int) cabinettypeMapper.countByExample(example);
    }
}
