package com.linkpal.service.impl;

import com.linkpal.Excepetion.ImportException;
import com.linkpal.dao.IBillOrderDao;
import com.linkpal.model.Billorder;
import com.linkpal.model.Billorderentry;
import com.linkpal.model.Page;
import com.linkpal.service.IBillOrderService;
import com.linkpal.util.ExcelUtil;
import com.linkpal.util.GlobalVarContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("BillOrderServiceImpl")
public class BillOrderServiceImpl implements IBillOrderService {

    @Qualifier("BillOrderDaoImpl")
    @Autowired
    private IBillOrderDao IBillOrderDao;

    @Override
    public boolean create(Billorder billget) throws Exception {
        return IBillOrderDao.create(billget);
    }

    @Override
    public boolean update(Billorder billget) throws Exception {
        return IBillOrderDao.update(billget);
    }

    @Override
    public boolean delete(int fid) throws Exception {
        return IBillOrderDao.delete(fid);
    }

    @Override
    public List<Billorder> getList() {
        return IBillOrderDao.getList();
    }

    @Override
    public Billorder getDetail(String fnumber) {
        return IBillOrderDao.getDetail(fnumber);
    }

    @Override
    public Billorder getDetail(int fid) {
        return IBillOrderDao.getDetail(fid);
    }

    @Override
    public List<Billorder> getTipList(String fnumber) {
        return IBillOrderDao.getTipList(fnumber);
    }

    @Override
    public List<Billorder> showCurrentPage(Page page) {
        return null;
    }

    @Override
    public List<Billorder> showTipPageList(String fnumber, Page page) {
        return null;
    }

    @Override
    public void importInfo(InputStream in, MultipartFile file, Billorder billget, int insertType) throws ImportException {

    }

    @Override
    public Map<String, Object> getPageList(HttpServletRequest request, Map map) {
        Map m=new HashMap();
        List<Billorder> list=new ArrayList<>();
        if(request!=null) {
            String pageNow = request.getParameter("pageNow");
            String condition = request.getParameter("condition");
            HttpSession session = request.getSession();
            if (condition == null || "".equals(condition)) {
                session.setAttribute("Billorder", map);
            } else {
                map = (Map) session.getAttribute("Billorder");
            }
            Page page = null;
            int totalCount = IBillOrderDao.getTotalNum(map);
            if (pageNow != null) {
                page = new Page(totalCount, Integer.parseInt(pageNow));
            } else {
                page = new Page(totalCount, 1);
            }
            map.put("pageIndex", page.getStartPos());
            map.put("pageSize", page.getPageSize());
            list = IBillOrderDao.getList(map);
            m.put("list", list);
            m.put("page", page);
            m.put("model", map);
        }
        return m;
    }

    @Override
    public boolean deleteBatch(Integer[] ids) {
        return IBillOrderDao.deleteBatch(ids);
    }

    @Override
    public Billorderentry getentryDetail(Integer fid) {
        return IBillOrderDao.getentryDetail(fid);
    }

    @Override
    public String getAutoNumber() {
        return IBillOrderDao.getAutoNumber();
    }

    @Override
    public void deleteEntry(Integer fid) {
        IBillOrderDao.deleteEntry(fid);
    }

    @Override
    public String checkRelation(Map map) {
        return IBillOrderDao.checkRelation(map);
    }

    @Override
    public float getPushDownQty(Integer fentryid,Integer fid) {
        return IBillOrderDao.getPushDownQty(fentryid,fid);
    }

    @Override
    public List<Map<String, Object>> saveBillOrder(Map map) {
        return IBillOrderDao.saveBillOrder(map);
    }

    @Override
    public void importInfo(InputStream in, MultipartFile file) throws ImportException {

        List<List<Object>> listob=null;

        try {
            listob= ExcelUtil.getListByExcel(in,file.getOriginalFilename());
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(listob==null||listob.size()<=1)
        {

            throw  new ImportException("未关联到任何数据!");
        }
        else
        {
            try {

                List colname=new ArrayList<>();
                //List coldata=new ArrayList<>();
                int x=0;
                int y=0;
                int row=0;
                for(int i=0;i<listob.size();i++)
                {
                    if( listob.get(i).contains("供应商/供应工厂")&& listob.get(i).contains("物料"))
                    {
                        for(int j=0;j<listob.get(i).size();j++)
                        {
                            if(listob.get(i).get(j).toString().equals("供应商/供应工厂"))
                            {
                                x=j;
                            }
                            if(listob.get(i).get(j).toString().equals("物料"))
                            {
                                y=j;
                            }
                        }
                        row=i;
                        colname.addAll(listob.get(i));
                        break;
                    }

                    // System.out.println( );
                }
                List<Map<String,Object>> list=new ArrayList<>();
                for(int i=row+1;i<listob.size();i++)
                {
                    if(!(listob.get(i).contains("供应商/供应工厂")&& listob.get(i).contains("物料")))
                    {
                        if(listob.get(i).get(x)!=null&&listob.get(i).get(y)!=null&&!(listob.get(i).get(x).toString().equals("*")))
                        {
                            Map map=new HashMap();
                            for(int j=0;j<listob.get(i).size();j++)
                            {

                                map.put(colname.get(j).toString().trim(),listob.get(i).get(j));
                            }
                            map.put("creatorid", GlobalVarContext.user.getFid());
                           // list.add(map);
                            saveBillOrder(map);
                        }
                    }
                }


                //System.out.println(list);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
