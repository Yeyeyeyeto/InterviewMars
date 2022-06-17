package com.eternal.learnz.lesson1.practice;

/**
 * @Auther Eternal
 * @Date 2022/6/17
 * 希尔排序
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {6, 5, 8, 4, 5, 2, 4, 1, 7, 9};
        printArray(arr);
        shellSort(arr);
        printArray(arr);
    }

    public static void shellSort(int[] arr) {
        if (arr == null || arr.length < 2) return;

        // 二分之一序列
        for (int gap = arr.length >> 1; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i; j > gap - 1; j -= gap) {
                    if (arr[j] < arr[j-gap]) swap(arr, j, j-gap);
                }
            }
        }

        // knuth序列
        int h = 1;
        while (h <= arr.length / 3) h = h * 3 + 1;
        for (int gap = h; gap > 0; gap = (gap - 1) / 3) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i; j > gap - 1; j -= gap) {
                    if (arr[j] < arr[j-gap]) swap(arr, j, j-gap);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
