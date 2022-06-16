package com.eternal.other;

/**
 * @Auther Eternal
 * @Date 2022/6/7
 * 插入排序
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] a = {9, 3, 1, 4, 6, 8, 7, 5, 2};
        sort(a);
        print(a);
    }

    static void sort(int[] a) {
        for (int i = 1; i < a.length; i++) {
//            for (int j = i; j > 0; j--) {
//                if (a[j] < a[j-1]) swap(a, j, j-1);
//            }

            for (int j = i; j > 0 && a[j] < a[j-1]; j--) {
                swap(a, j, j-1);
            }
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
