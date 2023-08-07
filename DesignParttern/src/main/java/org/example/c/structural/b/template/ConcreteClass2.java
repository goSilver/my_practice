package org.example.c.structural.b.template;

/**
 * 子类2
 * @author goku
 * @datetime 2023/8/7 10:01 PM
 */
public class ConcreteClass2 extends TemplateClass {
    @Override
    protected void method1() {
        System.out.println("ConcreteClass2.method1");
    }

    @Override
    protected void method2() {
        System.out.println("ConcreteClass2.method2");
    }
}
