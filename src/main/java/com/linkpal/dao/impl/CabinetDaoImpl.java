package com.linkpal.dao.impl;

import com.linkpal.dao.ICabinetDao;
import com.linkpal.map.CabinetMapper;
import com.linkpal.model.Cabinet;
import com.linkpal.model.example.CabinetExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CabinetDaoImpl implements ICabinetDao {

    @Autowired
    CabinetMapper cabinetMapper;

    @Override
    public boolean create(Cabinet cabinet) {
        return cabinetMapper.insert(cabinet) > 0;
    }

    @Override
    public boolean update(Cabinet cabinet) {
        return cabinetMapper.updateByPrimaryKey(cabinet) > 0;
    }

    @Override
    public boolean delete(int fid) {
        return cabinetMapper.deleteByPrimaryKey(fid) > 0;
    }

    @Override
    public List<Cabinet> getList() {
        return cabinetMapper.selectByExample(new CabinetExample());
    }

    @Override
    public Cabinet getDetail(String fnumber) {

        CabinetExample example=new CabinetExample();
        example.createCriteria().andFnumberEqualTo(fnumber);
        List<Cabinet> list=cabinetMapper.selectByExample(example);
        if(list.size()>0) return list.get(0);
        else return null;
    }

    @Override
    public Cabinet getDetail(int fid) {
        return cabinetMapper.selectByPrimaryKey(fid);
    }

    @Override
    public List<Cabinet> getTipList(String fnumber) {
        CabinetExample example = new CabinetExample();
        example.createCriteria().andFnumberLike("%" + fnumber + "%");
        return cabinetMapper.selectByExample(example);
    }

    @Override
    public List<Cabinet> showCurrentPage(int totalSize, int preSize) {
        return null;
    }

    @Override
    public List<Cabinet> showTipPageList(String fnumber, int totalSize, int preSize) {
        return null;
    }

    @Override
    public boolean deleteBatch(Integer[] ids) {
        return cabinetMapper.deleteBatch(ids)>0;
    }

    @Override
    public List<Cabinet> getList(int pageIndex, int pageSize, Cabinet t) {
        return cabinetMapper.getList(pageIndex,pageSize,t);
    }

    @Override
    public int getTotalNum(Cabinet t) {

        CabinetExample example=new CabinetExample();
        if(t.getFnumber()!=null&&!(t.getFnumber().equals("")))
        example.createCriteria().andFnumberLike("%"+t.getFnumber()+"%");
        if(t.getFname()!=null&&!(t.getFname().equals("")))
            example.createCriteria().andFnameLike("%"+t.getFname()+"%");
        if(t.getFstockid()!=null&&t.getFstockid()>0)
            example.createCriteria().andFstockidEqualTo(t.getFstockid());
        return (int) cabinetMapper.countByExample(example);
    }

/*    @Override
    public List<Cabinet> getStockCabinet(int stockid) {
        CabinetExample example = new CabinetExample();
        example.createCriteria().andFstockidEqualTo(stockid);
        return cabinetMapper.selectByExample(example);
    }*/
}
