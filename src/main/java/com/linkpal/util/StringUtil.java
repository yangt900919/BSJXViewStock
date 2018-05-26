package com.linkpal.util;

import java.io.UnsupportedEncodingException;

public class StringUtil {

    public static boolean isEmpty(String content){
        return null == content || "".equals(content);
    }

    public static  String getString(String str)
    {
        try {
            str=new String(str.trim().getBytes("ISO-8859-1"), "UTF-8");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static boolean isNumeric(String str)
    {
        boolean bool=false;
        try{
         Float.parseFloat(str);
         bool=true;
        }
        catch (NumberFormatException e)
        {
            bool=false;
        }
        return bool;
    }

    public static Integer Change(Integer param)
    {
        if(param==null) return 0;
        else return param;
    }

    public static Double isNull(Double param)
    {
        if(param==null) return 0.0;
        else return param;
    }
}
