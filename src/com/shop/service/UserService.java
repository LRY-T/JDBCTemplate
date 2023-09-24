package com.shop.service;

import com.shop.pojo.User;

public interface UserService {
    //登录验证
    public User login(String username,String password);
    public int modifyUserPw(User user);
}
