package com.freedom.test;

import com.freedom.test.testxstream.Person;

import java.util.*;
import java.util.stream.Stream;

/**
 * @author ：wujie
 * @date ：Created in 2019/12/8 12:58
 * @description：
 * @version:
 */
public class TestParse {
    public static void main(String[] args) {
        /*new Thread(){

            @Override
            public void run() {
                for (int i=1;i<100000;i++){
                    System.out.println(Thread.currentThread().getName());
                }
            }
        }.start();
        Stream.iterate(0,x->x+1).limit(1000).parallel().forEach(x->{
            System.out.println(Thread.currentThread().getName()+"-------"+x);
        });*/
        /*ArrayList<Object> objects = new ArrayList<>(10);
        objects.add(0,3);
        objects.add(1,3);
        objects.set(0,5);
        System.out.println(objects);*/
        /*Integer toDayLastSecond = getToDayLastSecond();
        System.out.println(toDayLastSecond);*/

        /*ArrayList<Person> objects = new ArrayList<>();
        objects.add(new Person("a",20,"0"));
        objects.add(new Person("a",25,"0"));
        objects.add(new Person("a",26,"0"));
        Collections.sort(objects, (x,y)->x.getAge()-y.getAge());
        System.out.println(objects.get(0));*/

        /*Integer integer = new Integer(3);
        Integer integer1 = new Integer(3);
        System.out.println(integer.equals(integer1));*/

        Person a = new Person("a", 20, "0");
        Person test = test(a);
        System.out.println(a);
        System.out.println(test);
        System.out.println(a==test);



        /*ArrayList<Object> objects = new ArrayList<>();
        ArrayList<Object> objects1 = new ArrayList<>();
        objects.add(1);
        objects.add(2);
        objects.add(3);
        objects.add(4);
        objects1.add("a");
        objects1.add("b");
        objects1.add("c");
        List<Object> mergeList = getMergeList(objects, objects1);
        System.out.println(mergeList);*/


    }

    private static Integer getToDayLastSecond(){
        Calendar curDate = Calendar.getInstance();
        Calendar tommorowDate = new GregorianCalendar(curDate
                .get(Calendar.YEAR), curDate.get(Calendar.MONTH), curDate
                .get(Calendar.DATE) + 1, 0, 0, 0);
        return (int)(tommorowDate.getTimeInMillis() - curDate .getTimeInMillis()) / 1000;
    }

    public static List<Object> getMergeList(List<Object> productList,List<Object> activityList){
        //未被推荐的购券商品的数量
        int productSize = productList.size();
        //未被推荐的活动的数量
        int activitySize = activityList.size();
        List<Object> list = new ArrayList<>();
        int max=productSize>activitySize?productSize:activitySize;
        for (int i=0;i<max;i++){
            //先加购券商品
            if (i<productSize){
                list.add(productList.get(i));
            }
            //后加活动
            if (i<activitySize){
                list.add(activityList.get(i));
            }
        }
        return list;
    }

    public static Person test(Person person){
        person.setName("花花");
        return person;
    }
}
