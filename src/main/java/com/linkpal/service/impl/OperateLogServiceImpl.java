package com.linkpal.service.impl;

import com.linkpal.dao.IOperateLogDao;
import com.linkpal.model.Operatelog;
import com.linkpal.model.Page;
import com.linkpal.service.IOperateLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("OperatelogServiceImpl")
public class OperateLogServiceImpl implements IOperateLogService {

    @Autowired
            @Qualifier("OperateLogDaoImpl")
    IOperateLogDao dao;

    @Override
    public Map<String, Object> getPageList(HttpServletRequest request, Map map) {
        Map m=new HashMap();
        List<Operatelog> list=null;
        String pageNow = request.getParameter("pageNow");
        String condition=request.getParameter("condition");
        HttpSession session=request.getSession();
        if(condition==null || "".equals(condition))
        {
            session.setAttribute("Operatelog", map);
        }
        else
        {
            map=(Map) session.getAttribute("Operatelog");
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
