package com.freedom.test.teststring;

import org.apache.commons.lang3.text.StrSubstitutor;

import java.util.HashMap;

/**
 * @author ：wujie
 * @date ：Created in 2019/11/13 17:18
 * @description：
 * @version:
 */
public class TestString {
    public static void main(String[] args) {
        String sql="select * from user where id=0 limit  ";
        sql = String.format(sql, 2, 2);
        System.out.println(sql);
    }
}
