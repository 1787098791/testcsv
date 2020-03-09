package com.freedom.test.testxstream;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;

/**
 * @author ：wujie
 * @date ：Created in 2019/11/26 15:47
 * @description：
 * @version:
 */
@XStreamAlias("xml")
public class Person implements Serializable {

    @XStreamAlias("Name")
    private String name;
    @XStreamAlias("Age")
    private Integer age;
    @XStreamAlias("Gender")
    private String gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Person() {
    }

    public Person(String name, Integer age, String gender) {
        System.out.println(2333333);
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
