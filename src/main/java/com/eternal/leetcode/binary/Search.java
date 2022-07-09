package com.eternal.leetcode.binary;

/**
 * @Auther Eternal
 * @Date 2022/7/7
 */
public class Search {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};

        System.out.println(search(nums, 3));
    }

    /*
    * BM17 二分查找-I
    * */
    public static int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            // 每次检查中点的值
            int m = (l + r) / 2;
            if (nums[m] == target) return m;
            // 进入左边区间(小区间)
            if (nums[m] > target) r = m - 1;
            // 进入右边区间（大区间）
            else l = m + 1;
        }

        return -1;
    }

    /*
    * BM18 二维数组中的查找
    * */
    public static boolean find(int target, int[][] array) {
        if (array.length == 0) return false;
        if (array[0].length == 0) return false;

        int n = array.length;
        int m = array[0].length;

        // 从最左下角的元素开始往右或往上
        for (int i = n - 1, j = 0; i >= 0 && j < m; ) {
            // 元素较大，走上
            if (array[i][j] > target) i--;
            // 元素较小，走右
            else if (array[i][j] < target) j++;
            else return true;
        }

        return false;
    }

    /*
    * BM19 寻找峰值
    * */
    public static int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            // 右边是往下，不一定有波峰
            if (nums[mid] > nums[mid + 1]) right = mid;
            // 右边是往上，一定能找到波峰
            else left = mid + 1;
        }

        // 其中一个波峰
        return right;
    }

    /*
    * BM21 旋转数组的最小数字 ?
    * */
    public static int minNumberInRotateArray(int[] array) {
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            // 最小的数值在mid右边
            if (array[mid] > array[right]) left = mid + 1;
            // 无法判断，一个一个试
            else if (array[mid] == array[right]) right--;
            // 最小数值要么是mid要么在mid左边
            else right = mid;

        }

        return array[left];
    }

}
