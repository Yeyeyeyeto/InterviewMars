package com.eternal.leetcode.linked;

/**
 * @Auther Eternal
 * @Date 2022/7/4
 */
public class DeleteList {

    /*
    * BM15 删除有序链表中重复的元素-I
    * 每个元素只能出现一次
    * 元素遍历，如果相等则忽略掉
    * */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode cur = head;

        // 指针当前和下一位不为空
        while (cur != null && cur.next != null) {
            // 如果当前与下一位相等则忽略下一位, 否则正常遍历
            if (cur.val == cur.next.val) cur.next = cur.next.next;
            else cur = cur.next;
        }

        return head;
    }

    /*
    * BM16 删除有序链表中重复的元素-II
    * 只保留出现一次的元素
    * */
    public static ListNode deleteDuplicates2(ListNode head) {
        if (head == null) return null;

        ListNode res = new ListNode(0);

        res.next = head;
        ListNode cur = res;

        while (cur.next != null && cur.next.next != null) {
            // 遇到相邻两个结点值都相同
            if (cur.next.val == cur.next.next.val) {
                int temp = cur.next.val;
                // 将所有相同的跳过
                while (cur.next != null && cur.next.val == temp) cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return res.next;
    }

}
