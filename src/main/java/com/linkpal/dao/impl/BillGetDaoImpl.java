package com.linkpal.dao.impl;

import com.linkpal.dao.IBillGetDao;
import com.linkpal.map.BillgetMapper;
import com.linkpal.map.BillgetentryMapper;
import com.linkpal.model.Bill;
import com.linkpal.model.Billcheck;
import com.linkpal.model.Billget;
import com.linkpal.model.Billgetentry;
import com.linkpal.model.example.BillgetExample;
import com.linkpal.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component("BillGetDaoImpl")
public class BillGetDaoImpl implements IBillGetDao {

    @Autowired
    BillgetMapper billgetMapper;

    @Autowired
    BillgetentryMapper billgetentryMapper;


    @Override
    public boolean create(Billget billget) throws Exception {

        Billget bg=getDetail(billget.getFnumber());
        if(bg!=null) billget.setFnumber(getAutoNumber());
        billgetMapper.insert(billget);
        Billget b=getDetail(billget.getFnumber());
        int i=1;
        for(Billgetentry entry:billget.getBillgetentries())
        {
            entry.setFbillid(b.getFid());
            entry.setFentryid(i);
            i++;
            try{
                billgetentryMapper.insert(entry);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

        }
        return true;
    }

    @Override
    public boolean update(Billget billget) throws Exception {

        List<Billgetentry> billgetentries=billget.getBillgetentries();
        List<Billgetentry> billgetentries1=billgetMapper.selectByPrimaryKey(billget.getFid()).getBillgetentries();

        if(billgetentries1.size()>billgetentries.size())
        for(int j=billgetentries1.size();j<billgetentries.size();j--)
        {
            billgetentryMapper.deleteByPrimaryKey(billgetentries1.get(j).getFid());
        }

        int i=billgetentries.size();

        for(Billgetentry entrys:billgetentries)
        {
            if(StringUtil.Change(entrys.getFid())>0)
            billgetentryMapper.updateByPrimaryKey(entrys);
            else
            {
                entrys.setFbillid(billget.getFid());
                entrys.setFentryid(i);
                i++;
                billgetentryMapper.insert(entrys);
            }
        }

        return billgetMapper.updateByPrimaryKey(billget)>0;
    }

    @Override
    public boolean delete(int fid) throws Exception {
        billgetentryMapper.deleteBatch(billgetMapper.selectByPrimaryKey(fid).getBillgetentries());
        return billgetMapper.deleteByPrimaryKey(fid)>0;
    }

    @Override
    public List<Billget> getList() {
        return billgetMapper.selectByExample(new BillgetExample());
    }

    @Override
    public Billget getDetail(String fnumber) {
        BillgetExample example=new BillgetExample();
        example.createCriteria().andFnumberLike("%"+fnumber+"%");

        List list=null;
        try {
          list=  billgetMapper.selectByExample(example);
        }
        catch (Exception e)
        {

            e.printStackTrace();
        }
        if(list.size()>0)
        return (Billget) list.get(0);
        else return null;
    }

    @Override
    public Billget getDetail(int fid) {
        return billgetMapper.selectByPrimaryKey(fid);
    }

    @Override
    public List<Billget> getTipList(String fnumber) {
        return null;
    }

    @Override
    public List<Billget> showCurrentPage(int totalSize, int preSize) {
        return null;
    }

    @Override
    public List<Billget> showTipPageList(String fnumber, int totalSize, int perSize) {
        return null;
    }

    @Override
    public int getTotalNum(Billget billget) {
        return 0;
    }

    @Override
    public boolean deleteBatch(Integer[] ids) {
        return billgetMapper.deleteBatch(ids)>0;
    }

    @Override
    public List<Billget> getList(int pageIndex, int pageSize, Billget billget) {
        return null;
    }

    @Override
    public List<Billget> getList(Map map) {
        return billgetMapper.getList(map);
    }

    @Override
    public int getTotalNum(Map map) {
        return billgetMapper.getTotalNum(map);
    }

    @Override
    public String getAutoNumber() {
        return billgetMapper.getAutoNumber();
    }

    @Override
    public void updateDepart(Map map) {
        billgetMapper.updateDepart(map);
    }

    @Override
    public float getInventoryQty(Integer fmaid) {
        return billgetMapper.getInventoryQty(fmaid);
    }
}
