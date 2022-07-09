package com.eternal.leetcode.linked;

/**
 * @Auther Eternal
 * @Date 2022/7/3
 */
public class SortList {
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
    }

    /*
    * BM12 单链表的排序 ???
    * */
    public static ListNode sortInList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode left = head;
        ListNode mid = head.next;
        ListNode right = head.next.next;

        while (right != null && right.next != null) {
            left = left.next;
            mid = mid.next;
            right = right.next.next;
        }

        left.next = null;

        return merge(sortInList(head), sortInList(mid));
    }

    public static ListNode merge(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null) return pHead2;
        if (pHead2 == null) return pHead1;

        ListNode head = new ListNode(0);
        ListNode cur = head;

        while (pHead1 != null && pHead2 != null) {
            if (pHead1.val <= pHead2.val) {
                cur.next = pHead1;
                pHead1 = pHead1.next;
            } else {
                cur.next = pHead2;
                pHead2 = pHead2.next;
            }
            cur = cur.next;
        }

        if (pHead1 != null) cur.next = pHead1;
        else cur.next = pHead2;

        return head.next;
    }
}
