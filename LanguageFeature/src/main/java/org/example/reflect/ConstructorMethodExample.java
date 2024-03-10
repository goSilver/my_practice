package org.example.reflect;

import java.lang.reflect.Constructor;

/**
 * Constructor类及其用法
 *
 * @author chensh
 * @datetime 2024/3/10 7:13 PM
 */
public class ConstructorMethodExample {
    /**
     * 通过反射来创建对象
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Class<?> clazz = null;
        // 获取Class对象的引用
        clazz = Class.forName("org.example.reflect.User");

        // 第一种：实例化默认构造方法，User必须无参构造函数，否则将抛异常
        User user = (User) clazz.newInstance();
        user.setAge(18);
        user.setName("kobe");
        System.out.println(user);
        System.out.println("--- --- ---");

        // 第二种：获取带String参数的public构造函数
        Constructor<?> cs2 = clazz.getConstructor(String.class);
        User jordan = (User) cs2.newInstance("jordan");
        jordan.setAge(23);
        System.out.println(jordan);
        System.out.println("--- --- ---");

        // 第三种：获取指定带int、String的私有构造函数
        Constructor<?> cs3 = clazz.getDeclaredConstructor(int.class, String.class);
        cs3.setAccessible(true);
        User shark = (User) cs3.newInstance(34, "shark");
        System.out.println(shark);
        System.out.println("--- --- ---");

        // 第四种：获取所有构造函数，包括私有的
        Constructor<?>[] csList = clazz.getDeclaredConstructors();
        for (int i = 0; i < csList.length; i++) {
            // 获取构造函数参数类型
            Class<?>[] parameterTypes = csList[i].getParameterTypes();
            System.out.println("构造函数[" + i + "]:" + csList[i].toString());
            System.out.print("参数类型[" + i + "]:(");
            for (int j = 0; j < parameterTypes.length; j++) {
                if (j == parameterTypes.length - 1)
                    System.out.print(parameterTypes[j].getName());
                else
                    System.out.print(parameterTypes[j].getName() + ",");
            }
            System.out.println(")");
        }
    }
}


class User {
    private int age;
    private String name;

    public User() {
        super();
    }

    public User(String name) {
        super();
        this.name = name;
    }

    /**
     * 私有构造
     *
     * @param age
     * @param name
     */
    private User(int age, String name) {
        super();
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" + "age=" + age + ", name='" + name + '\'' + '}';
    }
}
