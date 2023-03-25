package com.servlets;

import com.POJO.Category;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.services.CategoryService;
import com.services.Impl.CategoryServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;


@WebServlet("/category/*")
public class FindCategory extends BaseServlet {
    public void FindAllCategory(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        CategoryService categoryService=new CategoryServiceImpl();
        List<Category> categoryList=categoryService.FindAllCategory();
        resp.setContentType("text/html;charset=utf-8");
        ObjectMapper objectMapper=new ObjectMapper();
        objectMapper.writeValue(resp.getWriter(),categoryList);

    }
}
