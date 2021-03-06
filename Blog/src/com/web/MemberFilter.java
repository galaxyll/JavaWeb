package com.web;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(
        urlPatterns = {"/delete.do","/logout.do","/message.do","/member.do"},
        initParams = {@WebInitParam(name = "LOGIN_VIEW",value = "index.jsp")}
)

public class MemberFilter implements Filter {
    private String LOGIN_VIEW;
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)req;
        request.setCharacterEncoding("UTF-8");
        if (request.getSession().getAttribute("login")!=null)
            chain.doFilter(req, resp);
        else {
            HttpServletResponse response = (HttpServletResponse)resp;
            response.sendRedirect(LOGIN_VIEW);
        }
    }

    public void init(FilterConfig config) throws ServletException {
        this.LOGIN_VIEW = config.getInitParameter("LOGIN_VIEW");
    }

}
