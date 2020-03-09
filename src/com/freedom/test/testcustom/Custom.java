package com.freedom.test.testcustom;

/**
 * @author ：wujie
 * @date ：Created in 2019/11/9 20:46
 * @description：
 * @version:
 */
public class Custom {
    private double money;

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Custom{" +
                "money=" + money +
                '}';
    }
}
