package com.freedom.test.testuuid;

import com.sun.jndi.cosnaming.ExceptionMapper;

import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ：wujie
 * @date ：Created in 2019/11/6 15:16
 * @description：uuid
 * @version: 1.0.0
 */
public class TestUUID {
    public static void main(String[] args) throws UnsupportedEncodingException {
        for (int i=0;i<100;i++){
        System.out.println(UUID.randomUUID().toString().replaceAll("-","").toString());


        }
        System.out.println("二".getBytes("GBK").length);

     /*   System.out.println(Calendar.getInstance());
        ArrayList<Object> objects = new ArrayList<>();
        objects.add("1");
        objects.add("2");
        objects.add("3");
        List<String> collect = objects.parallelStream().map(x -> {
            return x + "s";
        }).collect(Collectors.toList());
        System.out.println(collect);*/

     /*   System.out.println(1);
        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(2);
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        System.out.println(3);*/


      /*  String str="233 and id in (%s) ";
        String id1="1";
        String id2="2";
        String ids="'"+id1+"'"+","+"'"+id2+"'"+",";
        str = String.format(str, ids);
        System.out.println(str);
        String substring = ids.substring(0, ids.length()-1);

        System.out.println(substring);*/



    }

    public static String test(){
        while(true){

            return "ok";
        }
    }
}
