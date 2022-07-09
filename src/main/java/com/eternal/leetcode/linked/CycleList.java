package com.eternal.leetcode.linked;

/**
 * @Auther Eternal
 * @Date 2022/7/2
 */
public class CycleList {

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

        System.out.println(hasCycle(head));
    }

    /*
    * BM6 判断链表中是否有环
     * */
    public static boolean hasCycle(ListNode head) {
        if (head == null) return false;

        // 快慢指针
        ListNode slow = head.next;
        ListNode fast = head.next.next;

        // 没环则退出
        while (fast != null && fast.next != null) {
            // 快走2，慢走1
            fast = fast.next.next;
            slow = slow.next;
            // 相遇则有环
            if (fast == slow) return true;
        }

        return false;
    }

    /*
     * BM7 链表中环的入口结点
     * 获得相遇结点 - 快指针回到开头 - 同步走相遇则是入口结点
     */
    public static ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode slow = hasCycle2(pHead);
        if (slow == null) return null;

        // 快指针回开头
        ListNode fast = pHead;

        // 再次相遇则是环入口
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
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
            // 返回相遇的位置
            if (fast == slow) return slow;
        }

        return null;
    }

}
