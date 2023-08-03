package org.example.b.behavioral.a.proxy;

/**
 * @author goku
 * @datetime 2023/8/3 10:10 PM
 */
public class UserController implements IUserController{
    public void login(String username, String password) throws InterruptedException {
        Thread.sleep(500);
        System.out.println("login...user：" + username);
    }
}
