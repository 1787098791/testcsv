package com.freedom.test;

import au.com.bytecode.opencsv.CSVReader;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author ：wujie
 * @date ：Created in 2019/10/30 13:09
 * @description：开始方法
 * @version: 1.0.0
 */
public class StartMethod {

    private  static  String FILEPATH="c:\\code.csv";

    public static void main(String[] args) throws Exception {

        long startTime = System.currentTimeMillis();
        saveInfo();
        long endTime = System.currentTimeMillis();
        System.out.println("耗时:  "+Long.toString(endTime-startTime));

    }

    public static void saveInfo() throws Exception{
        File csv = new File(FILEPATH);
        CSVReader reader = new CSVReader(new InputStreamReader(new FileInputStream(csv), "UTF-8"), ',');
        //此时读取的已经是第二行了
        List<String[]> list = reader.readAll();
        reader.close();
        List<String> strs = new ArrayList<>();
        for (String[] strings:list){
            strs.add(strings[0]);
        }
        strs.remove(strs.get(0));
        System.out.println(strs);
        TaskThread taskThread = new TaskThread();
        taskThread.setDbUtils(new DBUtils());
        taskThread.setCode(strs);
        List<Thread> threads = new ArrayList<>();
        //使用线程池
        //创建队列,工厂和任务拒绝处理采用默认配置
        SynchronousQueue<Runnable> syn = new SynchronousQueue<>();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20, 30, TimeUnit.SECONDS, syn);
        for(int i=1;i<=10;i++){
            threadPoolExecutor.execute(taskThread);
        }
        //线程池的任务执行完才会关闭,而shutdownNow()立刻关闭，不管任务执行
        threadPoolExecutor.shutdown();
        //shutdown执行后isShutdown()就为true
        //线程池任务执行完成isTerminated()为true
        while (!threadPoolExecutor.isTerminated()){

        }
        //测试线程池关闭后能否继续？结果抛出异常
        //threadPoolExecutor.execute(taskThread);

       /* for (int i=1;i<=10;i++){
            Thread thread = new Thread(taskThread);
            threads.add(thread);
            thread.start();
        }
        for (Thread thread:threads){
            thread.join();
        }*/
    }


}
