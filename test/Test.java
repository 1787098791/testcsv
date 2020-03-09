import com.freedom.test.testcustom.Custom;
import com.freedom.test.teststream.TestStreamCount;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ：wujie
 * @date ：Created in 2019/11/9 13:54
 * @description：
 * @version:
 */
public class Test {

    @org.junit.Test
   public void  test() throws InterruptedException {
        //AtomicInteger sum=new AtomicInteger();
        List<String> list = new ArrayList<>();
        Custom custom = new Custom();
       /* for (int i=0;i<1000;i++){
            list.add("1");
        }*/
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i=0;i<1000;i++){
            executorService.submit(new Runnable() {

                @Override
                public void run() {
                    synchronized (this){
                        double money = custom.getMoney();
                        custom.setMoney(money+1);
                    }


                }
            });
        }
        Thread.sleep(15000);
        System.out.println(custom.getMoney());

    }
}
