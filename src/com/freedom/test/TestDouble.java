package com.freedom.test;

import com.freedom.test.testlistsort.Person;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.function.Supplier;

/**
 * @author ：wujie
 * @date ：Created in 2019/11/26 20:12
 * @description：
 * @version:
 */
public class TestDouble {
    public static void main(String[] args) throws Exception {
        /*BigDecimal bigDecimal = new BigDecimal("0.08");
        BigDecimal bigDecimal2 = new BigDecimal("0.08");
        bigDecimal = bigDecimal.add(bigDecimal2);
        BigDecimal bigDecimal3 = BigDecimal.valueOf(0.08);
        BigDecimal bigDecimal4 = BigDecimal.valueOf(0.09);
        System.out.println(bigDecimal3.add(bigDecimal4));*/
        /*System.out.println(200.0008+0.01);
        System.out.println(0.01+0.06);
        System.out.println("\\");*/
        /*System.out.println(1.0-0.42);
        System.out.println(4.015*100);
        System.out.println(123.3/100);*/
        /*File file = new File("D:/用户目录/下载/学生花名册.xls");
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] b=new byte[1024];
        int len=0;
        while((len=fileInputStream.read(b))!=-1){
            System.out.println(new String(b,0,len));
        }*/
        Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                return null;
            }
        };
        System.out.println(supplier);

    }
}
