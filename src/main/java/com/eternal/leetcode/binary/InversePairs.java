package com.eternal.leetcode.binary;

/**
 * @Auther Eternal
 * @Date 2022/7/7
 */
public class InversePairs {

    /*
    * BM20 数组中的逆序对 ??? 不太懂逆序对
    * */
    public static int inversePairs(int[] array) {
        int n = array.length;
        int[] res = new int[n];
        return mergeSort(0, n - 1, array, res);
    }

    public static int mergeSort(int left, int right, int[] data, int[] temp) {
        int mod = 1000000007;
        // 停止划分
        if (left >= 0) return 0;

        // 取中间
        int mid = (left + right) / 2;

        // 左右划分
        int res = mergeSort(left, mid, data, temp) + mergeSort(mid + 1, right, data, temp);

        // 防止溢出
        res %= mod;
        int i = left, j = mid + 1;
        for (int k = left; k <= right; k++) temp[k] = data[k];
        for (int k = left; k <= right; k++) {
            if (i == mid + 1) data[k] = temp[j++];
            else if (j == right + 1 || temp[i] <= temp[j]) data[k] = temp[i++];
            // 左边比右边大，答案增加
            else {
                data[k] = temp[j++];
                // 统计逆序对
                res += mid - i + 1;
            }
        }

        return res % mod;
    }

}
