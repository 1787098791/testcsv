package com.freedom.test.teststream;

import java.util.concurrent.*;

/**
 * @author ：wujie
 * @date ：Created in 2019/11/1 11:42
 * @description：测试线程池关闭
 * @version: 1.0.0
 */
public class TestExcutors {
    public static void main(String[] args) throws InterruptedException {
       ThreadPoolExecutor executorService = (ThreadPoolExecutor)Executors.newFixedThreadPool(2);

        executorService.setKeepAliveTime(2, TimeUnit.SECONDS);
        executorService.allowCoreThreadTimeOut(true);
        Thread.sleep(3000);
        Future<?> submit = executorService.submit(() -> {
            try {
                Thread.sleep(3000);
                System.out.println("2333");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //System.out.println("x");

        });
        try {
            System.out.println("输出："+submit.get());
        } catch (InterruptedException e) {


        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
