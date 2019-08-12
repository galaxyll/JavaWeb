<%--
  Created by IntelliJ IDEA.
  User: galaxy
  Date: 19-3-10
  Time: 上午10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*,java.text.*,com.model.UserService" %>
<%@ page import="com.model.Blah" %>
<%@ page pageEncoding="utf-8" %>
<% String username = (String)request.getSession().getAttribute("login");%>

<html>
<head>
    <meta content="text/html;charset=utf-8" http-equiv="content-type">
    <title>My Blog</title>
</head>
<body>
    <div>
        <br><br>
        <a href="logout.do?username="${sessionScope.login}">注销${sessionScope.login}</a>
    </div>
    <form method="post" action="message.do">
        分享新鲜事...<br>
        <%String blabla =  (String) request.getAttribute("blabla");
          if (blabla != null)
          {
        %>
            字数要在140字以内:<br>
        <%}%>
        <textarea name="blabla" id="" cols="30" rows="10">${requestScope.blabla}</textarea><br>
        <button type="submit">发出</button>
    </form>
    <table style="text-align: left;width: 510px;height: 88px;" border="0" cellpadding="2" cellspacing="2">
        <thead>
            <tr>
                <th><hr></th>
            </tr>
        </thead>
        <tbody>
        <%
            //UserService userService = (UserService) getServletConfig().getServletContext().getAttribute("userService");
            //Map<Date,String> messages = userService.readMessage(username);
            DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL,Locale.CHINA);
            List<Blah> blahs = (List<Blah>) request.getAttribute("blahs");
            if (blahs!=null){
            for (Blah blah:blahs){
        %>

        <tr>
            <td style="vertical-align: top;">
                <%= blah.getUsername()%><br>
                <%= blah.getTxt()%><br>
                <%= dateFormat.format(blah.getDate())%>
                <a href="delete.do?message=<%=blah.getDate().getTime()%>">删除</a>
                <hr>
            </td>
        </tr>
        <%}}%>

            <%--for (Date date:messages.keySet()){--%>
        <%--%>--%>
                <%--<tr>--%>
                    <%--<td style="vertical-align: top;">--%>
                        <%--<%=username%> <br>--%>
                        <%--<%=messages.get(date)%> <br>--%>
                        <%--<%=dateFormat.format(date)%>--%>
                        <%--<a href="delete.do?message=<%=date.getTime()%>">删除</a>--%>
                        <%--<hr>--%>
                    <%--</td>--%>
                <%--</tr>--%>
        <%--<%}%>--%>
        </tbody>
    </table>
    <hr style="width: 100%;height: 1px;">
</body>
</html>
