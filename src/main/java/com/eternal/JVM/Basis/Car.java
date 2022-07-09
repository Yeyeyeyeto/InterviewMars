package com.eternal.JVM.Basis;

/**
 * @Auther Eternal
 * @Date 2022/7/7
 */
public class Car {
    public static void main(String[] args) {
        // 类是模板，对象是具体的
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();

        // 具体的对象
        System.out.println(car1.hashCode());
        System.out.println(car2.hashCode());
        System.out.println(car3.hashCode());

        Class<? extends Car> car1Class = car1.getClass();
        Class<? extends Car> car2Class = car2.getClass();
        Class<? extends Car> car3Class = car3.getClass();

        // 类 模板
        System.out.println(car1Class.hashCode());
        System.out.println(car2Class.hashCode());
        System.out.println(car3Class.hashCode());


        // 类加载器
        ClassLoader classLoader = car1Class.getClassLoader();
        System.out.println(classLoader);  // AppClassLoader
        System.out.println(classLoader.getParent());  // ExtClassLoader
        System.out.println(classLoader.getParent().getParent());   // null 1. 不存在 2. java程序获取不到  rt.jar

    }
}
