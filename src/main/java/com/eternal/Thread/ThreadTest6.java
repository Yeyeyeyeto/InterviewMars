package com.eternal.Thread;

/**
 * @Auther Eternal
 * @Date 2022/6/20
 * join方法，想象为插队
 */
public class ThreadTest6 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("线程VIP来了" + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // 启动我们的线程
        ThreadTest6 join = new ThreadTest6();
        Thread thread = new Thread(join);;
        thread.start();

        // 主线程
        for (int i = 0; i < 1000; i++) {
            if (i == 200) thread.join();
            System.out.println("main" + i);
        }
    }

}
