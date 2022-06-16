package com.eternal.other;

/**
 * @Auther Eternal
 * @Date 2022/6/7
 * 冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] a = {9, 3, 1, 4, 6, 8, 7, 5, 2};
        sortBest(a);
        print(a);
    }

    static void sort(int[] a) {
        for (int i = a.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j+1]) swap(a, j, j + 1);
            }
        }
    }

    static void sortBest(int[] arr) {
        boolean didSwap;

        for (int i = 0, len = arr.length; i < len-1; i++) {
            didSwap = false;
            for (int j = 0; j < len - i - 1; j++) {
                if (arr[j + 1] < arr[j]) {
                    swap(arr, j, j + 1);
                    didSwap = true;
                }
            }
            if (didSwap == false) return;;
        }
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
