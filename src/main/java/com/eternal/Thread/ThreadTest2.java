package com.eternal.Thread;

/**
 * @Auther Eternal
 * @Date 2022/6/20
 */
// 实现runnable接口，重写run方法，执行线程需要丢入runnable接口实现类，调用start方法
public class ThreadTest2 implements Runnable {

    @Override
    public void run() {
        // run方法线程体
        for (int i = 0; i < 20; i++) {
            System.out.println("在看代码 --- " + i);
        }
    }

    public static void main(String[] args) {
        // 创建Runnable接口的实现类对象
        ThreadTest2 threadTest2 = new ThreadTest2();

        // 创建线程对象，通过线程对象来开启我们的线程，代理
        new Thread(threadTest2).start();


        for (int i = 0; i < 2000; i++) {
            System.out.println("学习 --- " + i);
        }
    }

}
