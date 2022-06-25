package com.eternal.learnz.lesson1.practice;

/**
 * @Auther Eternal
 * @Date 2022/6/17
 * 堆排序
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {6, 5, 8, 4, 5, 2, 4, 1, 7, 9};
        printArray(arr);
        heapSort(arr);
        printArray(arr);
    }

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) return;


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
