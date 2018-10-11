package com.linkpal.service.impl;

import com.linkpal.Excepetion.ImportException;
import com.linkpal.dao.IBillOrderDao;
import com.linkpal.dao.IMaterialDao;
import com.linkpal.model.*;
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

    @Qualifier("materialDaoImpl")
    @Autowired
    private IMaterialDao materialDao;

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
    public Map<String,Object> importInfo(InputStream in, MultipartFile file,HttpServletRequest request) throws ImportException {

        List<List<Object>> listob=null;

        String rs="";

        List<Material> malist=new ArrayList<>();

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
                int z=0;
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
                            if(listob.get(i).get(j).toString().equals("采购凭证"))
                            {
                                z=j;
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
                    if(!(listob.get(i).contains("供应商/供应工厂")&& listob.get(i).contains("物料")&& listob.get(i).contains("采购凭证")))
                    {
                        if(listob.get(i).size()>0&&listob.get(i).get(x)!=null&&listob.get(i).get(y)!=null&&listob.get(i).get(z)!=null&&!(listob.get(i).get(x).toString().equals("*")))
                        {
                            Map map=new HashMap();
                            for(int j=0;j<listob.get(i).size();j++)
                            {

                                if(colname.get(j).toString().trim().equals("订单数量"))
                                {
                                    colname.remove(j);
                                    colname.add(j,"数量");
                                }
                                map.put(colname.get(j).toString().trim(),listob.get(i).get(j));
                            }
                            map.put("creatorid", ((User)request.getSession().getAttribute("user")).getFid());
                            list.add(map);

                        }
                    }
                }

                for(int i=0;i<list.size();i++)
                {
                    int flag=0;
                   for(int j=0;j<list.size();j++)
                   {
                       if(list.get(i).get("采购凭证").toString().equals(list.get(j).get("采购凭证").toString()))flag++;
                   }
                   list.get(i).put("flag",flag);
                }

                for(int i=0;i<list.size();i++)
                {
                    List<Map<String,Object>> rlist= saveBillOrder(list.get(i));

                    if(rlist.size()>0)
                    {
                        if(!(rlist.get(0).get("message").toString().equals("成功")))
                        {
                            if(!(rs.equals(rlist.get(0).get("message").toString())))
                            rs=rs+rlist.get(0).get("message").toString();
                        }
                        if(rlist.get(0).get("state").toString().equals("500"))
                        {
                            malist.add(materialDao.getDetail(Integer.parseInt(rlist.get(0).get("data").toString())));
                        }
                    }
                }


                //System.out.println(list);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Map map=new HashMap();
        if(rs.equals("")) rs="导入成功";
        map.put("rs",rs);
        map.put("malist",malist);
        return map;
    }

    @Override
    public void updateStock(Map map) {
        IBillOrderDao.updateStock(map);
    }


}
