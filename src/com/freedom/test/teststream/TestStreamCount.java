package com.freedom.test.teststream;



import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

/**
 * @author ：wujie
 * @date ：Created in 2019/11/9 12:33
 * @description：测试Stream多线程统计
 * @version: 1.0.0
 */
public class TestStreamCount {
    private double money=0;
    private ThreadLocal<String> t1= new ThreadLocal();
    public static void main(String[] args) {
        /*List<String> list = new ArrayList<>();
        for (int i=0;i<1000;i++){
            list.add("1");
        }
        double count = count(list);
        System.out.println("主线程执行");
        System.out.println(count);*/
    }

    public  double count(List<String> list){
        int a=0;
     list.parallelStream().forEach(x->{



     });
        return  money;
    }
}
