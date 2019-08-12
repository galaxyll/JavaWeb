<%--
  Created by IntelliJ IDEA.
  User: galaxy
  Date: 19-3-10
  Time: 下午2:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta content="text/html; charset=UTF-8">
    <title>My blog</title>
</head>
<body>
<div>
    <a href='register.jsp'>还不是会员?</a>
    <p>
    <div style="color: aqua;">${requestScope.error}</div>
    <form method='post' action='login.do'>
        <tr>
            <td colspan='2'>会员登录</td>
        <tr>
            <td>名称：</td>
            <td><input type='text' name='username' value="${parm.username}"></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type='password' name='password' ></td>
        </tr>
        <tr>
            <td colspan='2' align='center'><input type='submit' value='登入'></td>
        </tr>

        </table>
    </form>
</div>
</body>
</html>
