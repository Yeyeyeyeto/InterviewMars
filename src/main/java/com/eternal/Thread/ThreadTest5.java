package com.eternal.Thread;

/**
 * @Auther Eternal
 * @Date 2022/6/20
 * 礼让线程
 * 礼让不一定成功，看CPU心情
 */
public class ThreadTest5 {
    public static void main(String[] args) {
        MyYield myYield = new MyYield();

        new Thread(myYield, "a").start();
        new Thread(myYield, "b").start();
    }
}

class MyYield implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "线程开始执行");
        Thread.yield(); // 礼让
        System.out.println(Thread.currentThread().getName() + "线程停止执行");
    }
}
