package com.eternal.leetcode.linked;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Auther Eternal
 * @Date 2022/7/2
 */
public class MergeList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode v2 = new ListNode(3);
        ListNode v3 = new ListNode(5);
        ListNode head2 = new ListNode(2);
        ListNode v4 = new ListNode(4);
        ListNode v5 = new ListNode(6);

        head.next = v2;
        v2.next = v3;

        head2.next = v4;
        v4.next = v5;

//        head.print();

        Merge2(head, head2).print();
    }

    /*
     * BM4 合并两个排序的链表
     * 用数组把两个链表合并起来后排序 - 再重新导入新链表中
     * */
    public static ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        if (list1 == null && list2 == null) return null;

        ArrayList<Integer> list = new ArrayList<>();
        while (list1 != null) {
            list.add(list1.val);
            list1 = list1.next;
        }
        while (list2 != null) {
            list.add(list2.val);
            list2 = list2.next;
        }

        Collections.sort(list);

        ListNode newHead = new ListNode(list.get(0));
        ListNode cur = newHead;
        for (int i = 1; i < list.size(); i++) {
            cur.next = new ListNode(list.get(i));
            cur = cur.next;
        }

        return newHead;
    }

    /*
    * BM4 合并两个排序的链表
    * 用一个新链表，原两链表两两比较，较小的数放入新链表
    * */
    public static ListNode Merge2(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(-1);
        ListNode cur = result;

        // 保证两个list不为空的情况下，比较后传值
        while (list1 != null && list2 != null) {
            if (list1.val >= list2.val) {
                result.next = list2;
                list2 = list2.next;
            } else {
                result.next = list1;
                list1 = list1.next;
            }
            result = result.next;
        }

        // 还有剩下的值直接拿走
        if (list1 != null) result.next = list1;
        if (list2 != null) result.next = list2;

        return cur.next;
    }

    /*
     * BM5 合并k个已排序的链表???
     * */
    public static ListNode mergeKLists(ArrayList<ListNode> lists) {
        return divideMerge(lists, 0, lists.size() - 1);
    }

    private static ListNode divideMerge(ArrayList<ListNode> lists, int left, int right) {
        if (left > right) return null;
        else if (left == right) return lists.get(left);
        int mid = (left + right) / 2;
        return Merge(divideMerge(lists, left, mid), divideMerge(lists, mid + 1, right));
    }

    private static ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode head = new ListNode(0);
        ListNode cur = head;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }

        if (list1 != null) cur.next = list1;
        else cur.next = list2;

        return head.next;
    }
}