<%@ page import="jsp.JSPHelper" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    hello world
    <!--html comment-->
<%--this is comment--%>
    <%! int i = 5; %>
    <%! private void doThings() {
        System.out.println("hello");
    }%>
    <%= 1 + 1 + 1 + i %>
    <%
    class Calc {
        int add(int a, int b) {
            Math.random();
            return a + b;
        }
    }
    %>
    <%= new Calc().add(1,2)%>
    <%= JSPHelper.minux(5,1)%>
    <%--<%= servlets.ServletUtils.doJob()%>--%>
    <%= Math.random()%>
    <%= new Date()%>
    <% if(Math.random() > 0.5) { %>
    hello
    <% }%>
</body>
</html>
