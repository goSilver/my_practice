package org.example.proxy.jdk;

import cn.hutool.core.util.ClassLoaderUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 代理类获取的服务
 * Author: chensh
 * Date: 2024/9/18 5:01 PM
 */
public class JDKProxy {

    public static <T> T getProxy(Class<T> interfaceClass) throws Exception {
        InvocationHandler handler = new JDKInvocationHandler();
        ClassLoader classLoader = ClassLoaderUtil.getClassLoader();
        T result = (T) Proxy.newProxyInstance(classLoader, new Class[]{interfaceClass}, handler);
        return result;
    }

}

