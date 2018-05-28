package com.linkpal.dao.impl;

import com.linkpal.dao.IBillReturnDao;
import com.linkpal.map.BillreturnMapper;
import com.linkpal.map.BillreturnentryMapper;
import com.linkpal.model.*;
import com.linkpal.model.BillreturnExample;
import com.linkpal.model.BillreturnExample;
import com.linkpal.model.Billreturnentry;
import com.linkpal.model.Billreturn;
import com.linkpal.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component("BillReturnDaoImpl")
public class BillReturnDaoImpl implements IBillReturnDao {
    
    @Autowired
    BillreturnMapper billreturnMapper;
    
    @Autowired
    BillreturnentryMapper billreturnentryMapper;
    
    @Override
    public List<Billreturn> getList(Map map) {
        return billreturnMapper.getList(map);
    }

    @Override
    public int getTotalNum(Map map) {
        return billreturnMapper.getTotalNum(map);
    }

    @Override
    public String getAutoNumber() {
        return billreturnMapper.getAutoNumber();
    }

    @Override
    public boolean create(Billreturn billreturn) throws Exception {
        try{ billreturnMapper.insert(billreturn);}
        catch (Exception e){e.printStackTrace();}
        Billreturn b=getDetail(billreturn.getFnumber());
        int i=1;
        for(Billreturnentry entry:billreturn.getBillreturnentries())
        {
            entry.setFbillid(b.getFid());
            entry.setFentryid(i);
            //entry.setFstate(0);
            i++;
            try{
                billreturnentryMapper.insert(entry);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

        }
        return true;
    }

    @Override
    public boolean update(Billreturn billreturn) throws Exception {
        List<Billreturnentry> billreturnentries=billreturn.getBillreturnentries();

        List<Billreturnentry> billreturnentries1=billreturnMapper.selectByPrimaryKey(billreturn.getFid()).getBillreturnentries();

        if(billreturnentries1.size()>billreturnentries.size())
        for(int j=billreturnentries1.size();j<billreturnentries.size();j--)
        {
            billreturnentryMapper.deleteByPrimaryKey(billreturnentries1.get(j).getFid());
        }

        int i=billreturnentries.size()+1;

        for(Billreturnentry entry:billreturnentries)
        {
            if(entry.getFid()>0||entry.getFid()==null)
                billreturnentryMapper.updateByPrimaryKey(entry);
            else
            {
                entry.setFbillid(billreturn.getFid());
                entry.setFentryid(i);
                i++;
                billreturnentryMapper.insert(entry);
            }
        }

        return billreturnMapper.updateByPrimaryKey(billreturn)>0;
    }

    @Override
    public boolean delete(int fid) throws Exception {
        return billreturnMapper.deleteByPrimaryKey(fid)>0;
    }

    @Override
    public List<Billreturn> getList() {
        return billreturnMapper.selectByExample(new BillreturnExample());
    }

    @Override
    public Billreturn getDetail(String fnumber) {
        BillreturnExample example=new BillreturnExample();
        example.createCriteria().andFnumberLike("%"+fnumber+"%");

        List list=null;
        try {
            list=  billreturnMapper.selectByExample(example);
        }
        catch (Exception e)
        {

            e.printStackTrace();
        }
        if(list.size()>0)
            return (Billreturn) list.get(0);
        else return null;
    }

    @Override
    public Billreturn getDetail(int fid) {
        return billreturnMapper.selectByPrimaryKey(fid);
    }

    @Override
    public List<Billreturn> getTipList(String fnumber) {
        return null;
    }

    @Override
    public List<Billreturn> showCurrentPage(int totalSize, int preSize) {
        return null;
    }

    @Override
    public List<Billreturn> showTipPageList(String fnumber, int totalSize, int perSize) {
        return null;
    }

    @Override
    public int getTotalNum(Billreturn billreturn) {
        return 0;
    }

    @Override
    public boolean deleteBatch(Integer[] ids) {
        return billreturnMapper.deleteBatch(ids)>0;
    }

    @Override
    public List<Billreturn> getList(int pageIndex, int pageSize, Billreturn billreturn) {
        return null;
    }
}
