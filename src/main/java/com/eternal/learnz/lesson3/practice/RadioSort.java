package com.eternal.learnz.lesson3.practice;

/**
 * @Auther Eternal
 * @Date 2022/7/10
 * 基数排序
 * 这个有点没太懂（具体写法不懂）
 */
public class RadioSort {
    public static void radixSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        radixSort(arr, 0, arr.length - 1, maxBits(arr));
    }

    private static int maxBits(int[] arr) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }

        int res = 0;
        while (max != 0) {
            res++;
            max /= 10;
        }

        return res;
    }

    public static int getDigit(int x, int d) {
        return ((x / ((int) Math.pow(10, d - 1))) % 10);
    }

    // digit: 最大的值有几个十进制位
    public static void radixSort(int[] arr, int begin, int end, int digit) {
        final int radix = 10;
        int i = 0, j = 0;

        // 有多少个数准备多少个辅助空间
        int[] bucket = new int[end - begin + 1];
        // 有多少位就进出多少次，比如最大是100，就进出3次，1000 4次...
        for (int d = 0; d <= digit; d++) {
            // 10个空间
            // count[0] 当前为（d位）是0的数字有多少个
            // count[1] 当前为（d位）是（0和1）的数字有多少个
            // count[2] 当前为（d位）是（0、1和2）的数字有多少个
            // count[i] 当前为（d位）是（0~i）的数字有多少个
            int[] count = new int[radix];
            for (i = begin; i <= end; i++) {
                j = getDigit(arr[i], d);
                count[j]++;
            }
            for (i = 1; i < radix; i++) {
                count[i] = count[i] + count[i - 1];
            }
            for (i = end; i >= begin; i--) {
                j = getDigit(arr[i], d);
                bucket[count[j] - 1] = arr[i];
                count[j]--;
            }
            for (i = begin, j = 0; i <= end; i++, j++) {
                arr[i] = bucket[j];
            }
        }

    }

}
