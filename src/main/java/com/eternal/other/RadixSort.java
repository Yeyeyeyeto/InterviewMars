package com.eternal.other;

import java.util.Arrays;

/**
 * @Auther Eternal
 * @Date 2022/6/10
 * 基数排序
 * https://www.bilibili.com/video/BV1hf4y1773Z?p=22
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] a = {2, 4, 2, 4, 7, 1, 1, 0, 0, 5, 6, 9, 8, 5, 7, 4, 0, 9};
        int[] result = sort(a);

        System.out.println(Arrays.toString(result));
    }

    static int[] sort(int[] arr) {
        int[] result = new int[arr.length];
        int[] count = new int[10];

        for (int i = 0; i < 3; i++) {
            int division = (int) Math.pow(10, i);
            System.out.println(division);
            for (int j = 0; j < arr.length; j++) {
                int num = arr[j] / division % 10;
                System.out.println(num + " ");
                count[num]++;
            }

            System.out.println();
            System.out.println(Arrays.toString(count));

            for (int m = 1; m < count.length; m++) {
                count[m] = count[m] + count[m-1];
            }

            System.out.println(Arrays.toString(count));

            for (int n = arr.length - 1; n >= 0; n--) {
                int num = arr[n] / division % 10;
                result[--count[num]] = arr[n];
            }

            System.arraycopy(result, 0, arr, 0, arr.length);
            Arrays.fill(count, 0);
        }
        return result;
    }

    static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
