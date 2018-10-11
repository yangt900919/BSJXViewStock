package com.linkpal.dao.impl;

import com.linkpal.dao.IInvDao;
import com.linkpal.map.InvMapper;
import com.linkpal.model.Goodseat;
import com.linkpal.model.Inv;
import com.linkpal.model.InvExample;
import com.linkpal.model.example.GoodseatExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("InvDaoImpl")
public class InvDaoImpl implements IInvDao {

    @Autowired
    InvMapper invMapper;

    @Override
    public boolean create(Inv inv) throws Exception {
        return invMapper.insert(inv)>0;
    }

    @Override
    public boolean update(Inv inv) throws Exception {
        return invMapper.updateByPrimaryKey(inv)>0;
    }

    @Override
    public boolean delete(int fid) throws Exception {
        return invMapper.deleteByPrimaryKey(fid)>0;
    }

    @Override
    public List<Inv> getList() {
        return null;
    }

    @Override
    public Inv getDetail(String fnumber) {
        InvExample example = new InvExample();
        example.createCriteria().andFnameEqualTo(fnumber);
        List<Inv> list= invMapper.selectByExample(example);
        return list.size()>0?list.get(0):null;
    }

    @Override
    public Inv getDetail(int fid) {
        return invMapper.selectByPrimaryKey(fid);
    }

    @Override
    public List<Inv> getTipList(String fnumber) {
        return null;
    }

    @Override
    public List<Inv> showCurrentPage(int totalSize, int preSize) {
        return null;
    }

    @Override
    public List<Inv> showTipPageList(String fnumber, int totalSize, int perSize) {
        return null;
    }

    @Override
    public int getTotalNum(Inv inv) {
        return invMapper.getTotalNum(inv);
    }

    @Override
    public boolean deleteBatch(Integer[] ids) {
        return false;
    }

    @Override
    public List<Inv> getList(int pageIndex, int pageSize, Inv inv) {
        return invMapper.getList(pageIndex,pageSize,inv);
    }

    @Override
    public int close(int ID) {
        return invMapper.close(ID);
    }

    @Override
    public int closeBatch(Integer[] ids) {
        return invMapper.closeBatch(ids);
    }
}
