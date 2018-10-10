package com.linkpal.service.impl;


import com.linkpal.dao.IDataInventoryDao;
import com.linkpal.model.Datainventory;
import com.linkpal.model.Page;
import com.linkpal.service.IDataInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DataInventoryServiceImpl implements IDataInventoryService {


    @Qualifier("DataInventoryDaoImpl")
    @Autowired
    private IDataInventoryDao inventoryDao;

    @Qualifier

    @Override
    public List<Datainventory> getAllList() {
        return null;
    }

    @Override
    public Map<String, Object> getPageList(HttpServletRequest request, Map map) {

        Map m=new HashMap();
        List<Datainventory> list=null;
        String pageNow = request.getParameter("pageNow");
        String condition=request.getParameter("condition");
        HttpSession session=request.getSession();
        if(condition==null || "".equals(condition))
        {
            session.setAttribute("Datainventory", map);
        }
        else
        {
            map=(Map) session.getAttribute("Datainventory");
        }
        Page page = null;
        int totalCount=inventoryDao.getTotalNum(map);
        if (pageNow != null) {
            page = new Page(totalCount, Integer.parseInt(pageNow));
        } else {
            page = new Page(totalCount, 1);
        }
        map.put("pageIndex", page.getStartPos());
        map.put("pageSize", page.getPageSize());
        list=inventoryDao.getList(map);
        m.put("list", list);
        m.put("page", page);
        m.put("model", map);
        return m;
    }

    @Override
    public int getTotalNum(Map map) {
        return 0;
    }

    @Override
    public int updateQty(Map map) {
        return 0;
    }

    @Override
    public List<Datainventory> getExportList(Map map) {
        return inventoryDao.getExportList(map);
    }

  /*  @Override
    public boolean create(Datainventory inventory) throws Exception {
        return inventoryDao.create(inventory);
    }

    @Override
    public boolean update(Datainventory inventory) throws Exception {
        return inventoryDao.update(inventory);
    }

    @Override
    public boolean delete(int fid) throws Exception {
        return inventoryDao.delete(fid);
    }

    @Override
    public List<Datainventory> getList() {
        return inventoryDao.getList();
    }

    @Override
    public Datainventory getDetail(String fnumber) {
        return null;
    }

    @Override
    public Datainventory getDetail(int fid) {
        return null;
    }

    @Override
    public List<Datainventory> getDetailByGoodseat(String fnumber) {
        return inventoryDao.getDetailByGoodseat(fnumber);
    }

    @Override
    public List<Datainventory> getDetailByGoodseat(int fid) {
        return inventoryDao.getDetailByGoodseat(fid);
    }

    @Override
    public List<Datainventory> getTipList(String fnumber) {
        return inventoryDao.getTipList(fnumber);
    }

    @Override
    public List<Datainventory> showCurrentPage(Page page) {
        int totalSize = page.getPageNow() * page.getPageSize();
        return inventoryDao.showCurrentPage(totalSize, totalSize - page.getPageSize());
    }

    @Override
    public List<Datainventory> showTipPageList(String fnumber, Page page) {
        return null;
    }

    @Override
    public void importInfo(InputStream in, MultipartFile file, Datainventory inventory, int insertType) throws ImportException {

    }

    @Override
    public Map<String, List<Datainventory>> showStockGoodseat(List<Goodseat> goodseats) {
        int length = goodseats.size();
        Map<String, List<Datainventory>> displays = new HashMap();
        List<Datainventory> display;
        for (int i = 0; i < length; i++) {
            display = inventoryDao.getDetailByGoodseat(goodseats.get(i).getFid());
            displays.put(goodseats.get(i).getFnumber(), display);
        }
        return displays;
    }*/
}
