package org.example.c.structural.b.template;

/**
 * 模板方法模式
 * @author goku
 * @datetime 2023/8/7 9:58 PM
 */
public abstract class TemplateClass {
    public void templateMethod() {
        System.out.println("TemplateClass.templateMethod");
        method1();
        method2();
    }

    protected abstract void method1();

    protected abstract void method2();
}
