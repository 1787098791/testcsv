package com.freedom.test.teststream;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * @author ：wujie
 * @date ：Created in 2019/11/1 16:33
 * @description：
 * @version: 1.0.0
 */
public class TestForkJoinPool2 {
    public static void main(String[] args) throws Exception {
        //Thread.sleep(10000);
        ForkJoinPool forkJoinPool = new ForkJoinPool(10);
        forkJoinPool.submit(()->{
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("111");
        });
        forkJoinPool.submit(()->{
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("222");
        });
        //设定主线程等待时间3秒，主线程结束ForkJoinPool线程也结束
        forkJoinPool.awaitTermination(3, TimeUnit.SECONDS);
        //Thread.sleep(2000);
    }
}
