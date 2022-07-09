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
     * 双链表法：pre为新的链表，每次取走原数组的一个元素
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
            // 断开链表
            ListNode temp = cur.next;
            // 当前next指向前一个
            cur.next = pre;
            // 前一个更新为当前
            pre = cur;
            // 当前更新为刚刚记录的后一个
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

        // 找到m
        for (int i = 1; i < m; i++) {
            pre = cur;
            cur = cur.next;
        }

        System.out.println(pre.val);

        // 从m反转到n
        for (int i = m; i < n; i++) {
            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
        }

        // 返回去掉表头
        return res.next;
    }

    /*
    * BM3 链表中的节点每k个一组翻转
    * */
    public static ListNode reverseKGroup (ListNode head, int k) {
        // 翻转的尾部
        ListNode tail = head;

        // 遍历k次到尾部
        for (int i = 0; i < k; i++) {
            // 如果不足k，代表到了链表尾，直接返回，不翻转
            if (tail == null) return head;
            tail = tail.next;
        }

//        System.out.print("tail = ");
//        tail.print();  // 3 4 5 6

        // 翻转时需要的前序和当前节点
        ListNode pre = null;
        ListNode cur = head;

        // 翻转
        while (cur != tail) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

//        System.out.print("pre = ");
//        pre.print();    // 2 1

        head.next = reverseKGroup(tail, k);

        return pre;
    }
}


