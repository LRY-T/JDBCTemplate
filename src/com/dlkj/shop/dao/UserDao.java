package com.dlkj.shop.dao;

import com.dlkj.shop.pojo.User;

public interface UserDao {
    public int modifyUserPw(User user);
    public User findOneUser(String uc,String pw);
}
