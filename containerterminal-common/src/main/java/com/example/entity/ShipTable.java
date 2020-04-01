package com.example.entity;

/**
 * @Author: 魏秦
 * @Date: 2020-03-27 14:37
 * @description: com.example.entity
 */
public class ShipTable {
    //表名
   public static String tableName="ship";
    //列族
    public static byte[][] family= {
            "ship_eu".getBytes()
    };

    //定义表中所有字段名称
    public static byte[] id="id".getBytes();
    public static byte[] unit="unit".getBytes();
    public static byte[] unload="unload".getBytes();
    public static byte[] load="load".getBytes();
    public static byte[] vessel="vessel".getBytes();
    public static byte[] geo="geo".getBytes();
    public static byte[] time18="time18".getBytes();
    public static byte[] time17="time17".getBytes();
    public static byte[] time16="time16".getBytes();
    public static byte[] time15="time15".getBytes();
    public static byte[] time14="time14".getBytes();
    public static byte[] time13="time13".getBytes();
    public static byte[] time12="time12".getBytes();
    public static byte[] time11="time11".getBytes();
    public static byte[] time10="time10".getBytes();
    public static byte[] time09="time09".getBytes();
    public static byte[] time08="time08".getBytes();
    public static byte[] time07="time07".getBytes();

    public static byte[][] clos= {id,unit,unload,load,vessel,geo,time18,time17,time16,time15,time14,time13,time12,time11,time10,time09,time08,time07};

}
