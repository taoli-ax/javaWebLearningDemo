package com.Dao.Impl;

import com.Dao.GoodsDao;
import com.POJO.Goods;
import com.POJO.PageBean;
import com.utils.MybatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

public class GoodsDaoImpl implements GoodsDao {
    private final SqlSession sqlSession= MybatisUtils.getSqlSession();
    GoodsDao goodsDao=sqlSession.getMapper(GoodsDao.class);
    @Override
    public List<Goods> FindNewGoods() throws IOException {

        return goodsDao.FindNewGoods();
    }

    @Override
    public List<Goods> FindHotGoods() throws IOException {
        return goodsDao.FindHotGoods();

    }

    @Override
    public Goods GoodsDetail(String serial) throws IOException {
        return goodsDao.GoodsDetail(serial);
    }

    @Override
    public List<Goods> findGoodsByCategoryAndPage(int id,int index,int pageSize) throws IOException {
        return goodsDao.findGoodsByCategoryAndPage(id,index,pageSize);
    }

    @Override
    public int findGoodsByCategoryId(int id) throws IOException {
        return goodsDao.findGoodsByCategoryId(id);
    }




}
