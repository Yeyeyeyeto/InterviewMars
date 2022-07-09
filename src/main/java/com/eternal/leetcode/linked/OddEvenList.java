package com.eternal.leetcode.linked;

/**
 * @Auther Eternal
 * @Date 2022/7/4
 */
public class OddEvenList {

    /*
    * BM14 链表的奇偶重排
    * 隔开排即可
    * */
    public static ListNode oddEvenList(ListNode head) {
        if (head == null) return null;

        // even 开头指向第二个节点，可能为空
        ListNode even = head.next;
        // ood 开头指向第一个节点
        ListNode odd = head;
        // 指向even开头
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            // ood连接even的后一个，即奇数位
            odd.next = even.next;
            // odd进入后一个奇数位
            odd = odd.next;
            // even连接后一个奇数的后一位，即偶数位
            even.next = odd.next;
            // even进入后一个偶数位
            even = even.next;
        }

        // even整体接在odd后面
        odd.next = evenHead;

        return head;
    }

}
