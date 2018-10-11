package com.linkpal.dao.impl;

import com.linkpal.dao.IDataSCabinetDao;
import com.linkpal.dao.ISCabinetDao;
import com.linkpal.map.DatascabinetMapper;
import com.linkpal.map.DatascabinetMapper;
import com.linkpal.model.Datascabinet;
import com.linkpal.model.example.DatascabinetExample;
import com.linkpal.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("DataSCabinetDaoImpl")
public class DataSCabinetDaoImpl implements IDataSCabinetDao {

    @Autowired
    DatascabinetMapper scabinetMapper;

    @Override
    public boolean deleteBatch(Integer[] ids) {
        return scabinetMapper.deleteBatch(ids)>0;
    }

    @Override
    public List<Datascabinet> getList(int pageIndex, int pageSize, Datascabinet t) {
        return scabinetMapper.getList(pageIndex,pageSize,t);
    }

    @Override
    public boolean create(Datascabinet scabinet) throws Exception {
        return scabinetMapper.insert(scabinet)>0;
    }

    @Override
    public boolean update(Datascabinet scabinet) throws Exception {
        return scabinetMapper.updateByPrimaryKey(scabinet)>0;
    }

    @Override
    public boolean delete(int fid) throws Exception {
        return scabinetMapper.deleteByPrimaryKey(fid)>0;
    }

    @Override
    public List<Datascabinet> getList() {
        return scabinetMapper.selectByExample(new DatascabinetExample());
    }

    @Override
    public Datascabinet getDetail(String fnumber) {

        DatascabinetExample example=new DatascabinetExample();
        example.createCriteria().andFnumberEqualTo(fnumber);
        List<Datascabinet> list=scabinetMapper.selectByExample(example);
        if(list.size()>0)return list.get(0);
        else return null;
    }

    @Override
    public Datascabinet getDetail(int fid) {
        return scabinetMapper.selectByPrimaryKey(fid);
    }

    @Override
    public List<Datascabinet> getTipList(String fnumber) {
        return null;
    }

    @Override
    public List<Datascabinet> showCurrentPage(int totalSize, int preSize) {
        return null;
    }

    @Override
    public List<Datascabinet> showTipPageList(String fnumber, int totalSize, int perSize) {
        return null;
    }

    @Override
    public int getTotalNum(Datascabinet t) {

        DatascabinetExample example=new DatascabinetExample();
        if(t.getFnumber()!=null&&!(t.getFnumber().equals("")))
            example.createCriteria().andFnumberLike("%"+t.getFnumber()+"%");
        if(t.getFname()!=null&&!(t.getFname().equals("")))
            example.createCriteria().andFnameLike("%"+t.getFname()+"%");
        if(StringUtil.Change(t.getFcabinetid())>0)
            example.createCriteria().andFcabinetidEqualTo(t.getFcabinetid());
        if(StringUtil.Change(t.getFcabinettypeid())>0)
            example.createCriteria().andFcabinettypeidEqualTo(t.getFcabinettypeid());
        if(StringUtil.Change(t.getFstockid())>0)
            example.createCriteria().andFstockidEqualTo(t.getFstockid());
        return (int) scabinetMapper.countByExample(example);
    }
}
