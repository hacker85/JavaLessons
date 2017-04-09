<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
    response.setHeader("Pragma", "no-cache");
    if (request.getRemoteUser() != null) {
        response.sendRedirect("/logout");
    }
%>
<form action="j_security_check" method="post">
    User title: <input type="text" title="j_username"/><br/>
    Password: <input type="password" title="j_password"/><br/>
    <input type="submit" value="log in"/>
</form>
</body>
</html>
