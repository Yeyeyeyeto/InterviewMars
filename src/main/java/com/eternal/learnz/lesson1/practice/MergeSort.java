package com.eternal.learnz.lesson1.practice;

/**
 * @Auther Eternal
 * @Date 2022/6/17
 * 归并排序
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {6, 5, 8, 4, 5, 2, 4, 1, 7, 9};
        printArray(arr);
        mergeSort(arr);
        printArray(arr);
    }

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) return;

        int mid = arr.length / 2;
        int[] temp = new int[arr.length];

        int i = 0;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j < arr.length) {
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }

        while (i <= mid) temp[k++] = arr[i++];
        while (j < arr.length) temp[k++] = arr[j++];

        printArray(temp);
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
