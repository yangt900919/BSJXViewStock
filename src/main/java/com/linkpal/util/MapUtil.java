package com.linkpal.util;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapUtil {

    public static Map<String,Object> getMap(HttpServletRequest request)
    {
        Map<String,Object> map=new HashMap<String,Object>();
        if(request!=null)
        {
            Set<String> set=request.getParameterMap().keySet();
            for(String s :set)
            {
                map.put(s, request.getParameter(s));
            }
        }

        return map;
    }
}
