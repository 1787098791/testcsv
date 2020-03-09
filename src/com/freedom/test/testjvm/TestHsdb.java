package com.freedom.test.testjvm;

import java.io.IOException;

/**
 * @author ：wujie
 * @date ：Created in 2020/1/18 12:08
 * @description：
 * @version:
 */
public class TestHsdb {

    public static void test(Animal animal) { animal.eat(); System.out.println(animal.toString()); }

    public static void main(String[] args) throws IOException {
        test(new Dog());
        System.in.read();//1348
    }
}

class Animal {

    public void eat(){
        System.out.println("animal eat...");
    }

}

class Dog extends Animal {
    @Override
    public void eat(){
        System.out.println("dog eat...");
    }
}
