package com.freedom.test.testfile;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

/**
 * @author ：wujie
 * @date ：Created in 2019/10/30 10:26
 * @description：测试csv
 * @version: 1.0.0
 */
public class Demo1 {

    private  static  String FILEPATH="c:\\code.csv";
    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
        File file = new File(FILEPATH);
        List<String> lines = Files.readAllLines(file.toPath(),
                StandardCharsets.UTF_8);

        //System.out.println(lines);
        for (String line : lines) {
            System.out.println(line);
            String[] array = line.split(",");
            System.out.println(array[0]);
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);

    }
}
