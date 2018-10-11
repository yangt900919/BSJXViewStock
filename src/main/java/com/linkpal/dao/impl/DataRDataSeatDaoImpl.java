package com.linkpal.dao.impl;

import com.linkpal.dao.IDataRDataSeatDao;
import com.linkpal.map.DatardataseatMapper;
import com.linkpal.map.DatardataseatMapper;
import com.linkpal.model.Datardataseat;
import com.linkpal.model.example.DatardataseatExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component("DataRDataSeatDaoImpl")
public class DataRDataSeatDaoImpl implements IDataRDataSeatDao {

    @Autowired
    DatardataseatMapper materialrgoodseatMapper;

    @Override
    public boolean deleteBatch(Integer[] ids) {
        return materialrgoodseatMapper.deleteBatch(ids)>0;
    }



    @Override
    public List<Datardataseat> getList(int pageIndex, int pageSize, Datardataseat t) {
        return materialrgoodseatMapper.getList(pageIndex,pageSize,t);
    }



    @Override
    public boolean create(Datardataseat materialrgoodseat) throws Exception {
        return materialrgoodseatMapper.insert(materialrgoodseat)>0;
    }

    @Override
    public boolean update(Datardataseat materialrgoodseat) throws Exception {
        return materialrgoodseatMapper.updateByPrimaryKey(materialrgoodseat)>0;
    }

    @Override
    public boolean delete(int fid) throws Exception {
        return materialrgoodseatMapper.deleteByPrimaryKey(fid)>0;
    }

    @Override
    public List<Datardataseat> getList() {
        return materialrgoodseatMapper.selectByExample(new DatardataseatExample());
    }

    @Override
    public Datardataseat getDetail(String fnumber) {

        return null;
    }

    @Override
    public Datardataseat getDetail(int fid) {
        return materialrgoodseatMapper.selectByPrimaryKey(fid);
    }

    @Override
    public List<Datardataseat> getTipList(String fnumber) {
        return null;
    }

    @Override
    public List<Datardataseat> showCurrentPage(int totalSize, int preSize) {
        return null;
    }

    @Override
    public List<Datardataseat> showTipPageList(String fnumber, int totalSize, int perSize) {
        return null;
    }

    @Override
    public int getTotalNum(Datardataseat t) {

       return  materialrgoodseatMapper.getTotalNum(t);
    }

    /*@Override
    public void ajustGoodsSeat(Map map) {
        materialrgoodseatMapper.ajustGoodsSeat(map);
    }*/
}
