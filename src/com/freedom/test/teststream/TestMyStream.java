package com.freedom.test.teststream;

import com.freedom.test.testxstream.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author ：wujie
 * @date ：Created in 2020/2/2 18:49
 * @description：
 * @version:
 */
public class TestMyStream {

    public static void main(String[] args) {
        //创建流
        Stream<String> stringStream = Stream.of("1", "2", "3", "4", "5");
        //stringStream.forEach(System.out::println);  ::形式可以和lambda表达式转换
        stringStream.forEach(x->{
            System.out.println(x);
        });
        //输出：
        //1
        //2
        //3
        //4
        //5
        Stream<Integer> integerStream = Stream.iterate(0, x -> (x + 2)).limit(5);
        integerStream.forEach(x->{
            System.out.println(x);
        });
        //输出：
        //0
        //2
        //4
        //6
        //8

        Stream<Double> randomStream = Stream.generate(() -> {
            return Math.random();
        }).limit(10);
        randomStream.forEach(x->{
            System.out.println(x);
        });
        //输出
        //0.6666734975461155
        //0.6829343635716331
        //0.4175225763052117
        //0.8022433663723608
        //0.13711196119900237
        //0.21429059488342006
        //0.42948185375321324
        //0.6637041154841395
        //0.8496457433513107
        //0.4439239571058863


        //Stream的遍历
        Person person = new Person("xiaoming", 20, "man");
        Person personTwo = new Person("xiaohong", 21, "man");
        Person personThree = new Person("xiaobai", 22, "man");
        Person personFour = new Person("xiaohei", 23, "man");
        Person personFive = new Person("xiaolan", 24, "man");
        ArrayList<Person> list = new ArrayList<>();
        list.add(person);
        list.add(personTwo);
        list.add(personThree);
        list.add(personFour);
        list.add(personFive);
        //遍历
        list.stream().forEach(x->{
            System.out.println(x);
        });
        //输出
        //Person{name='xiaoming', age=20, gender='man'}
        //Person{name='xiaohong', age=21, gender='man'}
        //Person{name='xiaobai', age=22, gender='man'}
        //Person{name='xiaohei', age=23, gender='man'}
        //Person{name='xiaolan', age=24, gender='man'}



        //*****foreach和map相比，foreach不会创建新的集合，而map会创建(返回)新的集合*******


        //映射
        //map：接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。(元素经过映射元素仍然是保持单个个体)
        //flatMap：接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流。(所有元素经过映射后成为一个新的流)
        List<Object> womens = list.stream().map(x -> {
             x.setGender("women");
             return x;
        }).collect(Collectors.toList());
        womens.stream().forEach(x->{
            System.out.println("map映射："+x);
        });
        System.out.println(list);


        List<Person> womensTwo = list.stream().flatMap(x -> {
            x.setGender("women");
            ArrayList<Person> objects = new ArrayList<>();
            objects.add(x);
            //返回的是流
            return objects.stream();
        }).collect(Collectors.toList());
        womensTwo.stream().forEach(x->{
            System.out.println("flatMap映射："+x);
        });
        //输出
        //map映射：Person{name='xiaoming', age=20, gender='women'}
        //map映射：Person{name='xiaohong', age=21, gender='women'}
        //map映射：Person{name='xiaobai', age=22, gender='women'}
        //map映射：Person{name='xiaohei', age=23, gender='women'}
        //map映射：Person{name='xiaolan', age=24, gender='women'}
//[Person{name='xiaoming', age=20, gender='women'}, Person{name='xiaohong', age=21, gender='women'}, Person{name='xiaobai', age=22, gender='women'}, Person{name='xiaohei', age=23, gender='women'}, Person{name='xiaolan', age=24, gender='women'}]
        //flatMap映射：Person{name='xiaoming', age=20, gender='women'}
        //flatMap映射：Person{name='xiaohong', age=21, gender='women'}
        //flatMap映射：Person{name='xiaobai', age=22, gender='women'}
        //flatMap映射：Person{name='xiaohei', age=23, gender='women'}
        //flatMap映射：Person{name='xiaolan', age=24, gender='women'}


        //过滤 相当于sql中的where

        //1.过滤获取满足条件的第一个数据
        Person xiaobai = list.stream().filter(x -> {
            return x.getName().equalsIgnoreCase("xiaobai");
        }).findFirst().get();

        System.out.println(xiaobai);
        //输出
        //Person{name='xiaobai', age=22, gender='man'}

        //2.过滤配合orElse ,获取name为saber的没有则返回personThree对象
        //调用Person的构造函数时会执行System.out.println(2333333);
        //******orElse和orElseGet比较，orElse无论是否存在目标对象，都会执行orElse里的代码******
        Person xiaobaiTwo = list.stream().filter(x -> {
            return x.getName().equalsIgnoreCase("xiaobai");
        }).findFirst().orElse(new Person("lancer",20,"man"));

        System.out.println(xiaobaiTwo);
        //输出
        //2333333
        //Person{name='xiaobai', age=22, gender='man'}


        //3.过滤配合orElseGet ,获取name为saber的没有则返回personThree对象
        Person saber = list.stream().filter(x -> {
            return x.getName().equalsIgnoreCase("xiaobai");
        }).findFirst().orElseGet(() -> {
            System.out.println("2333333");
            return personThree;
        });

        System.out.println(saber);
        //输出
        //Person{name='xiaobai', age=22, gender='man'}



        //stream将list转map
        //Collectors.toMap(Person::getName, x -> x, (x1, x2) -> x2)参数解释：
        //第一个参数表示取Person类的name属性作为键
        //第二个参数表示将此对象作为map的值
        //第三个参数表示当遇到同key时选择哪一个，x1代表已经存在的x2代表新增的
        list.add(new Person("xiaohong",22,"man"));
        Map<String, Person> collect = list.stream().collect(Collectors.toMap(Person::getName, x -> x, (x1, x2) -> x2));
        System.out.println("list转map: "+collect);
        //输出
        //list转map: {xiaohong=Person{name='xiaohong', age=22, gender='man'},
        // xiaoming=Person{name='xiaoming', age=20, gender='women'},
        // xiaobai=Person{name='xiaobai', age=22, gender='women'},
        // xiaolan=Person{name='xiaolan', age=24, gender='women'},
        //xiaohei=Person{name='xiaohei', age=23, gender='women'}}



        //stream将list分组：以某个属性为键，值则为多个元素组成的集合
        Map<String, List<Person>> maps = list.stream().collect(Collectors.groupingBy(x -> x.getName()));
        for (String key:maps.keySet()){
            System.out.println("list按name分组："+maps.get(key));
        }
        //输出
        //list按name分组：[Person{name='xiaohong', age=21, gender='women'}, Person{name='xiaohong', age=22, gender='man'}]
        //list按name分组：[Person{name='xiaoming', age=20, gender='women'}]
        //list按name分组：[Person{name='xiaobai', age=22, gender='women'}]
        //list按name分组：[Person{name='xiaolan', age=24, gender='women'}]
        //list按name分组：[Person{name='xiaohei', age=23, gender='women'}]


    }
}
