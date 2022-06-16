package com.eternal.im.company;

import java.util.Arrays;

/**
 * @Auther Eternal
 * @Date 2022/4/8
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arrays = {55, 33, 70, 10, 6, 45};
        bubbleSort(arrays);
        System.out.println(Arrays.toString(arrays));
    }

    public static void bubbleSort(int[] array){
        for(int i = 0; i < array.length - 1; i++){
            for(int j = 0; j < array.length - 1 - i; j++){
                if(array[j] > array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
