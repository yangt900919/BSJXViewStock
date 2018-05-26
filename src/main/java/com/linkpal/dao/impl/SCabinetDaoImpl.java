package com.linkpal.dao.impl;

import com.linkpal.dao.ISCabinetDao;
import com.linkpal.map.ScabinetMapper;
import com.linkpal.model.Scabinet;
import com.linkpal.model.example.ScabinetExample;
import com.linkpal.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("SCabinetDaoImpl")
public class SCabinetDaoImpl implements ISCabinetDao {

    @Autowired
    ScabinetMapper scabinetMapper;

    @Override
    public boolean deleteBatch(Integer[] ids) {
        return scabinetMapper.deleteBatch(ids)>0;
    }

    @Override
    public List<Scabinet> getList(int pageIndex, int pageSize, Scabinet t) {
        return scabinetMapper.getList(pageIndex,pageSize,t);
    }

    @Override
    public boolean create(Scabinet scabinet) throws Exception {
        return scabinetMapper.insert(scabinet)>0;
    }

    @Override
    public boolean update(Scabinet scabinet) throws Exception {
        return scabinetMapper.updateByPrimaryKey(scabinet)>0;
    }

    @Override
    public boolean delete(int fid) throws Exception {
        return scabinetMapper.deleteByPrimaryKey(fid)>0;
    }

    @Override
    public List<Scabinet> getList() {
        return scabinetMapper.selectByExample(new ScabinetExample());
    }

    @Override
    public Scabinet getDetail(String fnumber) {

        ScabinetExample example=new ScabinetExample();
        example.createCriteria().andFnumberEqualTo(fnumber);
        List<Scabinet> list=scabinetMapper.selectByExample(example);
        if(list.size()>0)return list.get(0);
        else return null;
    }

    @Override
    public Scabinet getDetail(int fid) {
        return scabinetMapper.selectByPrimaryKey(fid);
    }

    @Override
    public List<Scabinet> getTipList(String fnumber) {
        return null;
    }

    @Override
    public List<Scabinet> showCurrentPage(int totalSize, int preSize) {
        return null;
    }

    @Override
    public List<Scabinet> showTipPageList(String fnumber, int totalSize, int perSize) {
        return null;
    }

    @Override
    public int getTotalNum(Scabinet t) {

        ScabinetExample example=new ScabinetExample();
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
