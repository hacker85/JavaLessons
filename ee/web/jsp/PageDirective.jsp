<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<%--<%@ page session="false" %>--%>
<%@ page isELIgnored="true" %>
<%@ page buffer="8kb" %>
<%@ page autoFlush="true" %>
<%@ page info="some message" %>
<%@ page errorPage="hello.jsp" %>
<%@ page isErrorPage="true" %>
<%@ page isThreadSafe="true" %>
<%--<%@ page extends="HttpServlet" %>--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%= new Date() %>
    <%= 1/0 %>
    hello
</body>
</html>
