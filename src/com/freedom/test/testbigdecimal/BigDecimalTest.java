package com.freedom.test.testbigdecimal;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @author ：wujie
 * @date ：Created in 2019/11/15 14:00
 * @description：
 * @version:
 */
public class BigDecimalTest {
    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal(276578954.00256);
        System.out.println(bigDecimal.toString());
        DecimalFormat decimalFormat = new DecimalFormat("0.0000");
        String format = decimalFormat.format(26549979.0000887);
        double d=1.0/10000;
        System.out.println(decimalFormat.format(1.0/10000));
    }
}
