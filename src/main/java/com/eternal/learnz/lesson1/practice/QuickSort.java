package com.eternal.learnz.lesson1.practice;

/**
 * @Auther Eternal
 * @Date 2022/6/25
 * 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {6, 5, 8, 4, 5, 2, 4, 1, 7, 9};
        printArray(arr);
        quickSort(arr, 0, arr.length - 1);
        printArray(arr);
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int mid = partition(arr, left, right);
        quickSort(arr, left, mid - 1);
        quickSort(arr, mid + 1, right);
    }

    public static int partition(int[] arr, int leftBound, int rightBound) {
        int pivot = arr[rightBound];
        int left = leftBound;
        int right = rightBound - 1;

        while (left <= right) {
            while (left <= right && arr[left] <= pivot) left++;
            while (left <= right && arr[right] > right) right--;
            if (left < right) swap(arr, left, right);
        }

        swap(arr, left, rightBound);

        return left;
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
