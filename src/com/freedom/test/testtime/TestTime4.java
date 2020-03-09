package com.freedom.test.testtime;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author ：wujie
 * @date ：Created in 2019/11/13 16:19
 * @description：
 * @version:
 */
public class TestTime4 {
    private static final String DATA="yyyy-MM-dd HH:mm:ss";


    public static void main(String[] args) {
        Date date = new Date();
        String dateZeroTime = getDateYesterdayNowTime(date);
        System.out.println(dateZeroTime);
    }
    /**
     * 日期格式转换
     * @param date 日期
     * @return string
     */
    public static String exchange(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATA);
        String dateStr = simpleDateFormat.format(date);
        return dateStr;
    }

    /**
     * 获取本周一的时间零点
     * @param date 当前时间
     * @return string
     */
    public static String getMondayDate(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MILLISECOND,0);
        System.out.println(calendar.getTime());
        Date time = calendar.getTime();
        String dateStr = exchange(time);
        return dateStr;
    }

    /**
     * 获取上周一的零点
     * @param date 日期
     * @return String
     */
    public static String getLastMondayDate(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);
        calendar.add(Calendar.DATE,-7);
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MILLISECOND,0);
        Date time = calendar.getTime();
        String dateStr = exchange(time);
        return dateStr;
    }

    /**
     * 获取上周对应的当前时间
     * @param date 日期
     * @return String
     */
    public static String getLastWeekNowTime(Date date){

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE,-7);
        date = calendar.getTime();
        String dateStr = exchange(date);
        return dateStr;
    }
    /**
     * 获取本月第一天 零点
     * @param date 日期
     * @return string
     */
    public static String getMonthFirstDay(Date date){

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH,1);
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MILLISECOND,0);
        date = calendar.getTime();
        String dateStr = exchange(date);
        return dateStr;
    }

    /**
     * 获取上个月一号的零点
     * @param date 日期
     * @return string
     */
    public static String getLastMonthFirstDay(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH,1);
        calendar.add(Calendar.MONTH,-1);
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MILLISECOND,0);
        date = calendar.getTime();
        String dateStr = exchange(date);

        return dateStr;
    }

    /**
     * 获取上个月的当前时间
     * @param date 日期
     * @return String
     */
    public static String getLastMonthNowTime(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH,-1);
        date = calendar.getTime();
        String dateStr = exchange(date);
        return dateStr;
    }

    /**
     * 秒转字符串
     * @param time 秒
     * @return  String
     */
    public static String getDateString(Long time){
        Date date = new Date(time*1000);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATA);
        String dateStr = simpleDateFormat.format(date);
        return dateStr;
    }

    /**
     * Long转本日零点Long
     * @param time 时间 秒
     * @return long 秒
     */
    public static Long getLongTime(Long time){
        Date date = new Date(time * 1000);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MILLISECOND,0);
        long timeZero = calendar.getTime().getTime();

        return timeZero/1000;
    }

    /**
     * 获取指定Date的零点时间 单位秒
     * @param date date
     * @return Long 秒
     */
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

    /**
     * 获取指定时间的零点时间
     * @param date 任意时间
     * @return String
     */
    public static String getDateZeroTime(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MILLISECOND,0);
        String dateStr = exchange(calendar.getTime());
        return dateStr;

    }

    /**
     * 获取指定时间前一天的零点时间
     * @param date 指定时间
     * @return string
     */
    public static String getDateYesterdayZeroTime(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MILLISECOND,0);
        calendar.add(Calendar.DATE,-1);
        String dateStr = exchange(calendar.getTime());
        return dateStr;
    }

    /**
     * 获取指定时间前一天的当前时间
     * @param date 指定时间
     * @return string
     */
    public static String getDateYesterdayNowTime(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE,-1);
        String dateStr = exchange(calendar.getTime());
        return dateStr;
    }


}
