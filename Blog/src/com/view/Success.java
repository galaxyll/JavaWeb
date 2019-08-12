package com.view;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/success.view")

public class Success extends HttpServlet{
    protected void doPost(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException{
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<html><head><meta content='text/html;charset=utf-8' http-equiv='content-type'>");
        out.println("<title>新增会员成功</title></head>");
        out.println("<body><h1>新增会员成功</h1></body>");
        out.println("<ul style='color:rgb(255,0,0);'>");

        out.println("</ul>");
        out.println("<a href='index.jsp'>返回登录页面</a>");
        out.println("</body></html>");
        out.close();
    }
}