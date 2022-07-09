package com.eternal.leetcode.linked;

/**
 * @Auther Eternal
 * @Date 2022/7/3
 */
public class AddList {

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
    * BM11 链表相加(二)
    * */
    public static ListNode addInList(ListNode head1, ListNode head2) {
        // 任意一个链表为空，返回另一个
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        // 反转两个链表
        head1 = reverseList(head1);
        head2 = reverseList(head2);

        // 新链表 添加表头
        ListNode res = new ListNode(-1);
        ListNode head = res;

        // 进位符号
        int carry = 0;

        // 只要某链表还有或进位还有
        while (head1 != null || head2 != null || carry != 0) {
            // 取链表中的值
            int val1 = head1 == null ? 0 : head1.val;
            int val2 = head2 == null ? 0 : head2.val;

            // 相加
            int temp = val1 + val2 + carry;

            // 获取进位
            carry = temp / 10;
            temp %= 10;

            // 添加元素
            head.next = new ListNode(temp);
            head = head.next;

            // 移动下一个
            if (head1 != null) head1 = head1.next;
            if (head2 != null) head2 = head2.next;
        }

        return reverseList(res.next);
    }

    // 翻转链表 - 双链表方式
    public static ListNode reverseList(ListNode pHead) {
        if (pHead == null) return null;

        ListNode cur = pHead;
        ListNode pre = null;

        while (cur != null) {
            // 断开链表，要记录后续一个
            ListNode temp = cur.next;
            // 当前的next指向前一个
            cur.next = pre;
            // 前一个更新为当前
            pre = cur;
            // 当前更新为刚刚记录的后一个
            cur = temp;
        }

        return pre;
    }

}
