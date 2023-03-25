package com.Dao.Impl;

import com.Dao.UserDao;
import com.POJO.User;
import com.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.Map;

public class UserDaoImpl implements UserDao {
    SqlSession sqlSession =MybatisUtils.getSqlSession();
    UserDao userdao=sqlSession.getMapper(UserDao.class);
    @Override
    public User FindUserByName(String username) {
        return userdao.FindUserByName(username);
    }

    @Override
    public User LoginByEmail(HashMap<String,String> map) {
        return userdao.LoginByEmail(map);
    }

    @Override
    public int createUser(User user) {
        return userdao.createUser(user);
    }

    @Override
    public int updateUser(HashMap<String,String> map) {
        return userdao.updateUser(map);
    }

    @Override
    public int updateUserStatus(HashMap<String, String> map) {
        return userdao.updateUserStatus(map);
    }

    @Override
    public User FindUserByActivateCode(String  activateCode) {
       return userdao.FindUserByActivateCode(activateCode);
    }
}
