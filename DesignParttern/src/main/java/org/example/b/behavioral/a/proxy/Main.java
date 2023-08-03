package org.example.b.behavioral.a.proxy;

/**
 * @author goku
 * @datetime 2023/8/3 10:12 PM
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        MetricsCollectorProxy proxy = new MetricsCollectorProxy();
        IUserController userController = (IUserController) proxy.createProxy(new UserController());
        userController.login("admin", "123456");
    }
}
