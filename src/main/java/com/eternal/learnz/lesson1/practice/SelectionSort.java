package com.eternal.learnz.lesson1.practice;

/**
 * @Auther Eternal
 * @Date 2022/6/17
 * 选择排序
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {5, 6, 8, 4, 5, 2, 4, 1, 7, 9};
        printArray(arr);
        selectionSort(arr);
        printArray(arr);
    }

    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) return;

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
                System.out.println(arr[minIndex]);
            }
            swap(arr, i, minIndex);
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
