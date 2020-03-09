package com.freedom.test.testregex;

/**
 * @author ：wujie
 * @date ：Created in 2019/11/4 16:29
 * @description：测试2
 * @version: 1.0.0
 */
public class TestRegex2 {
    private static String regex="[a-zA-Z]{4}";
    public static void main(String[] args) {
        String str="abcdu";
        boolean matches = str.matches(regex);
        System.out.println(matches);
        String s = str.replaceAll(regex, "");
        System.out.println(s);
    }
}
