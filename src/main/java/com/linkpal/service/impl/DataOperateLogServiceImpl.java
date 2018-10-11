package com.linkpal.service.impl;

import com.linkpal.dao.IDataOperateLogDao;
import com.linkpal.dao.IOperateLogDao;
import com.linkpal.model.Dataoperatelog;
import com.linkpal.model.Page;
import com.linkpal.service.IDataOperateLogService;
import com.linkpal.service.IOperateLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("DataoperatelogServiceImpl")
public class DataOperateLogServiceImpl implements IDataOperateLogService {

    @Autowired
            @Qualifier("DataOperateLogDaoImpl")
    IDataOperateLogDao dao;

    @Override
    public Map<String, Object> getPageList(HttpServletRequest request, Map map) {
        Map m=new HashMap();
        List<Dataoperatelog> list=null;
        String pageNow = request.getParameter("pageNow");
        String condition=request.getParameter("condition");
        HttpSession session=request.getSession();
        if(condition==null || "".equals(condition))
        {
            session.setAttribute("Dataoperatelog", map);
        }
        else
        {
            map=(Map) session.getAttribute("Dataoperatelog");
        }
        Page page = null;
        int totalCount=dao.getTotalNum(map);
        if (pageNow != null) {
            page = new Page(totalCount, Integer.parseInt(pageNow));
        } else {
            page = new Page(totalCount, 1);
        }
        map.put("pageIndex", page.getStartPos());
        map.put("pageSize", page.getPageSize());
        list=dao.getList(map);
        m.put("list", list);
        m.put("page", page);
        m.put("model", map);
        return m;
    }
}
