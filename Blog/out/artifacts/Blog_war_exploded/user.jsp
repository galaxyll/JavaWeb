<%--
  Created by IntelliJ IDEA.
  User: galaxy
  Date: 19-3-10
  Time: 下午2:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" import="java.util.*,java.text.*,com.model.*" %>
<html>
<head>
    <title>others blog</title>
</head>
<body>
    <%
        List<Blah> blahs = (List<Blah>) request.getAttribute("blahs");
        if (blahs!=null){
    %>
        <div>
            <br><br>${requestScope.username} 's Blog
        </div>
        <table style="text-align: left; width: 510px;height: 88px;" border="0" cellpadding="2" cellspacing="2">
            <thead>
            <tr>
                <th><hr></th>
            </tr>
            </thead>
            <tbody>
                <%
                    DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL,Locale.CHINA);
                    for (Blah blah:blahs)
                    {
                %>
                        <tr>
                            <td style="vertical-align: top;">
                                <%= blah.getUsername()%><br>
                                <%= blah.getTxt()%><br>
                                <%= dateFormat.format(blah.getDate().getTime())%>
                                <hr>
                            </td>
                        </tr>
                <%}%>
            </tbody>
        </table>
    <hr style="width: 100%; height: 1px;">
<%}else {%>
<h1 style="color: aqua">${requestScope.username} User is not exists</h1>
<%}%>
</body>
</html>
