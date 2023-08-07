package org.example.c.structural.b.template;

/**
 * @author goku
 * @datetime 2023/8/7 10:01 PM
 */
public class Demo {
    public static void main(String[] args) {
        TemplateClass templateClass = new ConcreteClass1();
        // 调用父类定义的模板方法
        templateClass.templateMethod();

        templateClass = new ConcreteClass2();
        // 调用父类定义的模板方法
        templateClass.templateMethod();
    }
}
