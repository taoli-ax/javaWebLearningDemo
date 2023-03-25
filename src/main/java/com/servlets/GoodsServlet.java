package com.servlets;

import com.POJO.Goods;
import com.POJO.PageBean;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.services.GoodsService;
import com.services.Impl.GoodServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@WebServlet("/goods/*")
public class GoodsServlet extends BaseServlet {
    GoodsService goodService=new GoodServiceImpl();

    public void FindHotGoods(HttpServletRequest request,HttpServletResponse response) throws IOException {


        List<Goods> goods=goodService.FindHotGoods();

        response.setContentType("text/html;charset=utf-8");
        ObjectMapper objectMapper=new ObjectMapper();
        objectMapper.writeValue(response.getWriter(),goods);

        System.out.println(request);
        System.out.println("find hot goods");
    }
    public void FindNewGoods(HttpServletRequest request,HttpServletResponse response) throws IOException {

        List<Goods> goods=goodService.FindNewGoods();

        response.setContentType("text/html;charset=utf-8");
        ObjectMapper objectMapper=new ObjectMapper();
        objectMapper.writeValue(response.getWriter(),goods);

        System.out.println(request);

        System.out.println("find new goods");
    }
    public void GoodsDetail(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String serial=request.getParameter("serial");
        Goods goods=goodService.GoodsDetail(serial);

        HttpSession httpSession=request.getSession();
        httpSession.setAttribute("goodsInstance",goods);
        response.sendRedirect(request.getContextPath()+"/goods.jsp");
    }
    // getGoodsByCategory 查询数据 并 重定向
    public void findGoodsByCategoryAndPage(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        String id=request.getParameter("id");
        String currentPage=request.getParameter("currentPage");
        PageBean<Goods> pageBean=goodService.findGoodsByCategoryAndPage(Integer.parseInt(id),Integer.parseInt(currentPage));
        System.out.println(pageBean.toString());
        HttpSession httpSession=request.getSession();
        httpSession.setAttribute("goodsCategory",pageBean);

//        request.getRequestDispatcher("/goodsCategory.jsp").forward(request,response);



        response.sendRedirect(request.getContextPath()+"/goodsCategory.jsp");
    }
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
////        resp.getWriter().write("000000000000000000");
//
//    }
}
