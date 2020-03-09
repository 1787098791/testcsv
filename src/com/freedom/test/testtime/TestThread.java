package com.freedom.test.testtime;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.freedom.test.testxstream.Person;
import com.sun.org.apache.xml.internal.security.algorithms.SignatureAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author ：wujie
 * @date ：Created in 2019/12/20 14:27
 * @description：
 * @version:
 */
public class TestThread {
    private static int SIZE = 6;
    private static CyclicBarrier cb;
    public static void main(String[] args) throws Exception {

     /*   //初始化线程数量为6
        cb = new CyclicBarrier(SIZE,()->{
            System.out.println(Thread.currentThread().getName()+""+":  "+"最后到达");
        });
        //cb=new CyclicBarrier(SIZE);

        // 新建5个任务
        for(int i=0; i<5; i++){

            new Thread(()->{
                try {
                    System.out.println(Thread.currentThread().getName()+"等待。。。");
                    cb.await();
                    System.out.println(Thread.currentThread().getName()+"等待。。。");
                    cb.await();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }

            }).start();
        }

        //只有当6个线程都到达屏障时才继续执行(本例中包括主线程)
        //哪个线程调用await()方法，则标志那个线程到达屏障
        cb.await();
        System.out.println("主线程执行");

        cb.await();
        System.out.println("主线程执行");*/

        System.out.println(15L>10);

        Person person = new Person();
        person.setName("xiaoming");
        String string = JSONObject.toJSONString(person);
        System.out.println(string);
        JSONObject jsonObject = JSONObject.parseObject(string);
        System.out.println(jsonObject);

    }



}


