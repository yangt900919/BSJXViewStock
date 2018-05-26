package com.linkpal.dao.impl;

import com.linkpal.dao.IStockDao;
import com.linkpal.map.StockMapper;
import com.linkpal.model.Stock;
import com.linkpal.model.example.StockExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StockDaoImpl implements IStockDao {

    @Autowired
    StockMapper stockMapper;

    @Override
    public List<Stock> getTipList(String stocknumber) {
        StockExample example = new StockExample();
        example.createCriteria().andStocknumberLike("%" + stocknumber + "%");
        return stockMapper.selectByExample(example);
    }

    @Override
    public List<Stock> showCurrentPage(int totalSize, int perSize) {
        return stockMapper.getPageList(perSize, totalSize);
    }

    @Override
    public List<Stock> showTipPageList(String fnumber, int totalSize, int perSize) {
        return stockMapper.getTipPageList(perSize, totalSize, "%" + fnumber + "%");
    }

    @Override
    public int getTotalNum(Stock t) {

        StockExample example=new StockExample();
        if(t.getStocknumber()!=null&&!(t.getStocknumber().equals("")))
            example.createCriteria().andStocknumberLike("%"+t.getStocknumber()+"%");
        if(t.getStockname()!=null&&!(t.getStockname().equals("")))
            example.createCriteria().andStocknameLike("%"+t.getStockname()+"%");
        if(t.getStockaddress()!=null&&!(t.getStockaddress().equals("")))
            example.createCriteria().andStockaddressLike("%"+t.getStockaddress()+"%");
        if(t.getStocktel()!=null&&!(t.getStocktel().equals("")))
            example.createCriteria().andStocktelLike("%"+t.getStocktel()+"%");
        return (int)stockMapper.countByExample(example);

    }

    @Override
    public Stock getDetail(String stocknumber) {

        StockExample example = new StockExample();
        example.createCriteria().andStocknameEqualTo(stocknumber);
        List<Stock> list=stockMapper.selectByExample(example);
        if(list.size()>0) return list.get(0);
        else return null;
    }

    @Override
    public Stock getDetail(int fid) {
        return stockMapper.selectByPrimaryKey(fid);
    }

    @Override
    public boolean create(Stock stock) {
        return stockMapper.insert(stock) > 0;
    }

    @Override
    public boolean update(Stock stock) {
        return stockMapper.updateByPrimaryKey(stock) > 0;
    }

    @Override
    public boolean delete(int fid) {
        return stockMapper.deleteByPrimaryKey(fid) > 0;
    }

    @Override
    public List<Stock> getList() {
        StockExample example = new StockExample();
        return stockMapper.selectByExample(example);
    }

    @Override
    public boolean deleteBatch(Integer[] ids) {
        return stockMapper.deleteBatch(ids)>0;
    }

    @Override
    public List<Stock> getList(int pageIndex, int pageSize, Stock t) {
        return stockMapper.getList(pageIndex,pageSize,t);
    }
}
