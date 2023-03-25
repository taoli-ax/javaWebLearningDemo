package com.servlets;

import com.POJO.Cart;
import com.POJO.User;
import com.services.CartService;
import com.services.Impl.CartServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@WebServlet("/cart/*")
public class CartServlet extends BaseServlet{
    CartService cartService =new CartServiceImpl();
    public void addToCart(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession httpSession=req.getSession();
        User user=(User)httpSession.getAttribute("user");

        String name=req.getParameter("name");
        String num=req.getParameter("num");
        String price=req.getParameter("price");
        String id=req.getParameter("productId");

        System.out.println(name+" "+num+" "+price+" "+id);
        cartService.addToCart(Integer.parseInt(id), (int) user.getId(),Integer.parseInt(num),new BigDecimal(price));
    }

    public void checkOutPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("checkout");
        User user=(User)req.getSession().getAttribute("user");
        List<Cart> cart=cartService.queryUserCart(user.getId());

        BigDecimal total=new BigDecimal("0.00");
        for (Cart c: cart
             ) {
            BigDecimal retail_price=c.getGoods().getRetail_price();
            total=total.add(retail_price);
        }
        req.getSession().setAttribute("cartList",cart);
        req.getSession().setAttribute("total",total);
        System.out.println(cart.toString());
        resp.setContentType("text/html;charset=UTF-8");
        resp.sendRedirect(req.getContextPath()+"/checkout.jsp");


//        req.getRequestDispatcher("/checkout.jsp").forward(req,resp);

    }

}
