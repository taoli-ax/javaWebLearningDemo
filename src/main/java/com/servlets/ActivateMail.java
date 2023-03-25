package com.servlets;

import com.POJO.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.services.Impl.UserServiceImpl;
import com.services.UserService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;

@WebServlet("/mail/*")
public class ActivateMail extends BaseServlet{

    public void activate(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String code = req.getParameter("code");

        UserService userService =  new UserServiceImpl();
        User user=userService.FindUserByActivateCode(code);


        resp.setContentType("text/html;charset=utf-8");
        ObjectMapper objectMapper=new ObjectMapper();
        if(user!=null){
            objectMapper.writeValue(resp.getWriter(),"<h4>邮箱激活成功</h4><br><a href='http://localhost:8080/JWeb04/index1.jsp'>去登陆</a>");

            HashMap<String,String>map=new HashMap<>();
            map.put("status","1");
            map.put("name",user.getName());
            userService.updateUserStatus(map);

        }else {
            objectMapper.writeValue(resp.getWriter(),"连接错误或超时失效，请重新发送");
        }




    }
}
