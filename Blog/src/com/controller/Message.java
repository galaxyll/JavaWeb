package com.controller;

import com.model.Blah;
import com.model.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

@WebServlet(urlPatterns = {"/message.do"},
            initParams = {
        @WebInitParam(name = "SUCCESS_VIEW",value = "member.jsp"),
        @WebInitParam(name = "ERROR_VIEW",value = "member.jsp")
            }
)

public class Message extends HttpServlet {

    private  String SUCCESS_VIEW ;
    private  String ERROR_VIEW ;

    public void init()throws ServletException
    {
        SUCCESS_VIEW = getServletConfig().getInitParameter("SUCCESS_VIEW");
        ERROR_VIEW = getServletConfig().getInitParameter("ERROR_VIEW");
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserService userService = (UserService)getServletContext().getAttribute("userService");
        String blabla = request.getParameter("blabla");
        Blah blah = new Blah();
        String username = (String) request.getSession().getAttribute("login");
        blah.setUsername(username);
        if(blabla != null && blabla.length() != 0) {
            if(blabla.length() < 140) {

                blah.setDate(new Date());

                blah.setTxt(blabla);
                userService.addBlah(blah);
                //userService.addMessage(username, blabla);
                //response.sendRedirect(SUCCESS_VIEW);
            } else {
                request.setAttribute("blabla",blabla);
            }
        }

        List<Blah> blahs = userService.getBlahs(blah);
        request.setAttribute("blahs",blahs);
        request.getRequestDispatcher(SUCCESS_VIEW).forward(request,response);
    }
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

}