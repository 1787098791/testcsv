package com.freedom.test.teststream;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ：wujie
 * @date ：Created in 2019/11/1 15:06
 * @description：测试ForkJoinPool
 * @version: 1.0.0
 */
public class TestForkJoinPool extends RecursiveAction {
    //无返回值


    private Integer start;

    private Integer end;

    private Integer threshold=100;

    private static AtomicInteger sum=new AtomicInteger();

    public TestForkJoinPool() {
    }

    public TestForkJoinPool(Integer start, Integer end) {
        this.start = start;
        this.end = end;
    }

    public static void main(String[] args) throws Exception {
        ForkJoinPool forkJoinPool = new ForkJoinPool(10);
        TestForkJoinPool testForkJoinPool = new TestForkJoinPool(0, 10);
        ForkJoinTask<Void> result = forkJoinPool.submit(testForkJoinPool);
       /* ForkJoinTask<?> submit = forkJoinPool.submit(() -> {
            System.out.println("233333");
        });*/
        result.join();
        //submit.join();

        //awaitTermination此方法旨在设置主线程等待ForkJoinPool里的线程执行时间，到时间后在执行主线程
        //forkJoinPool.awaitTermination(10, TimeUnit.SECONDS);
        forkJoinPool.shutdown();
        while(!forkJoinPool.isTerminated()){

        }
        System.out.println(TestForkJoinPool.sum);

    }

    @Override
    protected void compute() {
      /*  try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
       /* try {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
        if ((end-start)<=threshold){

            for (int i=start;i<=end;i++){
               sum.addAndGet(i);
            }

        }else{
            //分割
            Integer middle=(start+end)/2;
            TestForkJoinPool leftFork = new TestForkJoinPool(start, middle);
            TestForkJoinPool rightFork = new TestForkJoinPool(middle+ 1, end);
            leftFork.fork();//执行
            rightFork.fork();//执行
        }
              
    }
}
