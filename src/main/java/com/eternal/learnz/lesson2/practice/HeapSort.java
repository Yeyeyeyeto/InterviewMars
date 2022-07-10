package com.eternal.learnz.lesson2.practice;

/**
 * @Auther Eternal
 * @Date 2022/7/10
 * 堆排序
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] nums = {3, 5, 1, 2, 6, 7, 3, 4, 9};

        heapSort(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }

    }

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) return;

		for (int i = 0; i < arr.length; i++) {  // O(N)
			heapInsert(arr, i);  // O(logN)
		}

        // 稍微复杂一点，但复杂度没有变
//        for (int i = 0; i < arr.length - 1; i++) heapify(arr, i, arr.length);

        int size = arr.length;
        swap(arr, 0, --size);
        while (size > 0) {   // O(N)
            heapify(arr, 0, size);  // O(logN)
            swap(arr, 0, --size);    // O(1)
        }

    }

    // 向上比较，移动  父节点：(i - 1) / 2
    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    // 向下比较，移动
    public static void heapify(int[] arr, int index, int size) {
        // 左孩子的下标
        int left = index * 2 + 1;

        // 下方还有孩子的时候
        while(left < size) {
            // 两个孩子中，谁值大，谁把下标给largest
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
            // 父和孩子之间，谁的值大，谁吧下标给largest
            largest = arr[largest] > arr[index] ? largest : index;

            if (largest == index) break;

            swap(arr, largest, index);
            index = largest;

            // 继续找左孩子
            left = index * 2 + 1;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
