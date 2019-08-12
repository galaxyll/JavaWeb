package com.controller;

import com.model.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(
        urlPatterns = {"/register.do"},
        initParams = {
                @WebInitParam(name = "SUCCESS_VIEW",value = "success.jsp"),
                @WebInitParam(name = "ERROR_VIEW",value = "error.jsp")
        })
public class Register extends HttpServlet{

    private  String USERS ;
    private  String SUCCESS_VIEW ;
    private  String ERROR_VIEW ;

    @Override
    public void init() throws ServletException{

        SUCCESS_VIEW = getServletConfig().getInitParameter("SUCCESS_VIEW");
        ERROR_VIEW = getServletConfig().getInitParameter("ERROR_VIEW");

    }

    public void doPost(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException{

        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmedPasswd = request.getParameter("confirmedPasswd");

        UserService userService = (UserService) getServletContext().getAttribute("userService");


        List<String> errors  = new ArrayList<String>();
        if (isInvalidEmail(email)){
            errors.add("未填写邮箱或格式不正确");

        }
        if (userService.isInvalidUsername(username)){
            errors.add("用户名为空或用户已存在");

        }
        if (isInvalidPassword(password,confirmedPasswd)){
            errors.add("请确认密码是否正确");
            System.out.println(password);
            System.out.println(confirmedPasswd);
        }
        String resultPage = ERROR_VIEW;
        if (!errors.isEmpty()){
            request.setAttribute("errors",errors);
        }
        else{
            resultPage = SUCCESS_VIEW;
            userService.createUserData(email,username,password);
        }

        request.getRequestDispatcher(resultPage).forward(request,response);

    }

    private boolean isInvalidEmail(String email)
    {
        return email == null || !email.matches("^[_a-z0-9-]+([.]"+"[_a-z0-9-]+)*@[a-z0-9-]+([.][a-z0-9-]+)*$");
    }


//    private boolean isInvalidUsername(String username)
//    {
//        File files = new File(USERS);
//        if (files==null)
//            return false;
//        for (String file : files.list())
//        {
//            if (file.equals(username))
//            {
//                return true;
//            }
//        }
//        return false;
//    }


    private boolean isInvalidPassword(String password,String confirmePasswd)
    {
        return password == null || password.length()<6 || password.length()>16 || !password.equals(confirmePasswd);
    }

//    private void createUserData(String email,String username,String password) throws IOException{
//        File userhome = new File (USERS+"/"+username);
//        userhome.mkdir();
//        BufferedWriter writer = new BufferedWriter(new FileWriter(userhome+"/profile"));
//        writer.write(email+"\t"+password);
//        writer.close();
//    }
}