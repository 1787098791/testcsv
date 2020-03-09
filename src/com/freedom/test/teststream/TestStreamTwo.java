package com.freedom.test.teststream;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author ：wujie
 * @date ：Created in 2019/11/1 10:04
 * @description：测试并行流
 * @version: 1.0.0
 */
public class TestStreamTwo {
    public static void main(String[] args) {
        //创建线程池
        ThreadPoolExecutor executorService = (ThreadPoolExecutor)Executors.newFixedThreadPool(10);
        executorService.setKeepAliveTime(2, TimeUnit.SECONDS);
        executorService.allowCoreThreadTimeOut(true);
        Stream<Integer> stream = Stream.iterate(1, x -> (x + 1)).limit(10000);
        List<Integer> list = stream.collect(Collectors.toList());
        long s = System.currentTimeMillis();
        List<Integer> integers = new ArrayList<>();
        //转为并行流,多线程处理
        list.parallelStream().forEach(x->{
            System.out.println("father:     "+Thread.currentThread().getName());
            executorService.submit(()->{
            System.out.println(Thread.currentThread().getName()+"++++++++"+x);
            integers.add(x);
            });
        });

        //lambda表达式中如果只有并行流，则并行流的多线程执行完才执行主线程,若有自定义的连接池，则主线程的执行问题要考虑
        executorService.shutdown();
        //只有执行完shutdown()再执行isTerminated()才返回true,其他情况都是false(线程池任务执行完但不执行shutdown()也是false)
        /*while(!executorService.isTerminated()){

        }*/
        System.out.println(executorService.isTerminated());
        System.out.println("大小"+integers.size());
        System.out.println("主线程执行");

        long e = System.currentTimeMillis();
        System.out.println(e-s);

        //stream.forEach(System.out::println);

    }



}
