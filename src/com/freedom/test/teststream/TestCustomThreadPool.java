package com.freedom.test.teststream;

import java.util.concurrent.*;

/**
 * @author ：wujie
 * @date ：Created in 2019/11/1 14:06
 * @description：test
 * @version: 1.0.0
 */
public class TestCustomThreadPool {

    public static void main(String[] args) throws Exception {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 15, 3, TimeUnit.SECONDS, new SynchronousQueue<>());
        //测试阻塞,线程回归线程池但并未销毁，所以jvm一直未关闭
        Future<Object> submit = threadPoolExecutor.submit(()->{
            return 6;
        });
        Thread.sleep(20000);
        System.out.println(Thread.currentThread().getName());
        System.out.println(submit.get());

    }
}
