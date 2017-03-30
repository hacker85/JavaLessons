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
    <jsp:setProperty name="stud" property="name" value="Max"/>
    <% stud.setName("Max"); %>
    <jsp:getProperty name="stud" property="name"/>
    <%= stud.getName() %>
    <jsp:setProperty name="stud" property="name" value="<%= "some value" %>"/>
    <jsp:setProperty name="stud" property="name" value="<%= request.getParameter("name") %>"/>
    <jsp:setProperty name="stud" property="*"/>
    <jsp:useBean id="stud" class="jsp.Student" scope="session"><jsp:setProperty name="stud" property="name" value="Max"/></jsp:useBean>
</body>
</html>
