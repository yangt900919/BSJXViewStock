package com.linkpal.dao.impl;

import com.linkpal.dao.IBillOrderDao;
import com.linkpal.map.BillorderMapper;
import com.linkpal.map.BillorderentryMapper;
import com.linkpal.model.Billorder;
import com.linkpal.model.BillorderExample;
import com.linkpal.model.Billorderentry;
import com.linkpal.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component("BillOrderDaoImpl")
public class BillOrderDaoImpl implements IBillOrderDao {

    @Autowired
    BillorderMapper billorderMapper;

    @Autowired
    BillorderentryMapper billorderentryMapper;


    @Override
    public boolean create(Billorder billorder) throws Exception {
       try{ billorderMapper.insert(billorder);}
       catch (Exception e){e.printStackTrace();}
        Billorder b=getDetail(billorder.getFnumber());
        int i=1;
        for(Billorderentry entry:billorder.getBillorderentries())
        {
            entry.setFbillid(b.getFbillid());
            entry.setFentriyid(i);
            entry.setFstate(0);
            i++;
            try{
                billorderentryMapper.insert(entry);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

        }
        return true;
    }

    @Override
    public boolean update(Billorder billorder) throws Exception {

        List<Billorderentry> billorderentries=billorder.getBillorderentries();

        List<Billorderentry> billorderentries1=billorderMapper.selectByPrimaryKey(billorder.getFbillid()).getBillorderentries();

        for(int j=billorderentries1.size();j<billorderentries.size();j--)
        {
            billorderentryMapper.deleteByPrimaryKey(billorderentries1.get(j).getFid());
        }

        int i=billorderentries.size()+1;

        for(Billorderentry entry:billorderentries)
        {
            if(StringUtil.Change(entry.getFid())>0)
            billorderentryMapper.updateByPrimaryKey(entry);
            else
            {
                entry.setFbillid(billorder.getFbillid());
                entry.setFentriyid(i);
                entry.setFstate(0);
                i++;
                billorderentryMapper.insert(entry);
            }
        }

        return billorderMapper.updateByPrimaryKey(billorder)>0;
    }

    @Override
    public boolean delete(int fid) throws Exception {
        billorderentryMapper.deleteBatch(billorderMapper.selectByPrimaryKey(fid).getBillorderentries());
        return billorderMapper.deleteByPrimaryKey(fid)>0;
    }

    @Override
    public List<Billorder> getList() {
        return billorderMapper.selectByExample(new BillorderExample());
    }

    @Override
    public Billorder getDetail(String fnumber) {
        BillorderExample example=new BillorderExample();
        example.createCriteria().andFnumberLike("%"+fnumber+"%");

        List list=null;
        try {
          list=  billorderMapper.selectByExample(example);
        }
        catch (Exception e)
        {

            e.printStackTrace();
        }
        if(list.size()>0)
        return (Billorder) list.get(0);
        else return null;
    }

    @Override
    public Billorder getDetail(int fid) {
        return billorderMapper.selectByPrimaryKey(fid);
    }

    @Override
    public List<Billorder> getTipList(String fnumber) {
        return null;
    }

    @Override
    public List<Billorder> showCurrentPage(int totalSize, int preSize) {
        return null;
    }

    @Override
    public List<Billorder> showTipPageList(String fnumber, int totalSize, int perSize) {
        return null;
    }

    @Override
    public int getTotalNum(Billorder billorder) {
        return 0;
    }

    @Override
    public boolean deleteBatch(Integer[] ids) {
        return billorderMapper.deleteBatch(ids)>0;
    }

    @Override
    public List<Billorder> getList(int pageIndex, int pageSize, Billorder billorder) {
        return null;
    }

    @Override
    public List<Billorder> getList(Map map) {
        return billorderMapper.getList(map);
    }

    @Override
    public int getTotalNum(Map map) {
        return billorderMapper.getTotalNum(map);
    }

    @Override
    public Billorderentry getentryDetail(Integer fid) {
        return billorderentryMapper.selectByPrimaryKey(fid);
    }

    @Override
    public String getAutoNumber() {
        return billorderMapper.getAutoNumber();
    }

    @Override
    public void deleteEntry(Integer fid) {
        billorderentryMapper.deleteByPrimaryKey(fid);
    }

    @Override
    public String checkRelation(Map map) {
        return billorderMapper.checkRelation(map);
    }

    @Override
    public float getPushDownQty(Integer fentryid,Integer fid) {
        return billorderMapper.getPushDownQty(fentryid,fid);
    }
}
