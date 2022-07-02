package com.eternal.learnz.lesson1.practice;

/**
 * @Auther Eternal
 * @Date 2022/7/2
 * 二分法
 */
public class BS {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

//        System.out.println(exist(arr, 4));
        System.out.println(nearestIndex(arr, 4));
    }

    /**
     * 在有序数组中，找某数是否存在
     */
    public static boolean exist(int[] sortedArr, int num) {
        if (sortedArr == null || sortedArr.length == 0) return false;

        int l = 0;
        int r = sortedArr.length - 1;
        int mid = 0;
        while (l < r) {
            mid = l + ((r - l) / 2);
            if (sortedArr[mid] == num) {
                return true;
            } else if (sortedArr[mid] > num) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }

            System.out.println(mid);
        }

        return sortedArr[l] == num;
    }

    /**
     * 在一个有序数组中，找>=某个数最左侧的位置
     */
    public static int nearestIndex(int[] arr, int value) {
        int l = 0;
        int r = arr.length - 1;
        int index = -1;

        while (l < r) {
            int mid = l + ((r - l) / 2);
            if (arr[mid] >= value) {
                index = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
            System.out.println("mid = " + mid + "; index = " + index);
        }

        return index;
    }

    /**
     * 局部最小值问题
     */
    public static int awesome() {
        return 0;
    }


}
