package com.services.Impl;

import com.Dao.GoodsDao;
import com.Dao.Impl.GoodsDaoImpl;
import com.POJO.Goods;
import com.POJO.PageBean;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.services.GoodsService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.transaction.annotation.SpringTransactionAnnotationParser;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

public class GoodServiceImpl implements GoodsService {

    @Override
    public List<Goods> FindNewGoods() throws IOException {
        GoodsDao goodsDao=new GoodsDaoImpl();
        return goodsDao.FindNewGoods();


    }

    @Override
    public List<Goods> FindHotGoods() throws IOException {
        GoodsDao goodsDao=new GoodsDaoImpl();
        return  goodsDao.FindHotGoods();

    }

    @Override
    public Goods GoodsDetail(String serial) throws IOException {
        GoodsDao goodsDao=new GoodsDaoImpl();
        return goodsDao.GoodsDetail(serial);
    }

    @Override
    public PageBean<Goods> findGoodsByCategoryAndPage(int id, int currentPage) throws IOException {
        GoodsDao goodsDao = new GoodsDaoImpl();
        //查询分类商品的总数
        int num = goodsDao.findGoodsByCategoryId(id);
        // 设置每页的展示数量
        int pageSize=16;
        // 查询对应页码的商品
        List<Goods> goods= goodsDao.findGoodsByCategoryAndPage(id,(currentPage-1)*pageSize,pageSize);

        // pageBean装载
        PageBean<Goods> pageBean =new PageBean<>();
        pageBean.setCurrentPage(currentPage);
        pageBean.setPageSize(pageSize);
        pageBean.setTotalCount(num);
        pageBean.setTotalPage((num+pageSize-1)/pageSize);
        pageBean.setList(goods);

        return pageBean;



    }


}
