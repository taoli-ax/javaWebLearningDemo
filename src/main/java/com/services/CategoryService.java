package com.services;

import com.POJO.Category;

import java.io.IOException;
import java.util.List;

public interface CategoryService {
    public List<Category> FindAllCategory() throws IOException;
}
