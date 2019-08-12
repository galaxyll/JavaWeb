<%--
  Created by IntelliJ IDEA.
  User: galaxy
  Date: 19-3-10
  Time: 上午10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="utf-8" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>

<html>
<head>
    <title>ERROR!</title>
</head>
<body>
<h1>新增会员失败</h1>
<ul style="color: rgb(255,0,0);">

    <%
        List<String> errors = (List<String>) request.getAttribute("errors");
        for (String error:errors){
    %>
    <li><%= error%>></li>
    <%
        }
    %>
</ul>
<a href="register.jsp">返回注册页面</a>
</body>
</html>
