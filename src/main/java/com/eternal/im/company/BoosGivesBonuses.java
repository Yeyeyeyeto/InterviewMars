package com.eternal.im.company;

import java.util.Scanner;

/**
 * @Auther Eternal
 * @Date 2022/3/12
 *
 * 【2020】奇安信秋招Java方向试卷3
 *  [编程题]老板发奖金
 *
 *  https://www.nowcoder.com/questionTerminal/e1f0cf12993d49f498601d88a57b8e5e
 *
 *  似懂未懂
 *
 */
public class BoosGivesBonuses {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("输入要发的奖金:");
        int num = sc.nextInt();
        System.out.println("您有" + func(num) + "种方法发完" + num + "元奖金!!");
    }

    public static int func(Integer num) {
        if (num == 1) return 1;

        int count = 0;
        for (int i = num - 1; i >= 1; i--) {
            count = func(i) + count;
        }

        return count + 1;
    }

}
