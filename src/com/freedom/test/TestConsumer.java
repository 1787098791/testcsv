package com.freedom.test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.util.Base64;
import java.util.function.Consumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author ：wujie
 * @date ：Created in 2019/12/9 18:42
 * @description：
 * @version:
 */
public class TestConsumer {
    public static void main(String[] args) throws UnsupportedEncodingException {
        /*String str="12345";
        test(x->x.substring(1,2));
        System.out.println(str);*/

        /*String str="12345";
        System.out.println(str.indexOf("8"));*/
        String tmpDir = System.getProperty("user.dir");
        System.out.println(tmpDir);
        /*Stream<Integer> limit = Stream.iterate(0, x -> x + 1).limit(10);
        System.out.println(limit.collect(Collectors.toList()));*/
        /*String str="123456";
        Base64.Encoder encoder = Base64.getEncoder();
        byte[] encode = encoder.encode(str.getBytes("utf-8"));
        System.out.println(new String(encode,"utf-8"));
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decode = decoder.decode(encode);
        System.out.println(new String(decode,"utf-8"));*/
        String text = "base64 in java8 lib";
        //编码
        String encode = Base64.getEncoder()
                .encodeToString(text.getBytes(StandardCharsets.UTF_8));
        System.out.println(encode);

        //解码
        String decode = new String(Base64.getDecoder().decode(encode), StandardCharsets.UTF_8);
        System.out.println(decode);


    }

    public  static void test(Consumer<String> str){
        if(str!=null){
            str.accept("233333");
        }

    }
}
