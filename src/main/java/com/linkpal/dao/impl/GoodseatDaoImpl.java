package com.linkpal.dao.impl;

import com.linkpal.dao.IGoodseatDao;
import com.linkpal.map.GoodseatMapper;
import com.linkpal.map.ScabinetMapper;
import com.linkpal.model.Goodseat;
import com.linkpal.model.Scabinet;
import com.linkpal.model.example.CustomExample;
import com.linkpal.model.example.GoodseatExample;
import com.linkpal.model.example.ScabinetExample;
import com.linkpal.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GoodseatDaoImpl implements IGoodseatDao {

    @Autowired
    GoodseatMapper goodseatMapper;

    @Autowired
    ScabinetMapper scabinetMapper;

    @Override
    public boolean create(Goodseat goodseat) {
        return goodseatMapper.insert(goodseat) > 0;
    }

    @Override
    public boolean update(Goodseat goodseat) {
        GoodseatExample example = new GoodseatExample();
        example.createCriteria().andFidEqualTo(goodseat.getFid());
        return goodseatMapper.updateByExample(goodseat, example) > 0;
    }

    @Override
    public boolean delete(int fid) {
        GoodseatExample example = new GoodseatExample();
        example.createCriteria().andFidEqualTo(fid);
        return goodseatMapper.deleteByExample(example) > 0;
    }

    @Override
    public List<Goodseat> getList() {
        return goodseatMapper.selectByExample(new GoodseatExample());
    }

    @Override
    public Goodseat getDetail(String fnumber) {
        GoodseatExample example = new GoodseatExample();
        example.createCriteria().andFnumberEqualTo(fnumber);
        List<Goodseat> list= goodseatMapper.selectByExample(example);
        return list.size()>0?list.get(0):null;
    }

    @Override
    public Goodseat getDetail(int fid) {
        return goodseatMapper.selectByPrimaryKey(fid);
    }

    @Override
    public List<Goodseat> getTipList(String fnumber) {
        GoodseatExample example = new GoodseatExample();
        example.createCriteria().andFnumberLike("%" + fnumber + "%");
        return goodseatMapper.selectByExample(example);
    }

    @Override
    public List<Goodseat> showCurrentPage(int totalSize, int preSize) {
        return goodseatMapper.showCurrentPage(totalSize, preSize);
    }

    @Override
    public List<Goodseat> showTipPageList(String fnumber, int totalSize, int perSize) {
        return null;
    }

    @Override
    public int getTotalNum(Goodseat t) {

/*
        GoodseatExample example=new GoodseatExample();
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
    public List<Goodseat> getStockGoodseats(int stockid) {
        return goodseatMapper.getListInStock(stockid);
    }

    @Override
    public List<Goodseat> getNoCabinetGoodseats(int stockid) {
        GoodseatExample example = new GoodseatExample();
        example.setOrderByClause("fnumber asc");
        example.createCriteria().andFstockidEqualTo(stockid).andFcabinetidIsNull();
        return goodseatMapper.selectByExample(example);
    }

    @Override
    public List<Goodseat> getCabinetGoodseats(int stockid) {
        GoodseatExample example = new GoodseatExample();
        example.setOrderByClause("fnumber asc");
        example.createCriteria().andFstockidEqualTo(stockid).andFcabinetidIsNotNull();
        return goodseatMapper.selectByExample(example);
    }

    @Override
    public List<Goodseat> getCabinetGoodseats(int stockid, int cabinetid) {
        GoodseatExample example = new GoodseatExample();
        example.setOrderByClause("fnumber asc");
        example.createCriteria().andFstockidEqualTo(stockid).andFcabinetidEqualTo(cabinetid);
        return goodseatMapper.selectByExample(example);
    }*/

    @Override
    public boolean deleteBatch(Integer[] ids) {
        return goodseatMapper.deleteBatch(ids)>0;
    }

    @Override
    public List<Goodseat> getList(int pageIndex, int pageSize, Goodseat t) {
        return goodseatMapper.getList(pageIndex,pageSize,t);
    }
}
