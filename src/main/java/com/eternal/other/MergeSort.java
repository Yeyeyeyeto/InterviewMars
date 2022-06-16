package com.eternal.other;

/**
 * @Auther Eternal
 * @Date 2022/6/8
 * 归并排序
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] a = {1, 4, 7, 8, 3, 6, 9};
        sort(a);
    }

    static void sort(int[] a) {
        merge(a);
    }

    static void merge(int[] a) {
        int mid = a.length / 2;
        int[] temp = new int[a.length];

        int i = 0;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j < a.length) {
            temp[k++] = a[i] <= a[j] ? a[i++] : a[j++];
//            if (a[i] <= a[j]) {
//                temp[k++] = a[i++];
//            } else {
//                temp[k++] = a[j++];
//            }
        }

        while(i <= mid) temp[k++] = a[i++];
        while(j < a.length) temp[k++] = a[j++];

        print(temp);
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
