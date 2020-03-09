package com.freedom.test.testchange;

import java.text.NumberFormat;

/**
 * @author ：wujie
 * @date ：Created in 2019/11/9 21:52
 * @description：
 * @version:
 */
public class TestChange {
    public static void main(String[] args) {
        NumberFormat num = NumberFormat.getPercentInstance();

        //num.setMinimumFractionDigits(3);
        num.setMaximumIntegerDigits(3);
        String format = num.format(1.0 / 4.0);
        System.out.println(format);

        // double v = a.doubleValue();
    }
}
