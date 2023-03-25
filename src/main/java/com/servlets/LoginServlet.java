package com.servlets;

import com.POJO.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.services.Impl.UserServiceImpl;
import com.services.UserService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashMap;

@WebServlet("/login/*")
public class LoginServlet extends BaseServlet{
    public void LoginByEmail(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String email=request.getParameter("Email");
        String password = request.getParameter("password");
        HashMap<String ,String>map=new HashMap<>();
        map.put("email",email);
        map.put("password",password);
        UserService userService=new UserServiceImpl();
        User u=userService.LoginByEmail(map);
        if(u!=null){
//            ObjectMapper objectMapper=new ObjectMapper();
//            objectMapper.writeValue(response.getWriter(),"Welcome:"+u.getName());
            HttpSession httpSession=request.getSession();
            httpSession.setAttribute("user",u);

            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }else {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("没有找到这个用户，登录失败: get params email:"+email+" password:"+password);
        }

    }
}
