package com.eternal.Thread;

/**
 * @Auther Eternal
 * @Date 2022/6/17
 */
// 创建线程方式一：继承Thread类，重写run()方法，调用start开启线程
// 线程开启不一定立即执行， 由CPU调度执行
public class ThreadTest1 extends Thread {

    @Override
    public void run() {
        // run方法线程体
        for (int i = 0; i < 20; i++) {
            System.out.println("在看代码 --- " + i);
        }
    }

    public static void main(String[] args) {
        // main线程，主线程

        // 创建一个线程对象
        ThreadTest1 threadTest1 = new ThreadTest1();

        // 调用start()方法开启线程
        threadTest1.start();

        for (int i = 0; i < 2000; i++) {
            System.out.println("学习 --- " + i);
        }
    }

}
