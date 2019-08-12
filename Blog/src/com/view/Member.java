package com.view;
import com.model.UserService;

import java.text.DateFormat;
import java.util.*;
import java.io.*;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/member.view")
public class Member extends HttpServlet {
    private final String USERS = "/home/galaxy/apk/users";
    private final String LOGIN_VIEW = "index.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute("login") == null) {
            response.sendRedirect(LOGIN_VIEW);
            return;
        }

        String username = (String) request.getSession().getAttribute("login");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<meta http-equiv='Content-type' content='text/html;charset=UTF-8'>");
        out.println("<title>Gossip</title>");
        out.println("<link rel='stylesheet' href='css/member.css' type='text/css'>");
        out.println("</head>");
        out.println("<body>");

        out.println("<div class='leftPanel'>");
        out.println("<img src='caterpillar.jpg' alt='Gossip'/><br><br>");
        out.println("<a href='logout.do?username=" + username + "'>注销 " + username + "</a>");

        out.println("</div>");
        out.println("<form method='post' action='message.do'>");
        out.println("分享新鲜事...<br>");
        String blabla = request.getParameter("blabla");
        if(blabla == null) {
            blabla = "";
        } else {
            out.println("讯息要140字以内");
        }
        out.println("<textarea cols='60' rows='4' name='blabla'>" + blabla + "</textarea>");
        out.println("<br>");
        out.println("<button type='submit'>送出</button>");
        out.println("</form>");
        out.println("<table style='text-align: left; width: 510px; height: 88px;' border='5' cellpadding='2' cellspacing='2'>");
        out.println("<thead>");
        out.println("<tr><th><hr></th></tr>");
        out.println("</thead>");
        out.println("<tbody>");

        UserService userService = (UserService) getServletContext().getAttribute("userService");
        Map<Date, String> messages = userService.readMessage(username);
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, Locale.TAIWAN);
        for(Date date : messages.keySet()) {
            out.println("<tr><td style='vertical-align: top;'>");
            out.println(username + "<br>");
            out.println(messages.get(date) + "<br>");
            out.println(dateFormat.format(date));
            out.println("<a href='delete.do?message=" + date.getTime() +"'>删除</a>");
            out.println("<hr></td></tr>");
        }
        out.println("</tbody>");
        out.println("</table>");
        out.println("<hr style='width: 100%; height: 1px;'>");
        out.println("</body>");
        out.println("</html>");
        out.close();


    }

    private class TxtFilenameFilter implements FilenameFilter {
        @Override
        public boolean accept(File dir, String name) {

            return name.endsWith(".txt");
        }
    }

    private TxtFilenameFilter filenameFilter = new TxtFilenameFilter();

    public class DateComparator implements Comparator<Date> {
        @Override
        public int compare(Date d1, Date d2) {

            return -d1.compareTo(d2);
        }
    }

    private DateComparator comparator = new DateComparator();

//    private Map<Date, String> readMessage(String username) throws IOException {
//        File border = new File(USERS + "/" + username);
//        String[] txts = border.list(filenameFilter);
//
//        Map<Date, String>messages = new TreeMap<Date, String>(comparator);
//        for(String txt : txts) {
//            BufferedReader reader = new BufferedReader(
//                    new InputStreamReader(new FileInputStream(USERS + "/" + username + "/" + txt), "UTF-8"));
//            String text = null;
//            StringBuilder builder = new StringBuilder();
//            while((text = reader.readLine()) != null) {
//                builder.append(text);
//            }
//            Date date = new Date(Long.parseLong(txt.substring(0, txt.indexOf(".txt"))));
//            messages.put(date, builder.toString());
//            reader.close();
//        }
//        return messages;
//    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

}