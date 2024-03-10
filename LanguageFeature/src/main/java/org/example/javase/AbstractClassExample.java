package org.example.javase;

/**
 * 抽象类和抽象方法都使用 abstract 关键字进行声明。抽象类一般会包含抽象方法，抽象方法一定位于抽象类中。
 * <p>
 * 抽象类和普通类最大的区别是，抽象类不能被实例化，需要继承抽象类才能实例化其子类。
 *
 * @author chensh
 * @datetime 2024/3/10 1:32 PM
 */
public abstract class AbstractClassExample {
    public static void main(String[] args) {
        // AbstractClass ac1 = new AbstractClass(); // 'AbstractClassExample' is abstract; cannot be instantiated
        AbstractClass ac2 = new AbstractExtendClassExample();
        ac2.func1();
    }
}

abstract class AbstractClass {
    private int x;
    public int y;

    public abstract void func1();

    public void func2() {
    }
}

class AbstractExtendClassExample extends AbstractClass {

    @Override
    public void func1() {
        System.out.println("AbstractExtendClassExample.func1()");
    }
}
