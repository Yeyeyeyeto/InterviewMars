package com.eternal.learnz.lesson2.practice;

/**
 * @Auther Eternal
 * @Date 2022/7/2
 * 小和问题
 * 还是不太明白
 * 左右两组数相等时，先拷贝左边的数
 */
public class SmallSum {

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 5};
        System.out.println(smallSum(nums));
    }

    public static int smallSum(int[] arr) {
        if (arr == null || arr.length < 2) return 0;
        return mergeSort(arr, 0, arr.length - 1);
    }

    // arr[L...R]既要排好序，也要求小和
    private static int mergeSort(int[] arr, int l, int r) {
        if (l == r) return 0;
        int mid = l + ((r - l) >> 1);
        return mergeSort(arr, l, mid)  // 左侧排序并且求小和的数量
                + mergeSort(arr, mid + 1, r)  // 右侧排序并且求小和的数量
                + merge(arr, l, mid, r);  // 合并时产生小和的数量
    }

    private static int merge(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = m + 1;
        int res = 0;
        while (p1 <= m && p2 <= r) {
            // 左组比右组小才产生小和数量增加，(r - p2 + 1): 个数，说明的是当前的右组有多少个数比当前p1指的数要大
            res += arr[p1] < arr[p2] ? (r - p2 + 1) * arr[p1] : 0;
            // 左组严格小于时才拷贝左组
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= m) help[i++] = arr[p1++];
        while (p2 <= r) help[i++] = arr[p2++];

        for (i = 0; i < help.length; i++) arr[l + i] = help[i];

        return res;
    }

}



