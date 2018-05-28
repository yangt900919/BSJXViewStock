package com.linkpal.dao.impl;

import com.linkpal.dao.IBillCheckDao;
import com.linkpal.map.BillcheckMapper;
import com.linkpal.map.BillcheckentryMapper;
import com.linkpal.model.Billcheck;
import com.linkpal.model.Billcheckentry;
import com.linkpal.model.example.BillcheckExample;
import com.linkpal.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component("BillCheckDaoImpl")

public class BillCheckDaoImpl implements IBillCheckDao {

    @Autowired
    BillcheckMapper billcheckMapper;

    @Autowired
    BillcheckentryMapper billcheckentryMapper;


    @Override
    public boolean create(Billcheck billcheck) throws Exception {
        billcheckMapper.insert(billcheck);
        Billcheck b=getDetail(billcheck.getFnumber());
        int i=1;
        for(Billcheckentry entry:billcheck.getBillcheckentries())
        {
            entry.setFbillid(b.getFid());
            entry.setFentryid(i);
            i++;
            try{
                billcheckentryMapper.insert(entry);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

        }
        return true;
    }

    @Override
    public boolean update(Billcheck billcheck) throws Exception {

        List<Billcheckentry> billcheckentries=billcheck.getBillcheckentries();
        List<Billcheckentry> billcheckentries1=billcheckMapper.selectByPrimaryKey(billcheck.getFid()).getBillcheckentries();


if(billcheckentries1.size()>billcheckentries.size())
        for(int j=billcheckentries1.size();j<billcheckentries.size();j--)
        {
            billcheckentryMapper.deleteByPrimaryKey(billcheckentries1.get(j).getFid());
        }

        int i=billcheckentries.size();

        for(Billcheckentry entry:billcheckentries)
        {
            if(entry.getFid()>0||entry.getFid()==null)
            billcheckentryMapper.updateByPrimaryKey(entry);
            else
            {

                entry.setFbillid(billcheck.getFid());
                entry.setFentryid(i);
                i++;
                billcheckentryMapper.insert(entry);

            }

        }
        int check=billcheckMapper.BillCheck(billcheck.getFid());
        if(check==1) billcheck.setFstatus(2);
        return billcheckMapper.updateByPrimaryKey(billcheck)>0;
    }

    @Override
    public boolean delete(int fid) throws Exception {
        billcheckentryMapper.deleteBatch(billcheckMapper.selectByPrimaryKey(fid).getBillcheckentries());
        return billcheckMapper.deleteByPrimaryKey(fid)>0;
    }

    @Override
    public List<Billcheck> getList() {
        return billcheckMapper.selectByExample(new BillcheckExample());
    }

    @Override
    public Billcheck getDetail(String fnumber) {
        BillcheckExample example=new BillcheckExample();
        example.createCriteria().andFnumberLike("%"+fnumber+"%");

        List list=null;
        try {
          list=  billcheckMapper.selectByExample(example);
        }
        catch (Exception e)
        {

            e.printStackTrace();
        }
        if(list.size()>0)
        return (Billcheck) list.get(0);
        else return null;
    }

    @Override
    public Billcheck getDetail(int fid) {
        return billcheckMapper.selectByPrimaryKey(fid);
    }

    @Override
    public List<Billcheck> getTipList(String fnumber) {
        return null;
    }

    @Override
    public List<Billcheck> showCurrentPage(int totalSize, int preSize) {
        return null;
    }

    @Override
    public List<Billcheck> showTipPageList(String fnumber, int totalSize, int perSize) {
        return null;
    }

    @Override
    public int getTotalNum(Billcheck billcheck) {
        return 0;
    }

    @Override
    public boolean deleteBatch(Integer[] ids) {
        return billcheckMapper.deleteBatch(ids)>0;
    }

    @Override
    public List<Billcheck> getList(int pageIndex, int pageSize, Billcheck billcheck) {
        return null;
    }

    @Override
    public List<Billcheck> getList(Map map) {
        return billcheckMapper.getList(map);
    }

    @Override
    public int getTotalNum(Map map) {
        return billcheckMapper.getTotalNum(map);
    }

    @Override
    public String getAutoNumber() {
        return billcheckMapper.getAutoNumber();
    }

    @Override
    public Billcheckentry getentryDetail(Integer fid) {
        return billcheckentryMapper.selectByPrimaryKey(fid);
    }

    @Override
    public String checkRelation(Map map) {
        return billcheckMapper.checkRelation(map);
    }

    @Override
    public float getPushDownQty(Integer fentryid,Integer fid) {
        return billcheckMapper.getPushDownQty(fentryid,fid);
    }

    @Override
    public String initAutoboxno( String fonumber)
    {
        return billcheckMapper.initAutoboxno(fonumber);
    }
}
