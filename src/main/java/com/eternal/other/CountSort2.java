package com.eternal.other;

import java.util.Arrays;

/**
 * @Auther Eternal
 * @Date 2022/6/10
 * 计数排序2
 */
public class CountSort2 {
    public static void main(String[] args) {
        int[] a = {2, 4, 2, 4, 7, 1, 1, 0, 0, 5, 6, 9, 8, 5, 7, 4, 0, 9};
        int[] result = sort(a);

        System.out.println(Arrays.toString(result));
    }

    static int[] sort(int[] arr) {
        int[] result = new int[arr.length];
        int[] count = new int[10];

        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        System.out.println(Arrays.toString(count));

        for (int i = 1; i < count.length; i++) {
            count[i] = count[i] + count[i-1];
        }
        System.out.println(Arrays.toString(count));
        for (int i = arr.length - 1; i >= 0; i--) {
            result[--count[arr[i]]] = arr[i];
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
