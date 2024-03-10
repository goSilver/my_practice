package org.example.javase;

/**
 * 从 Java 8 开始，接口也可以拥有默认的方法实现，这是因为不支持默认方法的接口的维护成本太高了。
 * 在 Java 8 之前，如果一个接口想要添加新的方法，那么要修改所有实现了该接口的类。
 * 接口的成员(字段 + 方法)默认都是 public 的，并且不允许定义为 private 或者 protected。
 * 接口的字段默认都是 static 和 final 的。
 *
 * @author chensh
 * @datetime 2024/3/10 1:44 PM
 */
public class InterfaceClassExample {
    public static void main(String[] args) {
        // InterfaceExample ie1 = new InterfaceExample(); // 'InterfaceExample' is abstract; cannot be instantiated
        InterfaceExample ie2 = new InterfaceImplExample();
        ie2.func1();
        ie2.func2();
        System.out.println(ie2.x);
    }
}

interface InterfaceExample {
    void func1();

    default void func2(){
        System.out.println("InterfaceExample.func2()");
    }

    int x = 123;
    // int y;               // Variable 'y' might not have been initialized
    public int z = 0;       // Modifier 'public' is redundant for interface fields
    // private int k = 0;   // Modifier 'private' not allowed here
    // protected int l = 0; // Modifier 'protected' not allowed here
    // private void fun3(); // Modifier 'private' not allowed here
}

class InterfaceImplExample implements InterfaceExample {
    @Override
    public void func1() {
        System.out.println("InterfaceImpl.func1()");
    }
}