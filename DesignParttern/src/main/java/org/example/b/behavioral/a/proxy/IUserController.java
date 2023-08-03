package org.example.b.behavioral.a.proxy;

/**
 * 用户控制器接口
 *
 * @author goku
 * @datetime 2023/8/3 10:14 PM
 */
public interface IUserController {

    /**
     * 登录
     *
     * @param username 用户名
     * @param password 密码
     * @throws InterruptedException 中断异常
     */
    void login(String username, String password) throws InterruptedException;
}
