package com.linkpal.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    //时间格式转字符串的时间格式，格式为“yyyy-MM-dd HH:mm:ss"
    public  static String longDateToString(Date date)
    {
        return  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    }

    //时间格式转字符串的时间格式，格式为“yyyy-MM-dd"
    public  static String shortDateToString(Date date)
    {
        return  new SimpleDateFormat("yyyy-MM-dd").format(date);
    }

    //字符串日期转日期格式

    public static Date StringToDate (String date) throws Exception
    {

        return new SimpleDateFormat().parse(date);
    }

    public static String getDateNow()
    {
        return new java.sql.Date(new Date().getTime()).toString();
    }

    public static String getDatePreM()
    {
        Calendar cl = Calendar.getInstance();
        cl.setTime(new Date());
        cl.add(Calendar.MONTH,-1);
        Date date=cl.getTime();
        return new java.sql.Date(date.getTime()).toString();
    }
}
