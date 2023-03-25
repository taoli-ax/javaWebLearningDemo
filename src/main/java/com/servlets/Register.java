package com.servlets;


import com.POJO.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.services.Impl.MailServiceImpl;
import com.services.Impl.UserServiceImpl;
import com.services.MailService;
import com.services.UserService;
import com.utils.JMailUtils;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/register/*")
public class Register extends BaseServlet{
    public void newRegister(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String email=request.getParameter("email");

        if(username.length()<6 || password.length()<6){
             response.getWriter().write("too short name or password");
             return;
        }
        UserService userService=new UserServiceImpl();
        User user1=userService.findUserByName(username);


        Map<String,String> userMap=new HashMap<>();
        User user=new User();
        userMap.put("name",username);
        userMap.put("password",password);
        userMap.put("email",email);

        try {
            BeanUtils.populate(user,userMap);
        }
        catch (Exception e) {
            System.out.println(e);
        }

        if(user1!=null){
            response.getWriter().write("user name is in use,please change");
        }else {
            int n=userService.createUser(user);
            response.setContentType("text/html;charset=utf-8");
            MailService mailService=new MailServiceImpl();
            mailService.sendMail(user);
            response.sendRedirect(request.getContextPath()+"/registerOk.jsp");

        }
    }
    public void CheckUserExist(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("checkUserExist");
        String username=request.getParameter("username");

        if(username.length()<6){
            response.getWriter().write("too short name or password");
            return;
        }

        UserService userService=new UserServiceImpl();
        User user=userService.findUserByName(username);
        response.setContentType("application/json");
        ObjectMapper objectMapper=new ObjectMapper();
        if(user!=null){
            objectMapper.writeValue(response.getWriter(),"user name is in use,please change");
        }else {
            objectMapper.writeValue(response.getWriter(),"available");
        }
    }
    public void CheckCaptcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        Object captcha=session.getAttribute("captcha");
        String captcha_ajax =request.getParameter("captcha_ajax");
        ObjectMapper objectMapper=new ObjectMapper();
        if(captcha.toString().equalsIgnoreCase(captcha_ajax)){
            objectMapper.writeValue(response.getWriter(), Boolean.TRUE);
        }else {
            objectMapper.writeValue(response.getWriter(), Boolean.FALSE);
        }

    }
}
