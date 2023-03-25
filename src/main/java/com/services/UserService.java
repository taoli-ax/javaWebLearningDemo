package com.services;

import com.POJO.User;

import java.util.HashMap;
import java.util.Map;

public interface UserService {
    public User findUserByName(String username);
    public User LoginByEmail(HashMap<String,String> map);
    public int createUser(User user);
    public int updateUser(HashMap<String,String> map);
    public int updateUserStatus(HashMap<String,String> map);
    public User FindUserByActivateCode(String activateCode);
}
