package org.example.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 代理类反射调用
 * Author: chensh
 * Date: 2024/9/18 5:00 PM
 */
public class JDKInvocationHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName());
        return "我被JDKProxy代理了";
    }

}
