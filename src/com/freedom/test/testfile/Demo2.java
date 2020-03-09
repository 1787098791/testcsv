package com.freedom.test.testfile;

import au.com.bytecode.opencsv.CSVReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * @author ：wujie
 * @date ：Created in 2019/10/30 11:12
 * @description：opencsv
 * @version:
 */
public class Demo2 {
    private  static  String FILEPATH="c:\\code.csv";

    public static void main(String[] args) throws Exception {
        long startTime = System.currentTimeMillis();
        File csv = new File(FILEPATH);

        CSVReader reader = new CSVReader(new InputStreamReader(new FileInputStream(csv), "UTF-8"), ',');
        //用readnext读取之后就不存在于stream中了
        /*String [] header = reader.readNext();
        for (String s : header) {
            System.out.print(s + ",");
        }
        System.out.println("");*/

        List<String[]> list = reader.readAll(); //此时读取的已经是第二行了
        for (String[] strings:list){
            System.out.println(strings[0]);
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);
        /*System.out.println(list.get(0)[0]);
        System.out.println("");*/
    }
}
