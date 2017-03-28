package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Map;

@WebServlet("/parameters")
public class ParametersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getParameter("one"));
        String[] value = req.getParameterValues("one");
        for (String s : value) {
            System.out.println(s);
        }
        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            System.out.println(parameterNames.nextElement());
        }
        Map<String, String[]> parameterMap = req.getParameterMap();
        System.out.println(req.getParameter("bla"));
        req.setCharacterEncoding("UTF-8");
        System.out.println(req.getQueryString());
        System.out.println(req.getRequestURI());
        System.out.println(req.getRequestURL());
        System.out.println(req.getServletPath());
        System.out.println(req.getRemoteHost());
        try(BufferedReader reader = req.getReader()) {
            StringBuilder builder = new StringBuilder();
            String line;
            while((line = reader.readLine()) != null){
                builder.append(line);
            }
            System.out.println(builder);
        }
        InputStream inputStream = req.getInputStream();
        StringBuilder builder = new StringBuilder();
        int c;
        while ((c = inputStream.read()) != -1) {
            builder.append((char) c);
        }
        System.out.println(builder);


        resp.getWriter().write("<html>" +
                "<header><title>This is title</title></header>" +
                "<body>" +
                "<form method='get' action='parameters'>" +
                "<input type='text' name='one'/>" +
                "<input type='text' name='one'/>" +
                "<input type='text' name='two'/>" +
                "<input type='submit' value='submit'/>" +
                "</form>" +
                "</body>" +
                "</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}