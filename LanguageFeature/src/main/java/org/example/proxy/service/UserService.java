package org.example.proxy.service;

/**
 * Author: chensh
 * Date: 2024/9/18 4:59 PM
 */
public class UserService implements IUserService{

    public String queryUserNameById(String userId) {
        return "hi user " + userId;
    }

}
