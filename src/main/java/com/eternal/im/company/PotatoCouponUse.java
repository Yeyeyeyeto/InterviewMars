package com.eternal.im.company;

import java.util.Scanner;

/**
 * @Auther Eternal
 * @Date 2022/3/11
 *
 * 小红书2020校招测试开发&后端笔试题卷三
 * [编程题]薯券使用问题
 *
 * https://www.nowcoder.com/questionTerminal/61d87f7f514a4687859a837578ef3aca
 */
public class PotatoCouponUse {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        String[] temp = s.substring(1, s.length() - 1).split(",");

        int[] arr = new int[n + 1];
        int[] p = new int[temp.length];
        for (int i = 0; i < temp.length; i++) {
            p[i] = Integer.parseInt(temp[i]);
        }

        arr[0] = 1;

        for (int a : p) {
            for (int i = a; i < arr.length; i++) {
                arr[i] = (arr[i] + arr[i - a]);
            }
        }

        System.out.println(arr[n]);

    }

}
