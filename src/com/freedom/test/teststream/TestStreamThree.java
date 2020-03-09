package com.freedom.test.teststream;

import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author ：wujie
 * @date ：Created in 2019/11/1 16:10
 * @description：测试并行流的阻塞
 * @version: 1.0.0
 */
public class TestStreamThree {
    public static void main(String[] args) {
        Stream<Integer> limit = Stream.iterate(1, x -> x + 1).limit(100);
        limit.collect(Collectors.toList()).parallelStream().forEach(x->{
            System.out.println(x);

        });

    }
}
