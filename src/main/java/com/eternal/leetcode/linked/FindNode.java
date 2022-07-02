package com.eternal.leetcode.linked;

/**
 * @Auther Eternal
 * @Date 2022/7/2
 */
public class FindNode {

    /*
    * BM8 链表中倒数最后k个结点
    * 快指针走k步，再与慢指针同步，当快指针null时，慢指针指向的就是倒数k个节点
    * */
    public static ListNode FindKthToTail(ListNode pHead, int k) {
        ListNode fast = pHead;
        ListNode slow = pHead;

        for (int i = 0; i < k; i++) {
            if (fast != null) fast = fast.next;
            else return slow = null;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

    /*
    * BM9 删除链表的倒数第n个节点
    * */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode res = new ListNode(-1);
        res.next = head;

        ListNode cur = head;
        ListNode pre = res;
        ListNode fast = head;

        while (n != 0) {
            fast = fast.next;
            n--;
        }

        while (fast != null) {
            fast = fast.next;
            pre = cur;
            cur = cur.next;
        }

        pre.next = cur.next;

        return res.next;
    }

    /*
    * BM10 两个链表的第一个公共结点
    * */
    public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int p1 = ListLength(pHead1);
        int p2 = ListLength(pHead2);

        if (p1 >= p2) {
            int n = p1 - p2;
            for (int i = 0; i < n; i++) {
                pHead1 = pHead1.next;
            }
            while ((pHead1 != null) && (pHead2 != null) && (pHead1 != pHead2)) {
                pHead1 = pHead1.next;
                pHead2 = pHead2.next;
            }
        } else {
            int n = p2 - p1;
            for (int i = 0; i < n; i++) {
                pHead1 = pHead1.next;
                pHead2 = pHead2.next;
            }
        }

        return pHead1;
    }

    public static int ListLength(ListNode pHead) {
        ListNode p = pHead;
        int n = 0;
        while(p != null) {
            n++;
            p = p.next;
        }
        return n;
    }


}
