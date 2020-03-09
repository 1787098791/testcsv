package com.freedom.test.teststringformat;

/**
 * @author ：wujie
 * @date ：Created in 2019/11/11 18:54
 * @description：
 * @version:
 */
public class TestFormat {

    public static void main(String[] args) {

        String sql="SELECT tb.`status`,UNIX_TIMESTAMP(tb.`real_start_time`),UNIX_TIMESTAMP(tb.`real_end_time`)\n" +
                "FROM ac_activity tb\n" +
                "WHERE tb.dr=0 AND tb.`id`='03b08d4e58450e9c8f0f811c29231247' AND tb.`type`=%d LIMIT 1";

        String format = String.format(sql, 3);
        System.out.println(format);
    }
}
