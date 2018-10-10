package com.linkpal.service.impl;

import com.linkpal.Excepetion.ImportException;
import com.linkpal.dao.IInventoryDao;
import com.linkpal.model.*;
import com.linkpal.service.IInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InventoryServiceImpl implements IInventoryService {

    @Qualifier("inventoryDaoImpl")
    @Autowired
    IInventoryDao inventoryDao;

    @Override
    public List<Inventory> getAllList() {
        return null;
    }

    @Override
    public Map<String, Object> getPageList(HttpServletRequest request, Map map) {

        Map m=new HashMap();
        List<Inventory> list=null;
        String pageNow = request.getParameter("pageNow");
        String condition=request.getParameter("condition");
        HttpSession session=request.getSession();
        if(condition==null || "".equals(condition))
        {
            session.setAttribute("Inventory", map);
        }
        else
        {
            map=(Map) session.getAttribute("Inventory");
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
        return inventoryDao.updateQty(map);
    }

    @Override
    public List<Inventory> getExportList(Map map) {
        return inventoryDao.getExportList(map);
    }

    @Override
    public Map<String, Object> getMaPageList(HttpServletRequest request, Map map) {

        Map m=new HashMap();
        List<Inventory> list=null;
        String pageNow = request.getParameter("pageNow");
        String condition=request.getParameter("condition");
        HttpSession session=request.getSession();
        if(condition==null || "".equals(condition))
        {
            session.setAttribute("Inventory", map);
        }
        else
        {
            map=(Map) session.getAttribute("Inventory");
        }
        Page page = null;
        int totalCount=inventoryDao.getMaTotalNum(map);
        if (pageNow != null) {
            page = new Page(totalCount, Integer.parseInt(pageNow));
        } else {
            page = new Page(totalCount, 1);
        }
        map.put("pageIndex", page.getStartPos());
        map.put("pageSize", page.getPageSize());
        list=inventoryDao.getMaList(map);
        m.put("list", list);
        m.put("page", page);
        m.put("model", map);
        return m;
    }


    @Override
    public int getMaTotalNum(Map map) {
        return 0;
    }

    @Override
    public List<Inventory> getMaExportList(Map map) {
        return inventoryDao.getExportList(map);
    }

    @Override
    public Map<String, Object> getMgPageList(HttpServletRequest request, Map map) {

        Map m=new HashMap();
        List<Inventory> list=null;
        String pageNow = request.getParameter("pageNow");
        String condition=request.getParameter("condition");
        HttpSession session=request.getSession();
        if(condition==null || "".equals(condition))
        {
            session.setAttribute("Inventory", map);
        }
        else
        {
            map=(Map) session.getAttribute("Inventory");
        }
        Page page = null;
        int totalCount=inventoryDao.getMgTotalNum(map);
        if (pageNow != null) {
            page = new Page(totalCount, Integer.parseInt(pageNow));
        } else {
            page = new Page(totalCount, 1);
        }
        map.put("pageIndex", page.getStartPos());
        map.put("pageSize", page.getPageSize());
        list=inventoryDao.getMgList(map);
        m.put("list", list);
        m.put("page", page);
        m.put("model", map);
        return m;
    }

    @Override
    public int getMgTotalNum(Map map) {
        return 0;
    }

    @Override
    public List<Inventory> getMgExportList(Map map) {
        return inventoryDao.getMgExportList(map);
    }

    @Override
    public List<Inventory> getInventoryDetail(Map map) {
        return inventoryDao.getInventoryDetail(map);
    }

    @Override
    public Map<String, Object> getZJPageList(HttpServletRequest request, Map map) {
        Map m=new HashMap();
        List<Map<String,Object>> list=null;
        String pageNow = request.getParameter("pageNow");
        String condition=request.getParameter("condition");
        HttpSession session=request.getSession();
        if(condition==null || "".equals(condition))
        {
            session.setAttribute("Inventory", map);
        }
        else
        {
            map=(Map) session.getAttribute("Inventory");
        }
        Page page = null;
        int totalCount=inventoryDao.getZJTotalNum(map);
        if (pageNow != null) {
            page = new Page(totalCount, Integer.parseInt(pageNow));
        } else {
            page = new Page(totalCount, 1);
        }
        map.put("pageIndex", page.getStartPos());
        map.put("pageSize", page.getPageSize());
        list=inventoryDao.getZJList(map);
        m.put("list", list);
        m.put("page", page);
        m.put("model", map);
        return m;
    }

    @Override
    public int getZJTotalNum(Map map) {
        return 0;
    }

    @Override
    public List<Map<String, Object>> getZJExportList(Map map) {
        return inventoryDao.getZJExportList(map);
    }

    @Override
    public Map<String, Object> getZJMaPageList(HttpServletRequest request, Map map) {
        Map m=new HashMap();
        List<Map<String,Object>> list=null;
        String pageNow = request.getParameter("pageNow");
        String condition=request.getParameter("condition");
        HttpSession session=request.getSession();
        if(condition==null || "".equals(condition))
        {
            session.setAttribute("Inventory", map);
        }
        else
        {
            map=(Map) session.getAttribute("Inventory");
        }
        Page page = null;
        int totalCount=inventoryDao.getZJMaTotalNum(map);
        if (pageNow != null) {
            page = new Page(totalCount, Integer.parseInt(pageNow));
        } else {
            page = new Page(totalCount, 1);
        }
        map.put("pageIndex", page.getStartPos());
        map.put("pageSize", page.getPageSize());
        list=inventoryDao.getZJMaList(map);
        m.put("list", list);
        m.put("page", page);
        m.put("model", map);
        return m;
    }

    @Override
    public int getZJMaTotalNum(Map map) {
        return 0;
    }

    @Override
    public List<Map<String, Object>> getZJMaExportList(Map map) {
        return inventoryDao.getZJMaExportList(map);
    }

    @Override
    public Map<String, Object> getHGPageList(HttpServletRequest request, Map map) {
        Map m=new HashMap();
        List<Map<String,Object>> list=null;
        String pageNow = request.getParameter("pageNow");
        String condition=request.getParameter("condition");
        HttpSession session=request.getSession();
        if(condition==null || "".equals(condition))
        {
            session.setAttribute("Inventory", map);
        }
        else
        {
            map=(Map) session.getAttribute("Inventory");
        }
        Page page = null;
        int totalCount=inventoryDao.getHGTotalNum(map);
        if (pageNow != null) {
            page = new Page(totalCount, Integer.parseInt(pageNow));
        } else {
            page = new Page(totalCount, 1);
        }
        map.put("pageIndex", page.getStartPos());
        map.put("pageSize", page.getPageSize());
        list=inventoryDao.getHGList(map);
        m.put("list", list);
        m.put("page", page);
        m.put("model", map);
        return m;
    }

    @Override
    public int getHGTotalNum(Map map) {
        return 0;
    }

    @Override
    public List<Map<String, Object>> getHGExportList(Map map) {
        return inventoryDao.getHGExportList(map);
    }

    @Override
    public Map<String, Object> getHGMaPageList(HttpServletRequest request, Map map) {
        Map m=new HashMap();
        List<Map<String,Object>> list=null;
        String pageNow = request.getParameter("pageNow");
        String condition=request.getParameter("condition");
        HttpSession session=request.getSession();
        if(condition==null || "".equals(condition))
        {
            session.setAttribute("Inventory", map);
        }
        else
        {
            map=(Map) session.getAttribute("Inventory");
        }
        Page page = null;
        int totalCount=inventoryDao.getHGMaTotalNum(map);
        if (pageNow != null) {
            page = new Page(totalCount, Integer.parseInt(pageNow));
        } else {
            page = new Page(totalCount, 1);
        }
        map.put("pageIndex", page.getStartPos());
        map.put("pageSize", page.getPageSize());
        list=inventoryDao.getHGMaList(map);
        m.put("list", list);
        m.put("page", page);
        m.put("model", map);
        return m;
    }

    @Override
    public int getHGMaTotalNum(Map map) {
        return 0;
    }

    @Override
    public List<Map<String, Object>> getHGMaExportList(Map map) {
        return inventoryDao.getHGExportList(map);
    }

  /*  @Override
    public boolean create(Inventory inventory) throws Exception {
        return inventoryDao.create(inventory);
    }

    @Override
    public boolean update(Inventory inventory) throws Exception {
        return inventoryDao.update(inventory);
    }

    @Override
    public boolean delete(int fid) throws Exception {
        return inventoryDao.delete(fid);
    }

    @Override
    public List<Inventory> getList() {
        return inventoryDao.getList();
    }

    @Override
    public Inventory getDetail(String fnumber) {
        return null;
    }

    @Override
    public Inventory getDetail(int fid) {
        return null;
    }

    @Override
    public List<Inventory> getDetailByGoodseat(String fnumber) {
        return inventoryDao.getDetailByGoodseat(fnumber);
    }

    @Override
    public List<Inventory> getDetailByGoodseat(int fid) {
        return inventoryDao.getDetailByGoodseat(fid);
    }

    @Override
    public List<Inventory> getTipList(String fnumber) {
        return inventoryDao.getTipList(fnumber);
    }

    @Override
    public List<Inventory> showCurrentPage(Page page) {
        int totalSize = page.getPageNow() * page.getPageSize();
        return inventoryDao.showCurrentPage(totalSize, totalSize - page.getPageSize());
    }

    @Override
    public List<Inventory> showTipPageList(String fnumber, Page page) {
        return null;
    }

    @Override
    public void importInfo(InputStream in, MultipartFile file, Inventory inventory, int insertType) throws ImportException {

    }

    @Override
    public Map<String, List<Inventory>> showStockGoodseat(List<Goodseat> goodseats) {
        int length = goodseats.size();
        Map<String, List<Inventory>> displays = new HashMap();
        List<Inventory> display;
        for (int i = 0; i < length; i++) {
            display = inventoryDao.getDetailByGoodseat(goodseats.get(i).getFid());
            displays.put(goodseats.get(i).getFnumber(), display);
        }
        return displays;
    }*/
}
