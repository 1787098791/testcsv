package com.freedom.test.testxstream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * @author ：wujie
 * @date ：Created in 2019/11/26 15:49
 * @description：
 * @version:
 */
public class TestBeanToXml {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("小明");
        person.setAge(20);
        person.setGender("男");
        XStream xStream = new XStream();
        //开启注解读取（默认关闭）
        xStream.autodetectAnnotations(true);
        String s = xStream.toXML(person);
        System.out.println(s);
        XStream xStream2 = new XStream(new DomDriver());
        xStream2.processAnnotations(Person.class);
        Object o = xStream2.fromXML(s);
        if (o instanceof Person){
            System.out.println((Person)o);
        }

    }
}
