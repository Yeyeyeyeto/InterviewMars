package com.eternal.leetcode.linked;

/**
 * @Auther Eternal
 * @Date 2022/7/2
 */
public class FindNode {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode v2 = new ListNode(2);
        ListNode v3 = new ListNode(3);
        ListNode v4 = new ListNode(4);
        ListNode v5 = new ListNode(5);
        head.next = v2;
        v2.next = v3;
        v3.next = v4;
        v4.next = v5;

//        FindKthToTail(head, 2).print();

        removeNthFromEnd(head, 2).print();
    }

    /*
    * BM8 链表中倒数最后k个结点
    * 快指针走k步，再与慢指针同步，当快指针null时，慢指针指向的就是倒数k个节点
    * 让快慢指针间隔k个结点
    * */
    public static ListNode FindKthToTail(ListNode pHead, int k) {
        ListNode fast = pHead;
        ListNode slow = pHead;

        // 快指针走k步
        for (int i = 0; i < k; i++) {
            if (fast != null) fast = fast.next;
            else return null;
        }

        // 同步走，快指针null时，慢指针指向的就是倒数第k个
        while(fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

    /*
    * BM9 删除链表的倒数第n个节点
    * 设定前序、当前、快指针。快指针搭配当前慢指针直到碰到n位置
    * 使用前序结点删除当前结点
    * */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // 表头
        ListNode res = new ListNode(-1);
        res.next = head;

        ListNode cur = head;
        ListNode pre = res;
        ListNode fast = head;

        // 快指针走n步
        while (n != 0) {
            fast = fast.next;
            n--;
        }

        // 快慢指针同步，快指针到末尾时，慢指针到倒数第n
        while (fast != null) {
            fast = fast.next;
            pre = cur;
            cur = cur.next;
        }

        // 删除该位置的节点
        pre.next = cur.next;

        return res.next;
    }

    /*
    * BM10 两个链表的第一个公共结点
    * 更长的链表先走之间的差值
    * */
    public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int p1 = ListLength(pHead1);
        int p2 = ListLength(pHead2);

        // 更长的链表，先走差步
        if (p1 > p2) {
            int n = p1 - p2;
            for (int i = 0; i < n; i++) {
                pHead1 = pHead1.next;
            }
        } else {
            int n = p2 - p1;
            for (int i = 0; i < n; i++) {
                pHead2 = pHead2.next;
            }
        }

        // 两个链表同时移动，到公共结点时停下
        while ((pHead1 != null) && (pHead2 != null) && (pHead1 != pHead2)) {
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }

        return pHead1;
    }

    // 返回链表长度
    public static int ListLength(ListNode pHead) {
        ListNode p = pHead;
        int n = 0;
        while (p != null) {
            n++;
            p = p.next;
        }
        return n;
    }


}
