package com.eternal.leetcode.linked;

/**
 * @Auther Eternal
 * @Date 2022/7/4
 */
public class IsPailList {

    /*
    * BM13 判断一个链表是否为回文结构
    * 双指针找中点法
    * */
    public static boolean isPail(ListNode head) {
        // 空链表则直接为回文
        if (head == null) return true;

        // 准备快慢指针
        ListNode slow = head;
        ListNode fast = head;

        // 双指针找中点
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 中点处反转
        slow = reverse(slow);
        fast = head;
        while (slow != null) {
            // 比较判断节点值是否相等
            if (slow .val != fast.val) return false;
            fast = fast.next;
            slow = slow.next;
        }

        return true;
    }

    // 反转链表
    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

}
