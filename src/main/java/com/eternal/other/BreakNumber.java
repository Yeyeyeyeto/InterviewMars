package com.eternal.other;

import java.util.Scanner;

/**
 * @Auther Eternal
 * @Date 2022/5/28
 */
public class BreakNumber {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Long num = sc.nextLong();

        for (int i = 1; i < num/2; i+=2) {
            for (int j = 3; j < num/2; j+=2) {
                if (i * j == num) {
                    System.out.println(i + " " + j);
                    return;
                }
            }
        }

        System.out.println("-1 -1");
    }
}
