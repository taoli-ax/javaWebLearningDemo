package com.Dao.Impl;

import com.Dao.CategoryDao;
import com.Dao.GoodsDao;
import com.POJO.Category;
import com.POJO.Goods;
import com.utils.MybatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {
    private final SqlSession sqlSession=MybatisUtils.getSqlSession();
    CategoryDao categoryDao=sqlSession.getMapper(CategoryDao.class);
    @Override
    public List<Category> FindAllCategory() throws IOException {
        List<Category>categories=categoryDao.FindAllCategory();
        for (Category category:categories
        ) {
            System.out.println(category.getName());
        }
        return categories;

    }
}
