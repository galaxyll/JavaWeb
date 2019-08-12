package com.controller;

import com.model.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@WebServlet(
        urlPatterns = {"/login.do"},
        initParams = {@WebInitParam(name = "SUCCESS_VIEW",value = "message.do"),
                      @WebInitParam(name = "ERROR_VIEW",value = "index.jsp")
        }
)

public class Login extends HttpServlet{

    private  String USERS ;
    private  String SUCCESS_VIEW ;
    private  String ERROR_VIEW ;

    public void init() throws ServletException
    {
        SUCCESS_VIEW = getServletConfig().getInitParameter("SUCCESS_VIEW");
        ERROR_VIEW = getServletConfig().getInitParameter("ERROR_VIEW");
    }

    protected void doPost(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException{

        request.setCharacterEncoding("UTF-8");
        UserService userService = (UserService) getServletContext().getAttribute("userService");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String page = ERROR_VIEW;
        if (userService.checkLogin(username,password)){
            request.getSession().setAttribute("login",username);
            page = SUCCESS_VIEW;
        }else {
            request.setAttribute("error","名称或密码错误!");
            page = ERROR_VIEW;
        }

        request.getRequestDispatcher(page).forward(request,response);
           // response.sendRedirect(page);
    }

//    private boolean checkLogin(String username,String password)
//            throws IOException{
//        if (username!=null && password!=null){
//            for (String file : new File(USERS).list()){
//                if(file.equals(username)){
//                    BufferedReader reader = new BufferedReader(new FileReader(USERS+"/"+file+"/profile"));
//                    String passwd = reader.readLine().split("\t")[1];
//                    if (passwd.equals(password)){
//                        return true;
//                    }
//                }
//            }
//        }
//        return false;
//    }
}