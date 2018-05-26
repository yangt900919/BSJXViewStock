package com.linkpal.dao.impl;

import com.linkpal.dao.IBillGetDao;
import com.linkpal.dao.IBillStockDao;
import com.linkpal.map.BillstockMapper;
import com.linkpal.map.BillstockentryMapper;
import com.linkpal.model.Billstock;
import com.linkpal.model.Billstockentry;
import com.linkpal.model.example.BillstockExample;
import com.linkpal.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component("BillStockDaoImpl")
public class BillStockDaoImpl implements IBillStockDao {

    @Autowired
    BillstockMapper billstockMapper;

    @Autowired
    BillstockentryMapper billstockentryMapper;


    @Override
    public boolean create(Billstock billstock) throws Exception {
        billstockMapper.insert(billstock);

        Billstock b=getDetail(billstock.getFnumber());
        int i=1;
        for(Billstockentry entry:billstock.getBillstockentries())
        {
            entry.setFbillid(b.getFid());
            entry.setFentryid(i);
            i++;
            try{
                billstockentryMapper.insert(entry);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

        }
        return true;
    }

    @Override
    public boolean update(Billstock billstock) throws Exception {

        List<Billstockentry> billstockentries=billstock.getBillstockentries();
        List<Billstockentry> billstockentries1=billstockMapper.selectByPrimaryKey(billstock.getFid()).getBillstockentries();

        for(int j=billstockentries1.size();j<billstockentries.size();j--)
        {
            billstockentryMapper.deleteByPrimaryKey(billstockentries1.get(j).getFid());
        }

        int i=billstockentries.size()+1;

        for(Billstockentry entry:billstockentries)
        {
            if(StringUtil.Change(entry.getFid())>0)
            billstockentryMapper.updateByPrimaryKey(entry);
            else
            {
                entry.setFbillid(entry.getFbillid());
                entry.setFentryid(i);
                i++;
                billstockentryMapper.insert(entry);
            }
        }

        return billstockMapper.updateByPrimaryKey(billstock)>0;
    }

    @Override
    public boolean delete(int fid) throws Exception {
        billstockentryMapper.deleteBatch(billstockMapper.selectByPrimaryKey(fid).getBillstockentries());
        return billstockMapper.deleteByPrimaryKey(fid)>0;
    }

    @Override
    public List<Billstock> getList() {
        return billstockMapper.selectByExample(new BillstockExample());
    }

    @Override
    public Billstock getDetail(String fnumber) {
        BillstockExample example=new BillstockExample();
        example.createCriteria().andFnumberLike("%"+fnumber+"%");

        List list=null;
        try {
          list=  billstockMapper.selectByExample(example);
        }
        catch (Exception e)
        {

            e.printStackTrace();
        }
        if(list.size()>0)
        return (Billstock) list.get(0);
        else return null;
    }

    @Override
    public Billstock getDetail(int fid) {
        return billstockMapper.selectByPrimaryKey(fid);
    }

    @Override
    public List<Billstock> getTipList(String fnumber) {
        return null;
    }

    @Override
    public List<Billstock> showCurrentPage(int totalSize, int preSize) {
        return null;
    }

    @Override
    public List<Billstock> showTipPageList(String fnumber, int totalSize, int perSize) {
        return null;
    }

    @Override
    public int getTotalNum(Billstock billstock) {
        return 0;
    }

    @Override
    public boolean deleteBatch(Integer[] ids) {
        return billstockMapper.deleteBatch(ids)>0;
    }

    @Override
    public List<Billstock> getList(int pageIndex, int pageSize, Billstock billstock) {
        return null;
    }

    @Override
    public List<Billstock> getList(Map map) {
        return billstockMapper.getList(map);
    }

    @Override
    public int getTotalNum(Map map) {
        return billstockMapper.getTotalNum(map);
    }

    @Override
    public String getAutoNumber() {
        return billstockMapper.getAutoNumber();
    }
}
