package com.freedom.test.testjvm;

import com.freedom.test.testlistsort.Person;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：wujie
 * @date ：Created in 2019/12/25 11:04
 * @description：
 * @version:
 */
public class Count {



    public static void main(String[] args) throws ClassNotFoundException, InterruptedException {


        //Class<?> aClass = Class.forName("com.freedom.test.testjvm.Student");

        /*Person person = new Person();
        person.setName("1");
        person.setSocer("80");
        Person person2 = new Person();
        person2.setName("2");
        person2.setSocer("80");
        Person person3 = new Person();
        person3.setName("3");
        person3.setSocer("90");
        ArrayList<Person> people = new ArrayList<>();
        people.add(person);
        people.add(person2);
        String name = people.stream().filter(x -> x.getName().equals("1")).findFirst().orElseGet(()->{return person3;}).getName();
        System.out.println(name);*/
        LinkedList<Object> objects = new LinkedList<>();
        objects.add(1);
        objects.add(3);
        objects.add(2);
        System.out.println(objects);


    }


}

