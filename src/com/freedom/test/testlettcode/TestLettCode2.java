package com.freedom.test.testlettcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author ：wujie
 * @date ：Created in 2019/11/2 14:44
 * @description：测试2
 * @version: 1.0.0
 */
public class TestLettCode2 {
    //集合[1,2,3]+[2,3,4]输出3,5,7 因为321+432=753

    public static void main(String[] args) {
        /*List<Integer> list1 = Stream.of(1,2,3).collect(Collectors.toList());
        List<Integer> list2 = Stream.of(2,3,4).collect(Collectors.toList());*/
        //创建链表
        ListNode listNode1 = new ListNode(1);
        ListNode listNode12 = new ListNode(2);
        ListNode listNode13 = new ListNode(3);
        listNode1.setNext(listNode12);
        listNode12.setNext(listNode13);

        ListNode listNode2 = new ListNode(2);
        ListNode listNode22 = new ListNode(3);
        ListNode listNode23 = new ListNode(4);
        listNode2.setNext(listNode22);
        listNode22.setNext(listNode23);

        long s = System.currentTimeMillis();
        ListNode test = testListNode(listNode1, listNode2);
        long e = System.currentTimeMillis();
        ListNode myListNode;
        while(true){
            if ((myListNode=test.getNext())!=null){
                System.out.println(test.getBody());
                test=myListNode;
            }else {
                System.out.println(test.getBody());
            break;
            }
        }
    }

    //集合
    public static List test(List<Integer> list1,List<Integer> list2){
        Integer sum=0;
        Integer sum2=0;
     for (int i=list1.size()-1;i>=0;i--){
         double pow = Math.pow(10, i);
         sum+=new Double(list1.get(i)* pow).intValue();
     }
     for (int i=list2.size()-1;i>=0;i--){
            double pow = Math.pow(10, i);
            sum2+=new Double(list2.get(i)* pow).intValue();
     }
     Integer total=sum+sum2;
        String s = Integer.toString(total);
        String[] strs = s.split("");
        ArrayList<Object> list = new ArrayList<>();
        for (int i=strs.length-1;i>=0;i--){
            list.add(Integer.parseInt(strs[i]));
        }
        return list;

    }

    //链表
    public static ListNode testListNode(ListNode listNode1,ListNode listNode2){

        Integer total=sum(listNode1,0)+ sum(listNode2,0);
        String[] strs = Integer.toString(total).split("");

        ListNode listNodeTag=null;
        ListNode result=null;
        for (int i=0;i<strs.length;i++){

           ListNode listNode = new ListNode();
           listNode.setBody(Integer.parseInt(strs[i]));
           listNode.setNext(listNodeTag);
           listNodeTag=listNode;
           result=listNode;
        }
        return result;
    }

    //求和->递归
    private static Integer sum(ListNode listNode,Integer tag){
        if (listNode.getNext()==null){
            return new Double(Math.pow(10,tag)).intValue()*listNode.getBody();
        }
        Integer body = listNode.getBody();
        ListNode next = listNode.getNext();
        int sum = new Double(Math.pow(10, tag)).intValue()*body;
        tag++;
       return sum+sum(next,tag);
    }
}
