package com.servlets;

import com.POJO.User;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet("/logout/*")
public class LogoutServlet extends BaseServlet{
    public  void Logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("logout by user");
        HttpSession httpSession=request.getSession();
        Object user=httpSession.getAttribute("user");
        httpSession.removeAttribute("user");
        response.getWriter().write("has removed user");

    }
}
