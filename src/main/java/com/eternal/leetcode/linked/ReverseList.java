package com.eternal.leetcode.linked;

/**
 * @Auther Eternal
 * @Date 2022/6/25
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

//        reverseList(head).print();

//        reverseBetween(head, 2, 4).print();
        reverseKGroup(head, 2).print();
    }

    /*
     * BM1 反转链表:
     * 1. 定义临时变量存储当前的下一个
     * 2. 令当前的下一个为前一个（相当于反转链接箭头）
     * 3. 令前指针指向当前位置
     * 4. 当前指针移动到下一位（用到1中的临时变量）
     */
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

    /*
    * BM2 链表内指定区间反转
    * */
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode res = new ListNode(0);
        res.next = head;

        ListNode pre = res;
        ListNode cur = head;

        for (int i = 1; i < m; i++) {
            pre = cur;
            cur = cur.next;
        }

        System.out.println(pre.val);

//        for (int i = m; i < n; i++) {
//            ListNode temp = cur.next;
//            cur.next = temp.next;
//            temp.next = pre.next;
//            pre.next = temp;
//        }

//        cur.next = cur.next.next;
//        cur.next.next = pre.next;

        ListNode temp = cur.next;
        cur.next = temp.next;
        temp.next = pre.next;
        pre.next = temp;

//        ListNode temp2 = cur.next;
//        cur.next = temp2.next;
//        temp2.next = pre.next;
//        pre.next = temp2;

        return res.next;
    }

    /*
    * BM3 链表中的节点每k个一组翻转
    * */
    public static ListNode reverseKGroup (ListNode head, int k) {

        ListNode tail = head;

        for (int i = 0; i < k; i++) {
            if (tail == null) return head;
            tail = tail.next;
        }

        ListNode pre = null;
        ListNode cur = head;

        while (cur != tail) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

        head.next = reverseKGroup(tail, k);

        return head;
    }
}


