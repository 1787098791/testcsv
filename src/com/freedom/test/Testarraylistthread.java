package com.freedom.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author ：wujie
 * @date ：Created in 2019/11/18 12:39
 * @description：
 * @version:
 */
public class Testarraylistthread {
    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();

        for (int i=0;i<=100000;i++){
            list.add(1);
        }
        ArrayList<Object> objects = new ArrayList<>();
        //HashSet<Object> objects = new HashSet<>();

        System.out.println(list.size());
        list.parallelStream().forEach(x->{


            objects.add(x);

        });
        System.out.println(objects.size());
       /* CopyOnWriteArraySet<Object> objects = new CopyOnWriteArraySet<>();
        objects.add(1);
        objects.add(1);
        System.out.println(objects.size());*/
    }
}
