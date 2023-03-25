package com.services.Impl;

import com.Dao.CategoryDao;
import com.Dao.Impl.CategoryDaoImpl;
import com.POJO.Category;
import com.services.CategoryService;

import java.io.IOException;
import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    @Override
    public List<Category> FindAllCategory() throws IOException {
        CategoryDao categoryDao=new CategoryDaoImpl();
        return categoryDao.FindAllCategory();
    }
}
