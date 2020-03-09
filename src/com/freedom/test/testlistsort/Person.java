package com.freedom.test.testlistsort;

/**
 * @author ：wujie
 * @date ：Created in 2019/12/3 18:59
 * @description：
 * @version:
 */
public class Person {
    private String name;
    private String socer;

    public Person() {
    }

    public Person(String name, String socer) {
        this.name = name;
        this.socer = socer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSocer() {
        return socer;
    }

    public void setSocer(String socer) {
        this.socer = socer;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", socer='" + socer + '\'' +
                '}';
    }
}
