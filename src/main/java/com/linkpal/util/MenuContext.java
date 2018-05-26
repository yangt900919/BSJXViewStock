package com.linkpal.util;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class MenuContext {
	
	public static  List<Map<String,Object>> AnMenuConfig(String path) throws DocumentException
	{
		 List<Map<String,Object>> groups=new ArrayList<Map<String,Object>>();
		    List<Map<String,Object>> mains=new ArrayList<Map<String,Object>>();
		    List<Map<String,Object>> subs=new ArrayList<Map<String,Object>>();
		    
		    Map group=null;
		    Map main=null;
		    Map sub=null;
		    
		SAXReader sax=new SAXReader();//创建一个SAXReader对象  
	    File xmlFile=new File(path+"/menuConfig.xml");//根据指定的路径创建file对象  
	    Document document=sax.read(xmlFile);//获取document对象,如果文档无节点，则会抛出Exception提前结束  
	    Element root=document.getRootElement();//获取根节点  
	    
	    List<Element> childs = root.elements("AdminMenuGroup");
	    
	    for(Element c:childs){
	    	group=new HashMap();
	    	subs=new ArrayList<Map<String,Object>>();
	    	List<Attribute> cAttr=c.attributes();
	    	main=new HashMap();
	    	for(Attribute attr:cAttr){
	    		
	    		 String name=attr.getName();//属性名称  
	    	     String value=attr.getValue();//属性的值  
	    	     main.put(name, value);
	    	}
	    	 group.put("main", main);
	    	List<Element> subchilds =c.elements("AdminMenu");
	    	if(subchilds.size()>0)
	    	{
	    	 for(Element s:subchilds)
	    	 {
	    		 List<Attribute> sAttr=s.attributes();
	    		 sub=new HashMap(); 
	    		 for(Attribute attr1:sAttr){
	    			
	    			 String name=attr1.getName();//属性名称  
		    	     String value=attr1.getValue();//属性的值  
		    	     sub.put(name, value);
	    		 }
	    		 subs.add(sub);
	    	 }
	    	}
	    	
	    	  
		        group.put("sub", subs);
		        groups.add(group);
	    }
	    //System.out.println(groups);
		return groups;
	}
	


}
