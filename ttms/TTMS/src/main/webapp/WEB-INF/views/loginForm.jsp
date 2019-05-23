<%--
  Created by IntelliJ IDEA.
  User: galaxy
  Date: 19-5-20
  Time: 下午10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
    <h3>登录页面</h3>
    <form action="${pageContext.request.contextPath}/login" method="post">
        <table>
            <tr>
                <td><label>登录名：</label></td>
                <td><input type="text" id="username" name="username"></td>
            </tr>
            <tr><td><label>密码：</label></td></tr>
            <tr><td><input type="password" id="password" name="password"></td></tr>
            <tr><td><input type="submit" value="登录"></td></tr>
        </table>
    </form>
</body>
</html>
