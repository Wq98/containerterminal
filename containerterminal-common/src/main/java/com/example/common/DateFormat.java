package com.example.common;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: 魏秦
 * @Date: 2020-03-21 18:09
 * @description: com.example.common
 */
public class DateFormat {
    /***
     * 时间格式化封装
     * @param date
     * @return
     */
    public static String dateFormat(Date date){
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }

    public static String dateFormat1(Date date){
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }
}
