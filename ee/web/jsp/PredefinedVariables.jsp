<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%=request.getMethod()%>
    <%=response.setStatus(HttpServletResponse.SC_OK)%>
    <%=session.getAttribute("one")%>
    <%=application.getAttribute("")%>
    <%=application.getServerInfo()%>
    <%=application.getServletContextName()%>
    <%=config.getServletContext()%>
</body>
</html>
