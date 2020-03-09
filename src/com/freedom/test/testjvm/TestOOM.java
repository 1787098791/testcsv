package com.freedom.test.testjvm;

import com.freedom.test.testlistsort.Person;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author ：wujie
 * @date ：Created in 2019/12/24 19:09
 * @description：
 * @version:
 */
public class TestOOM {
    public static void main(String[] args) throws InterruptedException {
        /*try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ArrayList<Object> objects = new ArrayList<>();
        while (true){
            objects.add(new Person());
        }*/

        ExecutorService executorService = Executors.newFixedThreadPool(20);
        for (int i=0;i<30;i++){
            executorService.submit(()->{
                new Person();
                System.out.println(1);
            });
        }
        executorService.shutdown();
        boolean b = executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
        if (b){
            System.out.println("finish");
        }
    }
}
