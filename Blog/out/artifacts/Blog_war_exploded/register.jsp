<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: galaxy
  Date: 19-3-10
  Time: 下午1:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="utf-8" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
    <title>My Blog</title>
</head>
<body>
    <%
        List<String> erros = (List<String>) request.getAttribute("errors");
        if (erros!=null)
        {
    %>
        <h1>新增会员失败</h1>
        <ul style="color: aqua;">
            <%
                for (String error:erros)
                {
            %>
            <li><%=error%></li>
            <%}%>
        </ul><br>
    <%}%>

    <h1>会员注册</h1>
    <form method='post' action='register.do'>
        <table bgcolor=#cccccc>
            <tr>
                <td>邮件地址：</td>
                <td><input type='text' name='email' value='${param.email}' size='25' maxlength='100'>
                </td>
            </tr>
            <tr>
                <td>名称（最大16字符）：</td>
                <td><input type='text' name='username' value='${param.username}' size='25' maxlength='16'></td>
            </tr>
            <tr>
                <td>密码（6到16字符）：</td>
                <td><input type='password' name='password' size='25' maxlength='16'>
                </td>
            </tr>
            <tr>
                <td>确认密码：</td>
                <td><input type='password' name='confirmedPasswd' size='25' maxlength='16'></td>
            </tr>
            <tr>
                <td colspan='2' align='center'><input type='submit' value='注册'></td>
            </tr>
        </table>
    </form>
</body>
</html>
