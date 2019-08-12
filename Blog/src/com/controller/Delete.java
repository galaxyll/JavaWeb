package com.controller;

import com.model.Blah;
import com.model.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/delete.do"},
            initParams = {@WebInitParam(name = "SUCCESS_VIEW",value = "message.do")}
)

public class Delete extends HttpServlet {

    private  String SUCCESS_VIEW ;

    public void init()throws ServletException
    {
        SUCCESS_VIEW = getServletConfig().getInitParameter("SUCCESS_VIEW");
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        UserService userService  = (UserService) getServletContext().getAttribute("userService");
        String username = (String) request.getSession().getAttribute("login");
        String message = request.getParameter("message");
        userService.deleteMessage(username,message);

        response.sendRedirect(SUCCESS_VIEW);
    }
}