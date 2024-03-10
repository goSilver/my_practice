package org.example.reflect;

import java.lang.reflect.Field;

/**
 * Field类及其用法
 * <p>
 * Field 提供有关类或接口的单个字段的信息，以及对它的动态访问权限。反射的字段可能是一个类（静态）字段或实例字段。
 *
 * @author chensh
 * @datetime 2024/3/10 7:37 PM
 */
public class ReflectFieldExample {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        // 获取Class对象
        Class<?> clazz = Class.forName("org.example.reflect.Student");

        // 获取指定字段名称的Field类，注意字段修饰符必须为public而且存在该字段，否则抛NoSuchFieldException
        Field age = clazz.getField("age");
        System.out.println("field：" + age);

        // 获取所有修饰符为public的字段,包含父类字段,注意修饰符为public才会获取
        Field[] fields = clazz.getFields();
        for (Field f : fields) {
            System.out.println("field：" + f.getName() + ", class：" + f.getDeclaringClass());
        }

        System.out.println("================getDeclaredFields====================");
        // 获取当前类所字段(包含private字段),注意不包含父类的字段
        Field[] fields2 = clazz.getDeclaredFields();
        for (Field f : fields2) {
            System.out.println("field2：" + f.getName() + ", class：" + f.getDeclaringClass());
        }

        // 获取指定字段名称的Field类,可以是任意修饰符的自动,注意不包含父类的字段
        Field field2 = clazz.getDeclaredField("desc");
        System.out.println("field2:" + field2);
    }
}

class Person {
    public int age;
    public String name;

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
}

class Student extends Person {
    public String desc;
    private int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
