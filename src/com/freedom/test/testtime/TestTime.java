package com.freedom.test.testtime;

import sun.awt.geom.AreaOp;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author ：wujie
 * @date ：Created in 2019/11/8 14:49
 * @description：测试时间
 * @version:
 */
public class TestTime {

    private static final String DATA="yyyy-MM-dd HH:mm:ss";
    public static void main(String[] args) {
        Date date = new Date();
        String dateZeroTime = getDateZeroTime(date);
        System.out.println(dateZeroTime);
        String dateYesterdayZeroTime = getDateYesterdayZeroTime(date);
        System.out.println(dateYesterdayZeroTime);
        String dateYesterdayNowTime = getDateYesterdayNowTime(date);
        System.out.println(dateYesterdayNowTime);
     /*   System.out.println("当前时间： "+exchange(date));
        String mondayDate = getMondayDate(date);
        System.out.println("本周一零点： "+mondayDate);
        String lastMondayDate = getLastWeekNowTime(date);
        System.out.println("上周对应当前时间： "+lastMondayDate);
        String lastMondayDate1 = getLastMondayDate(date);
        System.out.println("上周一零点： "+lastMondayDate1);
        String monthFirstDay = getMonthFirstDay(date);
        System.out.println("本月第一天零点： "+monthFirstDay);
        String lastMonthNowTime = getLastMonthNowTime(date);
        System.out.println("上月当前时间：  "+lastMonthNowTime);
        String lastMonthFirstDay = getLastMonthFirstDay(date);
        System.out.println("上个月第一天零点：  "+lastMonthFirstDay);*/


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

    public static String getDateZeroTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        String dateStr = exchange(calendar.getTime());
        return dateStr;
    }

    /**
     * 获取指定时间前一天的零点时间
     *
     * @param date 指定时间
     * @return string
     */
    public static String getDateYesterdayZeroTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.add(Calendar.DATE, -1);
        String dateStr = exchange(calendar.getTime());
        return dateStr;
    }

    /**
     * 获取指定时间前一天的当前时间
     *
     * @param date 指定时间
     * @return string
     */
    public static String getDateYesterdayNowTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, -1);
        String dateStr = exchange(calendar.getTime());
        return dateStr;
    }


}
