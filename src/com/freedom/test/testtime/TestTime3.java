package com.freedom.test.testtime;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author ：wujie
 * @date ：Created in 2019/11/11 11:23
 * @description：
 * @version:
 */
public class TestTime3 {
    public static void main(String[] args) {
//        Calendar calendar = Calendar.getInstance();
//        Date date = new Date();
//        calendar.setTime(date);
//        calendar.set(Calendar.HOUR_OF_DAY,0);
//        calendar.set(Calendar.MINUTE,0);
//        calendar.set(Calendar.SECOND,0);
//        calendar.set(Calendar.MILLISECOND,0);
//       // calendar.add(Calendar.DATE,1);
//        //转为秒
//        long time = calendar.getTime().getTime()/1000;
//        Date date1 = new Date(time * 1000);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String format = simpleDateFormat.format(date1);
//        System.out.println(format);
//
//        System.out.println(time);

        System.out.println(getNowLongTime(new Date()));

    }

    public static Long getNowLongTime(Date date){

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MILLISECOND,0);
        Date nowDate = calendar.getTime();
        return nowDate.getTime()/1000;
    }
}
