package com.linkpal.dao.impl;

import com.linkpal.dao.ICabinetTypeDao;
import com.linkpal.map.CabinettypeMapper;
import com.linkpal.model.Cabinettype;
import com.linkpal.model.example.CabinettypeExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("CabinetTypeDaoImpl")
public class CabinetTypeDaoImpl implements ICabinetTypeDao {

    @Autowired
    CabinettypeMapper cabinettypeMapper;

    @Override
    public boolean deleteBatch(Integer[] ids) {
        return cabinettypeMapper.deleteBatch(ids)>0;
    }

    @Override
    public List<Cabinettype> getList(int pageIndex, int pageSize, Cabinettype t) {
        return cabinettypeMapper.getList(pageIndex,pageSize,t);
    }

    @Override
    public boolean create(Cabinettype cabinettype) throws Exception {
        return cabinettypeMapper.insert(cabinettype)>0;
    }

    @Override
    public boolean update(Cabinettype cabinettype) throws Exception {
        return cabinettypeMapper.updateByPrimaryKey(cabinettype)>0;
    }

    @Override
    public boolean delete(int fid) throws Exception {
        return cabinettypeMapper.deleteByPrimaryKey(fid)>0;
    }

    @Override
    public List<Cabinettype> getList() {

       return cabinettypeMapper.selectByExample(new CabinettypeExample());
    }

    @Override
    public Cabinettype getDetail(String fnumber) {

        CabinettypeExample example=new CabinettypeExample();
        example.createCriteria().andFnumberEqualTo(fnumber);
        List<Cabinettype> list=cabinettypeMapper.selectByExample(example);
        if(list.size()>0) return list.get(0);
        else return null;
    }

    @Override
    public Cabinettype getDetail(int fid) {
        return cabinettypeMapper.selectByPrimaryKey(fid);
    }

    @Override
    public List<Cabinettype> getTipList(String fnumber) {
        return null;
    }

    @Override
    public List<Cabinettype> showCurrentPage(int totalSize, int preSize) {
        return null;
    }

    @Override
    public List<Cabinettype> showTipPageList(String fnumber, int totalSize, int perSize) {
        return null;
    }

    @Override
    public int getTotalNum(Cabinettype t) {

        CabinettypeExample example=new CabinettypeExample();
        if(t.getFnumber()!=null&&!(t.getFnumber().equals("")))
            example.createCriteria().andFnumberLike("%"+t.getFnumber()+"%");
        if(t.getFname()!=null&&!(t.getFname().equals("")))
            example.createCriteria().andFnameLike("%"+t.getFname()+"%");
        return (int) cabinettypeMapper.countByExample(example);
    }
}
