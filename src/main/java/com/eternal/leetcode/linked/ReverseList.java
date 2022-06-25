package com.eternal.leetcode.linked;

/**
 * @Auther Eternal
 * @Date 2022/6/25
 * 反转链表:
 * 1. 定义临时变量存储当前的下一个
 * 2. 令当前的下一个为前一个（相当于反转链接箭头）
 * 3. 令前指针指向当前位置
 * 4. 当前指针移动到下一位（用到1中的临时变量）
 */
public class ReverseList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode v2 = new ListNode(2);
        ListNode v3 = new ListNode(3);
        ListNode v4 = new ListNode(4);
        ListNode v5 = new ListNode(5);
        ListNode v6 = new ListNode(6);
        head.next = v2;
        v2.next = v3;
        v3.next = v4;
        v4.next = v5;
        v5.next = v6;

        head.print();

        reverseList(head).print();
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null) return null;

        ListNode cur = head;
        ListNode pre = null;

        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

        return pre;
    }
}


