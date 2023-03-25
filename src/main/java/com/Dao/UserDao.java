package com.Dao;

import com.POJO.Goods;
import com.POJO.User;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface UserDao {
    public User FindUserByName(String username);
    public User LoginByEmail(HashMap<String,String> map);
    public int createUser(User user);
    public int updateUser(HashMap<String,String> map);
    public int updateUserStatus(HashMap<String,String> map);
    public User FindUserByActivateCode(String activateCode);
}
