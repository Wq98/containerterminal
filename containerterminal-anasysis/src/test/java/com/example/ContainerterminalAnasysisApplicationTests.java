package com.example;


import com.example.service.HbaseService;
import com.example.util.HbaseUtil;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ContainerterminalAnasysisApplicationTests {

    @Test
    public void contextLoads() {
    }
    @Resource
    private HbaseService hbaseService;
    //测试创建表
    /*@Test
    public void testCreateTable() {
        hbaseService.creatTable("test_base", Arrays.asList("a", "back"));
    }*/
    //测试加入数据
    @Test
    public void testPutData() {
        hbaseService.putData("test_base", "000001", "a", new String[]{
                "project_id", "varName", "coefs", "pvalues", "tvalues",
                "create_time"}, new String[]{"40866", "mob_3", "0.9416",
                "0.0000", "12.2293", "null"});
        hbaseService.putData("test_base", "000002", "a", new String[]{
                "project_id", "varName", "coefs", "pvalues", "tvalues",
                "create_time"}, new String[]{"40866", "idno_prov", "0.9317",
                "0.0000", "9.8679", "null"});
        hbaseService.putData("test_base", "000003", "a", new String[]{
                "project_id", "varName", "coefs", "pvalues", "tvalues",
                "create_time"}, new String[]{"40866", "education", "0.8984",
                "0.0000", "25.5649", "null"});
    }
    //测试遍历全表
    @Test
    public void testGetResultScanner() {
        Map<String, Map<String, String>> result2 = hbaseService.getResultScanner("user");
        System.out.println("-----遍历查询全表内容-----");
        result2.forEach((k, value) -> {
            System.out.println(k + "--->" + value);
        });
    }
    @Test
    public void show() throws Exception {
        Configuration config = HBaseConfiguration.create();
        //1.2 通过连接工厂，传入配置文件对象，创建一个连接
        Connection connection = ConnectionFactory.createConnection(config);

        // 1.定义表的名称
        TableName tableName = TableName.valueOf("user");

        // 2.获取表
        Table table = connection.getTable(tableName);

        // 3.准备数据
        String rowKey = "16zhangsan";

        // 4.拼装查询条件
        Get get = new Get(Bytes.toBytes(rowKey));

        // 5.查询数据
        Result result = table.get(get);

        // 6.打印数据 获取所有的单元格
        List<Cell> cells = result.listCells();
        for (Cell cell : cells) {
            // 打印rowkey,family,qualifier,value
            System.out.println(Bytes.toString(CellUtil.cloneValue(cell)));
        }

    }
}
