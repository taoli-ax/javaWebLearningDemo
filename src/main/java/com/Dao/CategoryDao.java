package com.Dao;

import com.POJO.Category;

import java.io.IOException;
import java.util.List;

public interface CategoryDao {
    public List<Category> FindAllCategory() throws IOException;
}
