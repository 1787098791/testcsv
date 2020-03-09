package com.freedom.test.testlettcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.*;

/**
 * @author ：wujie
 * @date ：Created in 2019/11/1 19:17
 * @description：test
 * @version: 1.0.0
 */
public class TestLettCode {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        long s = System.currentTimeMillis();
        String test = hash(ints, 19);
        long e = System.currentTimeMillis();
        System.out.println(e-s);
        System.out.println(test);
    }

    public static String test(int[] arr,int target) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(100);
        String rstr=null;
        for (int i=0;i<arr.length-1;i++){
             //这里的 n jdk1.8后不需要加final修饰
             int n=i;
            Future<String> submit = executorService.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    String str = null;
                    for (int m = n; m < arr.length; m++) {
                        if (arr[n] + arr[m] == target) {
                            str = arr[n] + "  " + arr[m];
                            break;
                        }
                    }
                    return str;
                }
            });
            rstr= submit.get();
            if(rstr!=null){
            break;
            }
        }
        executorService.shutdown();
        while(!executorService.isTerminated()){
        }
      return rstr;
    }

    public static String hash(int[] arr,int target){
        //数组元素不重复的情况
        HashMap<Object, Object> hashMap = new HashMap<>();
        int j=0;
        for (int i=0;i<arr.length;i++){
            j=target-arr[i];
            //以元素值为键
            if (hashMap.containsKey(j)){
                //返回脚标
               return hashMap.get(j)+"  "+i;
            }
            hashMap.put(arr[i],i);
        }
        return null;

    }
}
