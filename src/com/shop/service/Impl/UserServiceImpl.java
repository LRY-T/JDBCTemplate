package com.shop.service.Impl;

import com.shop.dao.UserDao;
import com.shop.dao.impl.UserDaoImpl;
import com.shop.pojo.User;
import com.shop.service.UserService;

public class UserServiceImpl implements UserService {
    UserDao dao = new UserDaoImpl();
    @Override
    public User login(String username, String password) {
        return dao.findOneUser(username,password);
    }

    @Override
    public int modifyUserPw(User user) {
        return dao.modifyUserPw(user);
    }
}
