package com.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String Uri=req.getRequestURI();
        String MethodUri=Uri.substring(Uri.lastIndexOf('/')+1);
        // 字节码文件对象获取，然后类的反射
//        Class.forName("")
        System.out.println(this);
        Class<? extends BaseServlet> clazz=this.getClass();
        try {
            Method method= clazz.getMethod(MethodUri,HttpServletRequest.class,HttpServletResponse.class);
            method.invoke(this,req,resp);
        } catch (Exception e) {
            System.out.println("Exception:"+e);
            Throwable cause = e.getCause();
            if (cause != null) {
                cause.printStackTrace();}

            throw new RuntimeException("servlet执行异常");
        }

    }
}
