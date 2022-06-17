package com.eternal.learnz.lesson1.practice;

/**
 * @Auther Eternal
 * @Date 2022/6/17
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {6, 7, 2, 1, 3, 5, 9, 8, 4};
        printArray(arr);
        BubbleSort(arr);
        printArray(arr);
    }

    public static void BubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) return;

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j+1]) swap(arr, j, j+1);
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
