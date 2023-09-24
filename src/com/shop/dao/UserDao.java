package com.shop.dao;

import com.shop.pojo.User;

public interface UserDao {
    public int modifyUserPw(User user);
    public User findOneUser(String uc,String pw);
}
