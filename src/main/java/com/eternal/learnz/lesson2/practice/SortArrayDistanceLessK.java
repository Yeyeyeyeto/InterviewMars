package com.eternal.learnz.lesson2.practice;

import java.util.PriorityQueue;

/**
 * @Auther Eternal
 * @Date 2022/7/10
 *
 * 已知一个几乎有序的数组，几乎有序是指，如果把数组排好顺序的话，每个元
 * 素移动的距离可以不超过k，并且k相对于数组来说比较小。请选择一个合适的
 * 排序算法针对这个数据进行排序
 *
 * 假设k = 6，设定一个容量为6的小根堆
 * 将小根堆中最小弹出到，返回数组中
 * 再接纳后续的数，接纳后继续弹出
 * 循环结束后依次排好
 */
public class SortArrayDistanceLessK {

    public static void sortedArrDistanceLessK(int[] arr, int k) {
        // Java默认自带小根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int index = 0;

        // Math.min(arr.length, k) 边界处理，防止k值过大
        for (; index < Math.min(arr.length, k); index++) {
            heap.add(arr[index]);
        }

        int i = 0;
        for (; index < arr.length; i++, index++) {
            heap.add(arr[index]);
            arr[i] = heap.poll();
        }

        while (!heap.isEmpty()) {
            arr[i++] = heap.poll();
        }
    }

}
