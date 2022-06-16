package com.eternal.other;

/**
 * @Auther Eternal
 * @Date 2022/6/8
 * 归并排序3
 */
public class MergeSort3 {

    public static void main(String[] args) {
        int[] a = {1, 4, 7, 8, 3, 6, 9};
        sort(a, 0, a.length - 1);
        print(a);
    }

    static void sort(int[] a, int left, int right) {
        if (left == right) return;

        // 分成两半
//        int mid = (left + right) / 2;
        int mid = left + (right - left) / 2;
        // 左边排序
        sort(a, left, mid);
        // 右边排序
        sort(a, mid + 1, right);

        merge(a, left, mid + 1, right);
    }

    static void merge(int[] a, int leftPtr, int rightPtr, int rightBound) {
        int mid = rightPtr - 1;
        int[] temp = new int[rightBound - leftPtr + 1];

        int i = leftPtr;
        int j = rightPtr;
        int k = 0;

        while (i <= mid && j <= rightBound) {
            temp[k++] = a[i] <= a[j] ? a[i++] : a[j++];
        }

        while(i <= mid) temp[k++] = a[i++];
        while(j <= rightBound) temp[k++] = a[j++];

        for (int m = 0; m < temp.length; m++) a[leftPtr + m] = temp[m];
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
