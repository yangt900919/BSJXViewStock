package com.linkpal.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.linkpal.dao.IBaseDao;
import com.linkpal.model.Page;

public class PageList<T> {
	
	public  Map<String, Object> getPageList(IBaseDao<T> dao, HttpServletRequest request, T t, String name)
	{
		Map map=new HashMap();
		List<T> list=null;
		String pageNow = request.getParameter("pageNow");
		String condition=request.getParameter("condition");
		HttpSession session=request.getSession();
		if(condition==null || "".equals(condition))
		{
			session.setAttribute(name, t);
		}
		else
		{
			t=(T) session.getAttribute(name);
		}
		Page page = null;
    	int totalCount=0;
    	try{
			totalCount=dao.getTotalNum(t);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
    	if (pageNow != null) {  
	        page = new Page(totalCount, Integer.parseInt(pageNow));  
	    } else {  
	        page = new Page(totalCount, 1);  
	    } 
    	list=dao.getList(page.getStartPos(), page.getPageSize(),t);
    	map.put("list", list);
    	map.put("page", page);
    	map.put("model", t);
    	return map;
	}

}
