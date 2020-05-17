package com.example.service;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: 魏秦
 * @Date: 2020-03-27 12:30
 * @description: com.example.service
 */
public class HbaseService {
    /**
     * 管理员可以做表以及数据的增删改查功能
     */
    private Admin admin = null;
    static Connection connection = null;

    public HbaseService(Configuration conf) {
        try {
            connection = ConnectionFactory.createConnection(conf);
            admin = connection.getAdmin();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 创建表 create <table>, {NAME => <column family>, VERSIONS => <VERSIONS>}
     */
    /*public boolean creatTable(String tableName, List<String> columnFamily) {
        try {
            //列族column family
            List<ColumnFamilyDescriptor> cfDesc = new ArrayList<ColumnFamilyDescriptor>(columnFamily.size());
            columnFamily.forEach(cf -> {
                cfDesc.add(ColumnFamilyDescriptorBuilder.newBuilder(
                        Bytes.toBytes(cf)).build());
            });
            //表 table
            TableDescriptor tableDesc = TableDescriptorBuilder
                    .newBuilder(TableName.valueOf(tableName))
                    .setColumnFamilies(cfDesc).build();
            if (admin.tableExists(TableName.valueOf(tableName))) {
                System.out.println("table Exists!");
            } else {
                admin.createTable(tableDesc);
                System.out.println("create table Success!");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            close(admin, null, null);
        }
        return true;
    }*/
    /**
     * 查询所有表的表名
     */
    public List<String> getAllTableNames() {
        List<String> result = new ArrayList<>();
        try {
            TableName[] tableNames = admin.listTableNames();
            for (TableName tableName : tableNames) {
                result.add(tableName.getNameAsString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close(admin, null, null);
        }
        return result;
    }
    /**
     * 遍历查询指定表中的所有数据
     */
    public Map<String, Map<String, String>> getResultScanner(String tableName) {
        Scan scan = new Scan();
        return this.queryData(tableName, scan);
    }
    /**
     * 通过表名及过滤条件查询数据
     */
    private Map<String, Map<String, String>> queryData(String tableName, Scan scan) {
        // <rowKey,对应的行数据>
        Map<String, Map<String, String>> result = new HashMap<>();
        ResultScanner rs = null;
        //获取表
        Table table = null;
        try {
            table = getTable(tableName);
            rs = table.getScanner(scan);
            for (Result r : rs) {
                // 每一行数据
                Map<String, String> columnMap = new HashMap<>();
                String rowKey = null;
                // 行键，列族和列限定符一起确定一个单元（Cell）
                for (Cell cell : r.listCells()) {
                    if (rowKey == null) {
                        rowKey = Bytes.toString(cell.getRowArray(), cell.getRowOffset(), cell.getRowLength());
                    }
                    columnMap.put(
                            //列限定符
                            Bytes.toString(cell.getQualifierArray(), cell.getQualifierOffset(), cell.getQualifierLength()),
                            //列族
                            Bytes.toString(cell.getValueArray(), cell.getValueOffset(), cell.getValueLength()));
                }
                if (rowKey != null) {
                    result.put(rowKey, columnMap);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close(null, rs, table);
        }
        return result;
    }
    /**
     * 为表添加或者更新数据
     */
    public void putData(String tableName, String rowKey, String familyName, String[] columns, String[] values) {
        Table table = null;
        try {
            table = getTable(tableName);
            putData(table, rowKey, tableName, familyName, columns, values);
        } catch (Exception e) {
           e.printStackTrace();
        } finally {
            close(null, null, table);
        }
    }
    private void putData(Table table, String rowKey, String tableName, String familyName, String[] columns, String[] values) {
        try {
            //设置rowkey
            Put put = new Put(Bytes.toBytes(rowKey));
            if (columns != null && values != null && columns.length == values.length) {
                for (int i = 0; i < columns.length; i++) {
                    if (columns[i] != null && values[i] != null) {
                        put.addColumn(Bytes.toBytes(familyName), Bytes.toBytes(columns[i]), Bytes.toBytes(values[i]));
                    } else {
                        throw new NullPointerException(MessageFormat.format(
                                "列名和列数据都不能为空,column:{0},value:{1}", columns[i], values[i]));
                    }
                }
            }
            table.put(put);
            System.out.println("putData add or update data Success,rowKey:" + rowKey);
            table.close();
        } catch (Exception e) {
          e.printStackTrace();
        }
    }
    /**
     * 根据表名获取table
     */
    public static Table getTable(String tableName) throws IOException {
        return connection.getTable(TableName.valueOf(tableName));
    }
    public static ResultScanner show(String id) throws Exception {
        Table table=getTable("ship");
        //全表扫描的方式获取数据 -- 创建Scan对象
        Scan scan = new Scan(Bytes.toBytes(id),Bytes.toBytes(id));
        //查询数据，并返回结果集
        ResultScanner rs = table.getScanner(scan);
        return rs;
    }

    public static ResultScanner showAll() throws Exception {
        Table table=getTable("ship");
        //全表扫描的方式获取数据 -- 创建Scan对象
        Scan scan = new Scan();
        //查询数据，并返回结果集
        ResultScanner rs = table.getScanner(scan);
        return rs;
    }
    /**
     * 关闭流
     */
    private void close(Admin admin, ResultScanner rs, Table table) {
        if (admin != null) {
            try {
                admin.close();
            } catch (IOException e) {
               e.printStackTrace();
            }
            if (rs != null) {
                rs.close();
            }
            if (table != null) {
                rs.close();
            }
            if (table != null) {
                try {
                    table.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
