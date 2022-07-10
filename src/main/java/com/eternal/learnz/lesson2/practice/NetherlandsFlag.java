package com.eternal.learnz.lesson2.practice;

/**
 * @Auther Eternal
 * @Date 2022/7/10
 * 荷兰国旗问题
 * 这个代码莫名其妙的，之后再看其他资料写吧
 */
public class NetherlandsFlag {

    public static void main(String[] args) {
        int[] nums = {3, 5, 1, 2, 6, 7, 3, 4, 9};
        int[] newNums = partition(nums, 0, nums.length - 1, 1);
        for (int newNum : newNums) System.out.println(newNum);
    }

    public static int[] partition(int[] arr, int l, int r, int p) {
        int less = l - 1;
        int more = l + 1;

        while (l < more) {
            if (arr[l] < p) swap(arr, ++less, l++);
            else if (arr[l] > p) swap(arr, --more, l);
            else l++;
        }

        return new int[] {less + 1, more - 1};
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
