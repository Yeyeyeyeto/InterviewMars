package com.eternal.JVM.Basis;

import java.util.ArrayList;

/**
 * @Auther Eternal
 * @Date 2022/7/8
 */
public class GCDemo2 {

    byte[] array = new byte[1 * 1024 * 1024]; // 1m

    public static void main(String[] args) {
        ArrayList<GCDemo2> list = new ArrayList<>();
        int count = 0;

        try {
            while (true) {
                list.add(new GCDemo2());
                count += 1;
            }
        } catch (Exception e) {
            System.out.println("count: " + count);
            e.printStackTrace();
        }
    }
}
