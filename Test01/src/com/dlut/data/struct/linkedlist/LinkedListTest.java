package com.dlut.data.struct.linkedlist;

import java.util.Scanner;

public class LinkedListTest {
    /**
     * 创建1 从输入流读数据 正序创建
     */
    private static Scanner sc = new Scanner(System.in);

    public static ListNode create1() {
        ListNode head = null, tail = null;
        int value = sc.nextInt();
        while (value > 0) {
            ListNode temp = new ListNode(value);
            if (head == null) {
                head = temp;
                tail = temp;
            } else {
                tail.next = temp;
                tail = temp;
            }
            value = sc.nextInt();
        }
        return head;
    }

    /**
     * 创建2 从数组倒叙创建正序链表
     */
    public static ListNode create2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        ListNode head = null;
        for (int i = arr.length - 1; i >= 0; i--) {
            ListNode temp = new ListNode(arr[i]);
            temp.next = head;
            head = temp;
        }
        return head;
    }

    /**
     * 创建3 从数组正序创建正序链表
     * 
     * @param arr
     * @return
     */
    public static ListNode create3(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        ListNode head = null, tail = null;
        for (int a : arr) {
            ListNode temp = new ListNode(a);
            if (head == null) {
                head = temp;
                tail = temp;
            } else {
                tail.next = temp;
                tail = temp;
            }
        }
        return head;
    }

    /**
     * 在第index个位置插入节点 listHead=1→2→3 index=3 newValue=9 得到1→2→9→3
     * 
     * @param index
     *            从1开始的
     */
    public static void add1(ListNode listHead, int index, int newValue) {
        if (index < 1) {
            System.err.println("index参数太小" + index);
            return;
        }
        ListNode p = listHead;
        ListNode tail = null;
        int count = 1;
        while (p != null) {
            if (count == index) {
                ListNode temp = new ListNode(p.value);
                temp.next = p.next;
                p.next = temp;
                p.value = newValue;
                return;


            }
            count++;
            tail = p;
            p = p.next;
        }
        ListNode temp = new ListNode(newValue);
        tail.next = temp;
        System.out.println("index太大，给挂结尾了" + index);
    }

    /**
     * 在倒数第lastIndex个位置插入新节点 listHead=1→2→3 lastIndex=3 newValue=9 得到9→1→2→3
     * 
     * @param listHead
     * @param lastIndex
     * @param newValue
     */
    public static void add2(ListNode listHead, int lastIndex, int newValue) {
        if (lastIndex < 1) {
            return;
        }
        ListNode p = listHead;
        ListNode target = null;
        int count = 1;
        while (p != null) {
            if (count >= lastIndex) {
                if (target == null)
                    target = listHead;
                else
                    target = target.next;
            }
            count++;
            p = p.next;
        }
        if (target != null) {
            ListNode temp = new ListNode(target.value);
            temp.next = target.next;
            target.next = temp;
            target.value = newValue;
        } else {
            System.out.println("失败");
        }
    }

    /**
     * 反转
     * 
     * @return
     */
    public static ListNode reverse(ListNode listHead) {
        if (listHead == null || listHead.next == null) {
            return listHead;
        }
        ListNode p1 = listHead;
        ListNode p2 = p1.next;
        ListNode p3 = p2.next;

        p1.next = null;// 不先置为空 就完犊子了
        while (p3 != null) {
            p2.next = p1;
            p1 = p2;
            p2 = p3;
            p3 = p3.next;
        }
        p2.next = p1;
        return p2;
    }

    /**
     * 2个升序的合并，去重复
     */
    public static ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode head = null, tail = null;
        while (p1 != null || p2 != null) {
            ListNode temp = null;
            if (p2 != null && (p1.value > p2.value || p1 == null)) {
                temp = new ListNode(p2.value);
                p2 = p2.next;
            } else if (p1 != null && (p1.value < p2.value || p2 == null)) {
                temp = new ListNode(p1.value);
                p1 = p1.next;
            } else if (p1 != null && p2 != null && p1.value == p2.value) {
                temp = new ListNode(p1.value);
                p1 = p1.next;
                p2 = p2.next;
            }
            if (head == null) {
                head = temp;
                tail = temp;
            } else {
                tail.next = temp;
                tail = temp;
            }
        }

        return head;
    }

    /**
     * 找到环的起点
     * 
     * @return
     */
    public static boolean findCircle(ListNode list) {
        if (list == null || list.next == null || list.next.next == null) {
            return false;
        }
        ListNode p1 = list;
        ListNode p2 = list;
        while (p1 != null && p2 != null) {
            if (p1 == p2 && p1 != list) {
                return true;
            } else {
                if (p1.next == null) {
                    return false;
                }
                p1 = p1.next;
                if (p2.next == null || p2.next.next == null) {
                    return false;
                }
                p2 = p2.next.next;
            }
        }
        return false;
    }

    public static void print(ListNode listHead) {
        ListNode p = listHead;
        while (p != null) {
            System.out.print(p.value);
            if (p.next != null) {
                System.out.print(" → ");
            }
            p = p.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // ListNode list1 = LinkedListTest.create1();
        // LinkedListTest.print(list1);
        // ListNode list2 = LinkedListTest.create2(new int[]{1,2,3});
        // LinkedListTest.print(list2);

        int[] arp = new int[4];
        ListNode list = LinkedListTest.create2(new int[] {2, 5, 3});

        LinkedListTest.add1(list, 2, 12);
        LinkedListTest.print(list);

        ListNode list3 = LinkedListTest.create2(new int[] {3, 5, 7, 2});
//        LinkedListTest.print(list3);
//        LinkedListTest.add2(list3, 1, 9);
//        LinkedListTest.print(list3);
//
        ListNode newHead = LinkedListTest.reverse(list3);
        LinkedListTest.print(newHead);
//
//        ListNode bigList = LinkedListTest.merge(LinkedListTest.create2(new int[] { 1, 2, 3, 5, 7, 8 }),
//                LinkedListTest.create2(new int[] { 2, 4, 7, 8 }));
//        LinkedListTest.print(bigList);
//

        ListNode circle = new ListNode(1);
        circle.next = new ListNode(2);
        circle.next.next = new ListNode(3);
        circle.next.next.next = circle.next;
        boolean findCircle = LinkedListTest.findCircle(circle);
        if (findCircle) {
            System.out.println("有环");
        } else {
            System.out.println("没环");
        }
    }
}
