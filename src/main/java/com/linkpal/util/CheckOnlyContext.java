package com.linkpal.util;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;


import com.linkpal.service.IBaseService;

public class CheckOnlyContext{

	public String CheckOnly(String number, IBaseService service, String param, int ID) throws Exception
	{
		Map<String,Object> map=new HashMap<String,Object>();
		if(ID>0)
		{
			
			if(!number.equals(param))
			{

			map.put("valid", service.getDetail(param)!=null?false:true);
		    		
			}
			else
			{
				map.put("valid",true);  
			}
		}
		else
		{
			map.put("valid", service.getDetail(param)!=null?false:true);
	    	
		}
		ObjectMapper mapper = new ObjectMapper();
    	return mapper.writeValueAsString(map);
	}
}
