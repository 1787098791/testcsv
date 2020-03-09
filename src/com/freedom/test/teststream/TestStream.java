package com.freedom.test.teststream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author ：wujie
 * @date ：Created in 2019/10/31 14:15
 * @description：流的有关操作
 * @version: 1.0.0
 */
public class TestStream {
    public static void main(String[] args) {
        /*Stream<Integer> limit = Stream.iterate(3, x -> (x * 2)).limit(5);
        limit.forEach(x-> System.out.println(x));*/
       /* Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
        integerStream.forEach(System.out::println);*/

        List<String> strings = Arrays.asList("a,b,c", "d,e,f");
        Stream<String> stream = strings.stream();
        //每个流只能操作一次
       // stream.forEach(System.out::println);
        //使用map
        //使用map是对每个元素操作，返回到流的时候仍旧是一个元素,如字符串"a,b,c"切割后返回一个字符串数组
        Stream<String[]> stream1 = stream.map(x ->
        {
            String[] split = x.split(",");
            return split;
        });
        List<String[]> collect = stream1.collect(Collectors.toList());
        System.out.println();

        //使用flatmap返回的是一个流
        /*Stream<String> objectStream = stream.flatMap(x -> {
            //"a,b,c"和"d,e,f" 返回各个流并组成新的流
            String[] split = x.split(",");
            Stream<String> stream1 = Arrays.stream(split);
            return stream1;
        });
        objectStream.forEach(System.out::println);*/

        Student student1 = new Student("xiaoming", 20, "男");
        Student student2 = new Student("xiaohong", 21, "女");
        Student student3 = new Student("xiaobai", 22, "男");
        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        //转换为流
        /*List<Student> collect = students.stream().peek(x -> x.setAge(100)).collect(Collectors.toList());
        Stream<Student> stream = collect.stream();
        stream.forEach(System.out::println);*/

        //此时的filter相当于where,类似于条件查询
        /*List<Student> collect = students.stream().filter(x ->

                "xiaobai".equalsIgnoreCase(x.getName())).collect(Collectors.toList());
        System.out.println(collect);*/
        Stream<Student> studentStream = students.stream().filter(x -> "xiaobai".equalsIgnoreCase(x.getName()));

    }
}
