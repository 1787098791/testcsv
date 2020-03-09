package com.freedom.test.testlistsort;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ：wujie
 * @date ：Created in 2019/12/3 19:01
 * @description：
 * @version:
 */
public class TestList {
    public static void main(String[] args) {
        /*ArrayList<Person> objects = new ArrayList<>();
        objects.add(new Person("a","80"));
        objects.add(new Person("b","60"));
        objects.add(new Person("c","50"));
        objects.add(new Person("d","90"));
        Collections.sort(objects, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getSocer().compareTo(o2.getSocer());
            }
        });
        System.out.println(objects);*/
        /*ArrayList<Object> objects = new ArrayList<>();
        objects.add("1");
        objects.add("2");
        objects.add("3");
        System.out.println(objects.subList(0,2));*/
        /*String regex="(\\w*\\-*)*";
        System.out.println(UUID.randomUUID().toString().matches(regex));*/
        /*ArrayList<List<Object>> rows = new ArrayList<>();
        List<Object> row = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        ArrayList<Object> str = new ArrayList<>();
        str.add("1");
        str.add("2");
        str.add("3");

        System.out.println(row);
        rows.add(Collections.singletonList(row));
        rows.add(str);
        System.out.println(rows);*/
        /*ArrayList<Object> objects = new ArrayList<>();
        objects.add(1);
        objects.add(2);
        objects.add(2);
        objects.add(1);
        objects.add(1);
        AtomicInteger atomicInteger = new AtomicInteger();
        objects.parallelStream().forEach(x->{
            if ((Integer)x==2){
                atomicInteger.addAndGet((Integer) x);
            }
        });
        System.out.println(atomicInteger);*/


    }
}
