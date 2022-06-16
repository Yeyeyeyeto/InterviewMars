package com.eternal.other;

import java.util.Scanner;

/**
 * @Auther Eternal
 * @Date 2022/5/28
 */
public class WebResponse {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i = sc.nextInt();
        int spend = 0;

        int[][] nums = new int[n+3][2];

        int[] nNums = new int[n+1];

        for (int k = 1; k < n + 1; k++) {
            nNums[k] = k;
        }

        for (int k = 0; k < i; k++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            nums[k][0] = n1;
            nums[k][1] = n2;
        }

        // 结点
        int point = sc.nextInt();

        nNums[point] = 0;
        int j = n;
        while (j-- > 0) {
            for (int k = 0; k < n+2; k++) {
                if (nums[k][0] == point) {
                    nNums[nums[k][1]] = 0;
                } else if (nums[k][1] == point) {
                    nNums[nums[k][0]] = 0;
                }
            }
            spend += 1;
            int sum = 0;
            for (int k = 1; k < n + 1; k++) {
                sum += nNums[k];
                if (sum != 0) {
                    point += 1;
                    break;
                }
            }

            if (nNums[point+2] == 0) break;
        }

        System.out.println(spend * 2);
    }

}
