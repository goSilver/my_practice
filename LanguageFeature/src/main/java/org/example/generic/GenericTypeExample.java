package org.example.generic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author chensh
 * @datetime 2024/3/10 3:47 PM
 */
public class GenericTypeExample<T> {
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static void main(String[] args) {
        // 第一次自己写出现的错误，new后面不带{}，导致ClassCastException，
//        GenericTypeExample<String> gte = new GenericTypeExample<String>();
        GenericTypeExample<User> genericType = new GenericTypeExample<User>(){};
        Type superclass = genericType.getClass().getGenericSuperclass();
        // getActualTypeArguments 返回确切的泛型参数, 如Map<String, Integer>返回[String, Integer]
        Type type = ((ParameterizedType) superclass).getActualTypeArguments()[0];
        System.out.println(type); // class org.example.generic.User
    }
}

class User {
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
