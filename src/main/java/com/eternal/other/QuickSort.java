package com.eternal.other;

/**
 * @Auther Eternal
 * @Date 2022/6/8
 * 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] a = {7, 3, 2, 8, 1, 9, 5, 4, 6, 10};
        sort(a, 0, a.length - 1);
        print(a);
    }

    static void sort(int[] a, int left, int right) {
        if (left >= right) return;
        int mid = partition(a, left, right);
        sort(a, left, mid - 1);
        sort(a, mid + 1, right);
    }

    static int partition(int[] a, int leftBound, int rightBound) {
        int pivot = a[rightBound];
        int left = leftBound;
        int right = rightBound - 1;

        while (left <= right) {
            while (left <= right && a[left] <= pivot) left++;
            while (left <= right && a[right] > right) right--;
            if (left < right) swap(a, left, right);
        }

        swap(a, left, rightBound);

        return left;
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
