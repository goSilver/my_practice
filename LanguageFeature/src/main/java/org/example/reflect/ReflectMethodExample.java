package org.example.reflect;

import java.lang.reflect.Method;

/**
 * Method类及其用法
 * <p>
 * Method 提供关于类或接口上单独某个方法（以及如何访问该方法）的信息，所反映的方法可能是类方法或实例方法（包括抽象方法）。
 *
 * @author chensh
 * @datetime 2024/3/10 7:56 PM
 */
public class ReflectMethodExample {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        Class<?> clazz = Class.forName("org.example.reflect.Circle");

        // 根据参数获取public的Method,包含继承自父类的方法
        Method method = clazz.getMethod("draw", int.class, String.class);
        System.out.println("method：" + method);
        // 获取所有public的方法:
        Method[] methods = clazz.getMethods();
        for (Method method1 : methods) {
            System.out.println("m::"+ method1.getName());
        }

        System.out.println("=========================================");

        // 获取当前类的方法包含private,该方法无法获取继承自父类的method
        Method method1 = clazz.getDeclaredMethod("drawCircle");
        System.out.println("method1::"+method1);
        // 获取当前类的所有方法包含private,该方法无法获取继承自父类的method
        Method[] methods1=clazz.getDeclaredMethods();
        for (Method m:methods1){
            System.out.println("m1::"+m);
        }
    }
}


class Shape {
    public void draw(){
        System.out.println("draw");
    }
    public void draw(int count , String name){
        System.out.println("draw "+ name +",count="+count);
    }
}
class Circle extends Shape{
    private void drawCircle(){
        System.out.println("drawCircle");
    }
    public int getAllCount(){
        return 100;
    }
}
