package com.services;

import com.POJO.Goods;
import com.POJO.PageBean;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;

public interface GoodsService {
    public List<Goods> FindNewGoods() throws IOException;
    public List<Goods> FindHotGoods() throws IOException;
    public Goods GoodsDetail(String serial) throws IOException;
    public PageBean<Goods> findGoodsByCategoryAndPage(int id, int currentPage) throws IOException;

//    InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
//    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//    sqlSession=sqlSessionFactory.openSession();
//    nationDao=sqlSession.getMapper(NationDao.class);
}
