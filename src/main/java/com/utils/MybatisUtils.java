package com.utils;

import com.Dao.CategoryDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtils {
    private static final SqlSessionFactory sqlSessionFactory;
    private static final ThreadLocal<SqlSession> threadLocal=new ThreadLocal<>();
    static {

        try {
            InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("配置文件加载Pending");
        }




    }
    public static SqlSession getSqlSession(){

        SqlSession sqlSession=threadLocal.get();
        if(sqlSession==null){
             sqlSession=sqlSessionFactory.openSession();
             threadLocal.set(sqlSession);
        }
        return sqlSession;

    }
    public static void released(){
        SqlSession sqlSession=threadLocal.get();
        if(sqlSession!=null){
            threadLocal.remove();
            sqlSession.close();
        }

    }
}
