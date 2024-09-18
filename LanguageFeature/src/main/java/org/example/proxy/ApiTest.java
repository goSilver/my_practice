package org.example.proxy;

import org.example.proxy.cglib.CglibProxy;
import org.example.proxy.jdk.JDKProxy;
import org.example.proxy.service.IUserService;
import org.example.proxy.service.UserService;
import org.junit.Test;
import sun.misc.ProxyGenerator;
import cn.hutool.core.util.ClassLoaderUtil;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Author: chensh
 * Date: 2024/9/18 5:08 PM
 */
public class ApiTest {
    /**
     * 代理后调用方法验证
     */
    @Test
    public void test_proxy_jdk() throws Exception {

        IUserService proxy = (IUserService) JDKProxy.getProxy(ClassLoaderUtil.loadClass("org.example.proxy.service.IUserService"));
        String userName = proxy.queryUserNameById("10001");
        System.out.println(userName);

        String name = "ProxyUserService";
        byte[] data = ProxyGenerator.generateProxyClass(name, new Class[]{IUserService.class});

        // 输出类字节码
//        FileOutputStream out = null;
//        try {
//            out = new FileOutputStream(name + ".class");
//            System.out.println((new File("")).getAbsolutePath());
//            out.write(data);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (null != out) try {
//                out.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }

    /**
     * 调用代理类
     */
    @Test
    public void test_proxy_cglib() {
        CglibProxy cglibProxy = new CglibProxy();
        UserService userService = (UserService) cglibProxy.newInstall(new UserService());
        String userName = userService.queryUserNameById("10001");
        System.out.println(userName);
    }


}
