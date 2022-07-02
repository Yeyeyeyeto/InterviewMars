package com.eternal.leetcode.linked;

/**
 * @Auther Eternal
 * @Date 2022/7/2
 */
public class CycleList {

    public static void main(String[] args) {

    }

    /*
    * BM6 判断链表中是否有环
     * */
    public static boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode fast = head.next.next;
        ListNode slow = head.next;

        while (fast != null && fast != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }

        return false;
    }

    /*
     * BM7 链表中环的入口结点
     */
    public static ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode slow = hasCycle2(pHead);
        if (slow == null) return null;

        ListNode fast = pHead;

        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

    public static ListNode hasCycle2(ListNode head) {
        if (head == null) return null;

        ListNode fast = head.next.next;
        ListNode slow = head.next;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return slow;
        }

        return null;
    }

}
