package com.example;


import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;

@SpringBootTest
class ContainerterminalBasicdataApplicationTests {

    @Test
    void contextLoads() {
    }

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        ExecutorService executorService=new ThreadPoolExecutor(2,5,1L, TimeUnit.SECONDS,new LinkedBlockingDeque<Runnable>());
     //   final CountDownLatch countDownLatch = new CountDownLatch(5);
        List<String> list = new ArrayList<String>();
        Date date=new Date();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        String format1 = format.format(date);
        String inputFile="E:\\\\毕业设计\\\\iww_go_atyvefl\\\\7atyvefl.csv";
        String outPath = "E:\\\\毕业设计\\\\iww_go_atyvefl\\\\"+format1+"_atyvefl.csv";
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(new FileInputStream(inputFile)));
        BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(outPath));
        Map<String,Integer> map = new HashMap<String, Integer>();

        executorService.submit(new Runnable() {
                @Override
                public void run() {
                    int count=0;
                    int dataCount = 0;
                    String line = null;
                    try {
                        line = bufferedReader.readLine();
                        String str="";
                    while(line!=null) {
                        String[] newStrs = line.split(",");
                        for (int i = 3; i < 4; i++) {
                            str = newStrs[3];
                            if(map.containsKey(str)){
                                map.put(str,map.get(str)+count);
                            }else{
                                map.put(str,1);
                                count++;
                            }
                        }
                        String string="";
                        for(Map.Entry<String, Integer> entry : map.entrySet()){
                            string=entry.getKey()+","+entry.getValue();
                        }
                        bufferedWriter.write(string);
                        bufferedWriter.newLine();
                        dataCount++;
                        str = "";
                        line = bufferedReader.readLine();
                    }
                        if(bufferedReader!=null){
                            try {
                                bufferedReader.close();
                            } catch (IOException e) {
                            }
                        }
                        bufferedWriter.flush();
                        System.out.println("共处理:"+dataCount+"条数据");
                        executorService.shutdown();
                        System.out.println("线程关闭");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }finally{

                        if(bufferedWriter!=null){
                            try {
                                bufferedWriter.close();
                                System.out.println("输出流关闭");
                                long  end=System.currentTimeMillis();
                                System.out.println("用时："+(end-start)+"ms");
                            } catch (IOException e) {
                            }
                        }
                    }
                }
            });



    }

}
