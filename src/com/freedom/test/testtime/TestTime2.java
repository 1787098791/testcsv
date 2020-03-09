package com.freedom.test.testtime;

import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author ：wujie
 * @date ：Created in 2019/11/8 16:03
 * @description：
 * @version:
 */
public class TestTime2 {
    public static void main(String[] args) {
        /*Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY,0 );
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        System.out.println(calendar.getTime());
        String exchange = TestTime.exchange(calendar.getTime());
        System.out.println(exchange);*/

        int a=10;
        int b=40;
        Integer a1 = Integer.valueOf(a);
        Integer b1 = Integer.valueOf(b);
        System.out.println(a1.doubleValue()/b1.doubleValue());
        NumberFormat num = NumberFormat.getPercentInstance();
        //num.setMinimumFractionDigits(3);
        /*num.setMaximumIntegerDigits(3);
        num.setMaximumFractionDigits(3);*/
        double csdn = 0.20;

        System.out.println(num.format(a1.doubleValue()/b1.doubleValue()));

    }
}
