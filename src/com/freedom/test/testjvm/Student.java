package com.freedom.test.testjvm;

/**
 * @author ：wujie
 * @date ：Created in 2019/12/26 11:43
 * @description：
 * @version:
 */
public class Student {

    static {
        System.out.println("Student加载。。。");
    }

    private String name;

    public String getName() {

        Dog dog = new Dog();
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
