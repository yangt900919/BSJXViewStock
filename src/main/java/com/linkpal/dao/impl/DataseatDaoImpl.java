package com.linkpal.dao.impl;

import com.linkpal.dao.IDataseatDao;
import com.linkpal.dao.IDataseatDao;
import com.linkpal.map.DatascabinetMapper;
import com.linkpal.map.DataseatMapper;
import com.linkpal.map.ScabinetMapper;
import com.linkpal.model.Dataseat;
import com.linkpal.model.example.DataseatExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataseatDaoImpl implements IDataseatDao {

    @Autowired
    DataseatMapper goodseatMapper;

    @Autowired
    DatascabinetMapper scabinetMapper;

    @Override
    public boolean create(Dataseat goodseat) {
        return goodseatMapper.insert(goodseat) > 0;
    }

    @Override
    public boolean update(Dataseat goodseat) {
        DataseatExample example = new DataseatExample();
        example.createCriteria().andFidEqualTo(goodseat.getFid());
        return goodseatMapper.updateByExample(goodseat, example) > 0;
    }

    @Override
    public boolean delete(int fid) {
        DataseatExample example = new DataseatExample();
        example.createCriteria().andFidEqualTo(fid);
        return goodseatMapper.deleteByExample(example) > 0;
    }

    @Override
    public List<Dataseat> getList() {
        return goodseatMapper.selectByExample(new DataseatExample());
    }

    @Override
    public Dataseat getDetail(String fnumber) {
        DataseatExample example = new DataseatExample();
        example.createCriteria().andFnumberEqualTo(fnumber);
        List<Dataseat> list= goodseatMapper.selectByExample(example);
        return list.size()>0?list.get(0):null;
    }

    @Override
    public Dataseat getDetail(int fid) {
        return goodseatMapper.selectByPrimaryKey(fid);
    }

    @Override
    public List<Dataseat> getTipList(String fnumber) {
        DataseatExample example = new DataseatExample();
        example.createCriteria().andFnumberLike("%" + fnumber + "%");
        return goodseatMapper.selectByExample(example);
    }

    @Override
    public List<Dataseat> showCurrentPage(int totalSize, int preSize) {
        return null;
    }

    @Override
    public List<Dataseat> showTipPageList(String fnumber, int totalSize, int perSize) {
        return null;
    }

    @Override
    public int getTotalNum(Dataseat t) {

/*
        DataseatExample example=new DataseatExample();
        try {
            if (t.getFnumber() != null && !(t.getFnumber().equals("")))
                example.createCriteria().andFnumberLike("%" + t.getFnumber() + "%");
            if (StringUtil.Change(t.getFscabinetid()) > 0)
                example.createCriteria().andFscabinetidEqualTo(t.getFscabinetid());
            if (StringUtil.Change(t.getFcabinetid()) > 0)
                example.createCriteria().andFcabinetidEqualTo(t.getFcabinetid());
            if (StringUtil.Change(t.getFstockid()) > 0)
                example.createCriteria().andFstockidEqualTo(t.getFstockid());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }*/
        return  goodseatMapper.getTotalNum(t);
    }

  /*  @Override
    public List<Dataseat> getStockDataseats(int stockid) {
        return goodseatMapper.getListInStock(stockid);
    }

    @Override
    public List<Dataseat> getNoCabinetDataseats(int stockid) {
        DataseatExample example = new DataseatExample();
        example.setOrderByClause("fnumber asc");
        example.createCriteria().andFstockidEqualTo(stockid).andFcabinetidIsNull();
        return goodseatMapper.selectByExample(example);
    }

    @Override
    public List<Dataseat> getCabinetDataseats(int stockid) {
        DataseatExample example = new DataseatExample();
        example.setOrderByClause("fnumber asc");
        example.createCriteria().andFstockidEqualTo(stockid).andFcabinetidIsNotNull();
        return goodseatMapper.selectByExample(example);
    }

    @Override
    public List<Dataseat> getCabinetDataseats(int stockid, int cabinetid) {
        DataseatExample example = new DataseatExample();
        example.setOrderByClause("fnumber asc");
        example.createCriteria().andFstockidEqualTo(stockid).andFcabinetidEqualTo(cabinetid);
        return goodseatMapper.selectByExample(example);
    }*/

    @Override
    public boolean deleteBatch(Integer[] ids) {
        return goodseatMapper.deleteBatch(ids)>0;
    }

    @Override
    public List<Dataseat> getList(int pageIndex, int pageSize, Dataseat t) {
        return goodseatMapper.getList(pageIndex,pageSize,t);
    }
}
