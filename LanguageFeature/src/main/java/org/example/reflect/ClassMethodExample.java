package org.example.reflect;

import java.lang.reflect.Field;

/**
 * Class类的方法
 * <p>
 * 获取class对象的方式的主要有三种
 * 根据类名：类名.class
 * 根据对象：对象.getClass()
 * 根据全限定类名：Class.forName(全限定类名)
 *
 * @author chensh
 * @datetime 2024/3/10 6:51 PM
 */
public class ClassMethodExample {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class<Dog> dog = Dog.class;
        // 类名打印
        System.out.println(dog.getName()); // org.example.reflect.Dog
        System.out.println(dog.getSimpleName()); // Dog
        System.out.println(dog.getCanonicalName());// org.example.reflect.Dog
        //接口
        System.out.println(dog.isInterface()); //false
        for (Class iI : dog.getInterfaces()) {
            System.out.println(iI);
        }
         /*
          interface org.example.reflect.I1
          interface org.example.reflect.I2
         */

        //父类
        System.out.println(dog.getSuperclass());// class org.example.reflect.Animal
        //创建对象
        Dog d = dog.newInstance();
        //字段
        for (Field f : dog.getFields()) {
            System.out.println(f.getName());
        }
        /*
            mDogPublic
            sDogPublic
            mAnimalPublic
            sAnimalPublic
            mCellPublic  //父类的父类的公共字段也打印出来了
         */
        System.out.println("---------");
        for (Field f : dog.getDeclaredFields()) {
            System.out.println(f.getName());
        }
        /*
         只有自己类声明的字段
         mDogPrivate
         mDogPublic
         mDogProtected
         mDogDefault
         sDogPrivate
         sDogProtected
         sDogDefault
         sDogPublic
         */
    }
}

interface I1 {
}

interface I2 {
}

class Cell {
    public int mCellPublic;
}

class Animal extends Cell {
    private int mAnimalPrivate;
    protected int mAnimalProtected;
    int mAnimalDefault;
    public int mAnimalPublic;
    private static int sAnimalPrivate;
    protected static int sAnimalProtected;
    static int sAnimalDefault;
    public static int sAnimalPublic;
}

class Dog extends Animal implements I1, I2 {
    private int mDogPrivate;
    public int mDogPublic;
    protected int mDogProtected;
    private int mDogDefault;
    private static int sDogPrivate;
    protected static int sDogProtected;
    static int sDogDefault;
    public static int sDogPublic;
}
