package com.eternal.Thread;

/**
 * @Auther Eternal
 * @Date 2022/6/20
 * 静态代理模式
 * 真实对象和代理对象都要实现同一个接口
 * 代理对象要代理真实角色
 * 好处：
 *      代理对象可以做很多真实对象做不了的事情
 *      真实对象专注做自己的事情
 */
public class StaticProxy {
    public static void main(String[] args) {
//        WeddingCompany weddingCompany = new WeddingCompany(new You());
//        weddingCompany.HappyMarry();

        You you = new You();
        new Thread(() -> System.out.println("I LOVE YOU")).start();
        new WeddingCompany(new You()).HappyMarry();
    }
}

interface Marry {
    void HappyMarry();
}

// 真实角色，你去结婚
class You implements Marry {
    @Override
    public void HappyMarry() {
        System.out.println("要结婚了，超开心！");
    }
}

// 代理角色，帮助你结婚
class WeddingCompany implements Marry {

    // 代理目标
    private Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void HappyMarry() {
        before();
        this.target.HappyMarry();   // 真实对象
        after();
    }

    private void after() {
        System.out.println("结婚后，收尾款");
    }

    private void before() {
        System.out.println("结婚前，布置现场");
    }
}













