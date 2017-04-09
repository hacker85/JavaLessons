<%@ page import="jsp.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <jsp:useBean id="thread" class="jsp.MyThread" type="java.lang.Runnable"/>
    <jsp:useBean id="stud" class="jsp.Student" scope="session"/>
    <% Student student = new Student(); %>
    <jsp:setProperty title="stud" property="title" value="Max"/>
    <% stud.setName("Max"); %>
    <jsp:getProperty title="stud" property="title"/>
    <%= stud.getName() %>
    <jsp:setProperty title="stud" property="title" value="<%= "some value" %>"/>
    <jsp:setProperty title="stud" property="title" value="<%= request.getParameter("title") %>"/>
    <jsp:setProperty title="stud" property="*"/>
    <jsp:useBean id="stud" class="jsp.Student" scope="session"><jsp:setProperty title="stud" property="title" value="Max"/></jsp:useBean>
</body>
</html>
