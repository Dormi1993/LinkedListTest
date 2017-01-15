package com.dlut.data.struct.linkedlist;

/**
 * Created by dormi.fu on 2016/12/1.
 */
public class LinkedList {
    /**
     * 根据一个数组，创建链表
     *
     * @param arr
     * @return
     */
    public ListNode create(int[] arr){
        //判断输入是否合法
        if (arr == null || arr.length == 0){
            return null;
        }
        ListNode head = null;
        ListNode tail = null;
        for (int i : arr){
            ListNode cur = new ListNode(i);//有问题
            if (head == null){
                head = cur;
                tail = cur;
            } else {
                tail.next = cur;
                tail = cur;
            }
        }
        return head;
    }

    /**
     * 打印一个链表
     * @param head
     */
    public void print(ListNode head){
        ListNode p = head;
        while (p != null){
            System.out.print(p.value + "->");
            p = p.next;
        }
        System.out.print("null");
    }

    public static void main(String[] args){
        LinkedList test = new LinkedList();
        ListNode head = test.create(new int[] { 1, 2, 3 });
        test.print(head);
    }
}
