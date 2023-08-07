package org.example.c.structural.b.template;

/**
 * 子类1
 * @author goku
 * @datetime 2023/8/7 9:59 PM
 */
public class ConcreteClass1 extends TemplateClass {
    @Override
    protected void method1() {
        System.out.println("ConcreteClass1.method1");
    }

    @Override
    protected void method2() {
        System.out.println("ConcreteClass1.method2");
    }
}
