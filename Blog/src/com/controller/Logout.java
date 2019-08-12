package com.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        urlPatterns = {"/logout.do"},
        initParams = {@WebInitParam(name = "LOGOUT_VIEW",value = "index.jsp")}
)

public class Logout extends HttpServlet {
    private  String LOGIN_VIEW ;

    public void init() throws ServletException
    {
        LOGIN_VIEW = getServletConfig().getInitParameter("LOGIN_VIEW");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.sendRedirect(LOGIN_VIEW);
        request.getSession().invalidate();

    }
}
