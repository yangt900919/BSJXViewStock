package com.linkpal.dao.impl;

import com.linkpal.dao.ICabinetDao;
import com.linkpal.dao.IDataCabinetDao;
import com.linkpal.map.CabinetMapper;
import com.linkpal.map.DatacabinetMapper;
import com.linkpal.map.DatascabinetMapper;
import com.linkpal.map.ScabinetMapper;
import com.linkpal.model.Cabinet;
import com.linkpal.model.Datacabinet;
import com.linkpal.model.Datascabinet;
import com.linkpal.model.Scabinet;
import com.linkpal.model.example.CabinetExample;
import com.linkpal.model.example.DatacabinetExample;
import com.linkpal.model.example.DatascabinetExample;
import com.linkpal.model.example.ScabinetExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("DataCabinetDaoImpl")
public class DataCabinetDaoImpl implements IDataCabinetDao {

    @Autowired
    DatacabinetMapper cabinetMapper;

    @Autowired
    DatascabinetMapper scabinetMapper;

    @Override
    public boolean create(Datacabinet cabinet) {
        return cabinetMapper.insert(cabinet) > 0;
    }

    @Override
    public boolean update(Datacabinet cabinet) {
        return cabinetMapper.updateByPrimaryKey(cabinet) > 0;
    }

    @Override
    public boolean delete(int fid) {
        return cabinetMapper.deleteByPrimaryKey(fid) > 0;
    }

    @Override
    public List<Datacabinet> getList() {
        return cabinetMapper.selectByExample(new DatacabinetExample());
    }

    @Override
    public Datacabinet getDetail(String fnumber) {

        DatacabinetExample example=new DatacabinetExample();
        example.createCriteria().andFnumberEqualTo(fnumber);
        List<Datacabinet> list=cabinetMapper.selectByExample(example);
        if(list.size()>0) return list.get(0);
        else return null;
    }

    @Override
    public Datacabinet getDetail(int fid) {
        return cabinetMapper.selectByPrimaryKey(fid);
    }

    @Override
    public List<Datacabinet> getTipList(String fnumber) {
        DatacabinetExample example = new DatacabinetExample();
        example.createCriteria().andFnumberLike("%" + fnumber + "%");
        return cabinetMapper.selectByExample(example);
    }

    @Override
    public List<Datacabinet> showCurrentPage(int totalSize, int preSize) {
        return null;
    }

    @Override
    public List<Datacabinet> showTipPageList(String fnumber, int totalSize, int preSize) {
        return null;
    }

    @Override
    public boolean deleteBatch(Integer[] ids) {
        return cabinetMapper.deleteBatch(ids)>0;
    }

    @Override
    public List<Datacabinet> getList(int pageIndex, int pageSize, Datacabinet t) {
        return cabinetMapper.getList(pageIndex,pageSize,t);
    }

    @Override
    public int getTotalNum(Datacabinet t) {

        DatacabinetExample example=new DatacabinetExample();
        if(t.getFnumber()!=null&&!(t.getFnumber().equals("")))
        example.createCriteria().andFnumberLike("%"+t.getFnumber()+"%");
        if(t.getFname()!=null&&!(t.getFname().equals("")))
            example.createCriteria().andFnameLike("%"+t.getFname()+"%");
        if(t.getFstockid()!=null&&t.getFstockid()>0)
            example.createCriteria().andFstockidEqualTo(t.getFstockid());
        return (int) cabinetMapper.countByExample(example);
    }

    @Override
    public List<Datascabinet> getDatascabinetList(Integer fid) {
        DatascabinetExample example=new DatascabinetExample();
        example.createCriteria().andFcabinetidEqualTo(fid);
        return scabinetMapper.selectByExample(example);
    }

/*    @Override
    public List<Cabinet> getStockCabinet(int stockid) {
        CabinetExample example = new CabinetExample();
        example.createCriteria().andFstockidEqualTo(stockid);
        return cabinetMapper.selectByExample(example);
    }*/
}
