package com.dlkj.shop.service.Impl;

import com.dlkj.shop.dao.UserDao;
import com.dlkj.shop.dao.impl.UserDaoImpl;
import com.dlkj.shop.pojo.User;
import com.dlkj.shop.service.UserService;

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
