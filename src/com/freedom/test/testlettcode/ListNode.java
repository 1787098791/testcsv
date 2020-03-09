package com.freedom.test.testlettcode;

import java.io.Serializable;

/**
 * @author ：wujie
 * @date ：Created in 2019/11/2 15:24
 * @description：自定义单向链表
 * @version: 1.0.0
 */
public class ListNode implements Serializable {
    /**
     * 数据体
     */
    private Integer body;

    /**
     * 下个元素的索引
     */
    private ListNode next;

    public Integer getBody() {
        return body;
    }

    public void setBody(Integer body) {
        this.body = body;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public ListNode() {
    }

    public ListNode(Integer body) {
        this.body = body;
    }

    public ListNode(Integer body, ListNode next) {
        this.body = body;
        this.next = next;
    }
}
