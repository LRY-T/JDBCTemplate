package com.dlkj.shop.service;

import com.dlkj.shop.pojo.User;

public interface UserService {
    //登录验证
    public User login(String username,String password);
    public int modifyUserPw(User user);
}
