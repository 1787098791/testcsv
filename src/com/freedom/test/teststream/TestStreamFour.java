package com.freedom.test.teststream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author ：wujie
 * @date ：Created in 2019/11/12 20:48
 * @description：
 * @version:
 */
public class TestStreamFour {
    private static AtomicInteger n=new AtomicInteger(0);
    public static void main(String[] args) {
        ArrayList<Object> objects = new ArrayList<>();

        for (int i=0;i<10000;i++){
            objects.add(i);
        }
        ArrayList<Object> objects1 = new ArrayList<>();
        objects.parallelStream().forEach(x -> {
         n.addAndGet(1)  ;
        });
        System.out.println(n);
    }
}
