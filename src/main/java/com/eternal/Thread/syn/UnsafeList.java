package com.eternal.Thread.syn;

import java.util.ArrayList;

/**
 * @Auther Eternal
 * @Date 2022/6/25
 * 线程不安全的集合
 */
public class UnsafeList {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                synchronized (list) {
                    list.add(Thread.currentThread().getName());
                }
            }).start();
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(list.size());
    }
}
