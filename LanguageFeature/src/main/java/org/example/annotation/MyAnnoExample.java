package org.example.annotation;

import java.io.FileNotFoundException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 自定义注解
 *
 * @author goku
 * @datetime 2023/8/8 2:57 PM
 */
public class MyAnnoExample {
    @Override
    @MyMethodAnnotation(title = "toStringMethod", description = "override toString method")
    public String toString() {
        return "Override toString method";
    }

    @Deprecated
    @MyMethodAnnotation(title = "old static method", description = "deprecated old static method")
    public static void oldMethod() {
        System.out.println("old method, don't use it.");
    }

    @SuppressWarnings({"unchecked", "deprecation"})
    @MyMethodAnnotation(title = "test method", description = "suppress warning static method")
    public static void genericsTest() throws FileNotFoundException {
        List l = new ArrayList();
        l.add("abc");
        oldMethod();
    }

    public static void main(String[] args) {
        try {
            // 获取所有方法
            Method[] methods = MyAnnoExample.class.getClassLoader()
                    .loadClass("org.example.annotation.MyAnnoExample")
                    .getMethods();

            // 遍历方法
            for (Method method : methods) {
                // 判断方法是否有MyMethodAnnotation注解
                if (method.isAnnotationPresent(MyMethodAnnotation.class)) {
                    try {
                        // 遍历方法上的注解
                        for (Annotation declaredAnnotation : method.getDeclaredAnnotations()) {
                            System.out.println("Annotation in method:" + method + " is " + declaredAnnotation);
                        }

                        // 获取MyMethodAnnotation注解对象信息
                        MyMethodAnnotation myMethodAnnotation = method.getAnnotation(MyMethodAnnotation.class);
                        System.out.println(myMethodAnnotation.title());
                        System.out.println("==== ==== ====");
                    } catch (Throwable ex) {
                        ex.printStackTrace();
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
