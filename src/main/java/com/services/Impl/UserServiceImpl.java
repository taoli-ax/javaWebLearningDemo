package com.services.Impl;

import com.Dao.Impl.UserDaoImpl;
import com.Dao.UserDao;
import com.POJO.User;
import com.services.UserService;

import java.util.HashMap;
import java.util.Map;

public class UserServiceImpl implements UserService {
    UserDao userDao =new UserDaoImpl();

    @Override
    public User findUserByName(String username) {
       return userDao.FindUserByName(username);
    }

    @Override
    public User LoginByEmail(HashMap<String,String> map) {
        return userDao.LoginByEmail(map);
    }

    @Override
    public int createUser(User user) {
       return userDao.createUser(user);
    }



    @Override
    public int updateUser(HashMap<String,String> map) {
        return userDao.updateUser(map);
    }

    @Override
    public int updateUserStatus(HashMap<String, String> map) {
        return userDao.updateUserStatus(map);
    }

    @Override
    public User FindUserByActivateCode(String activateCode) {
        return userDao.FindUserByActivateCode(activateCode);
    }


}

