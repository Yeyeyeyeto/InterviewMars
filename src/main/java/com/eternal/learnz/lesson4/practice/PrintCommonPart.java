package com.eternal.learnz.lesson4.practice;

/**
 * @Auther Eternal
 * @Date 2022/7/27
 * 打印两个有序链表的公共部分
 */
public class PrintCommonPart {

    public static class Node {
        public int value;
        public Node next;
        public Node(int data) {
            this.value = data;
        }
    }

    /*
    * 打印两个有序链表的公共部分
    * 1. 两个指针分别指向两个链表头部
    * 2. 谁小谁移动
    * 3. 如若相等，打印，并共同走一步
    * 4. 循环
    * */
    public static void printCommonPart(Node head1, Node head2) {
        System.out.println("Common Part: ");
        while (head1 != null && head2 != null) {
            if (head1.value < head2.value) {
                head1 = head1.next;
            } else if (head1.value > head2.value) {
                head2 = head2.next;
            } else {
                System.out.print(head1.value + " ");
                head1 = head1.next;
                head2 = head2.next;
            }
        }
        System.out.println();
    }

}
