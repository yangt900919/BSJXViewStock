package com.linkpal.dao.impl;

import com.linkpal.dao.IMaterialRGoodSeatDao;
import com.linkpal.map.MaterialrgoodseatMapper;
import com.linkpal.model.Materialrgoodseat;
import com.linkpal.model.example.MaterialrgoodseatExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component("MaterialRGoodSeatDaoImpl")
public class MaterialRGoodSeatDaoImpl implements IMaterialRGoodSeatDao {

    @Autowired
    MaterialrgoodseatMapper materialrgoodseatMapper;

    @Override
    public boolean deleteBatch(Integer[] ids) {
        return materialrgoodseatMapper.deleteBatch(ids)>0;
    }



    @Override
    public List<Materialrgoodseat> getList(int pageIndex, int pageSize, Materialrgoodseat t) {
        return materialrgoodseatMapper.getList(pageIndex,pageSize,t);
    }



    @Override
    public boolean create(Materialrgoodseat materialrgoodseat) throws Exception {
        return materialrgoodseatMapper.insert(materialrgoodseat)>0;
    }

    @Override
    public boolean update(Materialrgoodseat materialrgoodseat) throws Exception {
        return materialrgoodseatMapper.updateByPrimaryKey(materialrgoodseat)>0;
    }

    @Override
    public boolean delete(int fid) throws Exception {
        return materialrgoodseatMapper.deleteByPrimaryKey(fid)>0;
    }

    @Override
    public List<Materialrgoodseat> getList() {
        return materialrgoodseatMapper.selectByExample(new MaterialrgoodseatExample());
    }

    @Override
    public Materialrgoodseat getDetail(String fnumber) {

        return null;
    }

    @Override
    public Materialrgoodseat getDetail(int fid) {
        return materialrgoodseatMapper.selectByPrimaryKey(fid);
    }

    @Override
    public List<Materialrgoodseat> getTipList(String fnumber) {
        return null;
    }

    @Override
    public List<Materialrgoodseat> showCurrentPage(int totalSize, int preSize) {
        return null;
    }

    @Override
    public List<Materialrgoodseat> showTipPageList(String fnumber, int totalSize, int perSize) {
        return null;
    }

    @Override
    public int getTotalNum(Materialrgoodseat t) {

       return  materialrgoodseatMapper.getTotalNum(t);
    }

    @Override
    public void ajustGoodsSeat(Map map) {
        materialrgoodseatMapper.ajustGoodsSeat(map);
    }
}
