package com.eternal.im.company;

import java.util.Scanner;

/**
 * @Auther Eternal
 * @Date 2022/3/19
 *
 *
 * 牛妹的字符串
 *
 * https://www.nowcoder.com/questionTerminal/86a27471088249b99d1e9ad23ee04a60?answerType=1&f=discussion
 */
public class CowString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int k = sc.nextInt();
        sc.close();

        System.out.println(NS_String(s, k));

    }

    public static String NS_String (String s, int k) {
        char p = 'a';
        String result = s;

        while (k > 0 && p <= 'z') {
            while (result.indexOf(p) == -1) {
                p = (char) (p + 1);
            }
            result = result.replace(p + "", "");
            k--;
        }

        return result;

    }

}
