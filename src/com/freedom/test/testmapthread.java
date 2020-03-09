package com.freedom.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ：wujie
 * @date ：Created in 2019/11/10 18:44
 * @description：
 * @version:
 */
public class testmapthread {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        HashSet<Object> set = new HashSet<>();

        for (int i=0;i<10000;i++){
            executorService.submit(()->{
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                set.add(1);
            });
        }

        executorService.shutdown();
        while(!executorService.isTerminated()){

        }
        System.out.println(set.size());

       /* ArrayList<Object> objects = new ArrayList<>();
        HashSet<Object> objects1 = new HashSet<>();
        objects.add(1);
        objects.add(2);
        objects.add(3);
        boolean b = objects1.addAll(objects);
        System.out.println(objects1);
        ArrayList<Object> objects3 = new ArrayList<>();
        objects3.add(1);
        objects3.add(5);
        objects3.add(3);
        objects1.addAll(objects3);
        System.out.println(objects1);*/

    }
}
