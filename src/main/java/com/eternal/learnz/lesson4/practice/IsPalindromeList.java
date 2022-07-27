package com.eternal.learnz.lesson4.practice;

import java.util.Stack;

/**
 * @Auther Eternal
 * @Date 2022/7/27
 * 判断一个链表是否为回文结构
 */
public class IsPalindromeList {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    /*
    * 方法1：使用栈
    * 放入栈
    * 每弹出一个就对比
    * 全部相等就是回文
    * */
    public static boolean isPalindrome1(Node head) {
        Stack<Node> stack = new Stack<Node>();
        Node cur = head;

        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        while (head != null) {
            if (head.value != stack.pop().value) return false;
            head = head.next;
        }

        return true;
    }

    /*
    * 方法2：
    * 只将右部分入栈（使用快慢指针找到右部分）
    * 出栈清空停止
    * 如果都相等就是回文
    * */
    public static boolean isPalindrome2(Node head) {
        if (head == null || head.next == null) return true;

        // 快慢指针
        Node right = head.next;
        Node cur = head;
        while (cur.next != null && cur.next.next != null) {
            right = right.next;
            cur = cur.next.next;
        }

        Stack<Node> stack = new Stack<Node>();
        while (right != null) {
            stack.push(right);
            right = right.next;
        }

        while (!stack.isEmpty()) {
            if (head.value != stack.pop().value) return false;
            head = head.next;
        }

        return true;
    }

}