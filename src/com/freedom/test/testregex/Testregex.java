package com.freedom.test.testregex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ：wujie
 * @date ：Created in 2019/11/4 12:56
 * @description：测试
 * @version: 1.0.0
 */
public class Testregex {
    private static String STR="srttyy ssr jdk cdfg jbc";
    public static void main(String[] args) {
        Pattern compile = Pattern.compile("\\b[a-zA-Z]{3}\\b");
        Matcher matcher = compile.matcher(STR);
        while (matcher.find()){
            System.out.println(matcher.start()+":"+matcher.group()+":"+matcher.end());
        }


    }
}
