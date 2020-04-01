package com.example.util;

import com.example.entity.ShipTable;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

/**
 * @Author: 魏秦
 * @Date: 2020-03-27 14:38
 * @description: com.example.util
 */
public class HbaseUtil {
    static Configuration conf=null;
    static Connection conn=null;
    static TableName tbName=null;
    static Table table=null;
    static {
        try {
            //1-获取配置
            conf= HBaseConfiguration.create();
            //2-指定zookeeper节点的IP地址
            conf.set("hbase.zookeeper.quorum", "192.168.56.100");
            //3-创建和HBase数据连接对象
            conn= ConnectionFactory.createConnection(conf);
            //获取表名描述器
            tbName=TableName.valueOf(ShipTable.tableName);
            //获取表连接
            table=conn.getTable(tbName);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    //插入方法
    public static void put(Put put) throws Exception {
        //put对象
        //通过表连接对象执行上传数据
        table.put(put);

    }

    //读取方法
    public static ResultScanner show(String id) throws Exception {
        //全表扫描的方式获取数据 -- 创建Scan对象
        Scan scan = new Scan(Bytes.toBytes(id),Bytes.toBytes(id));
        //查询数据，并返回结果集
        ResultScanner rs = table.getScanner(scan);
        return rs;
    }

    //外包可以调用该方法（public static）
    //只有本包内可以调用（static）
    public static Table getTable(){
        return table;
    }
	/*
	//关闭资源
	public static void getClose() {
		if(rs!=null) {
			try {
				rs.close();
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		if(table!=null) {
			try {
				table.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null) {
			try {
				conn.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	*/
}
