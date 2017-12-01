<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
test
<%--Hello <security:authentication property="principal.username"/>--%>
    <%--<a href="logout">logout</a>--%>
<%--<security:authorize access="isAuthenticated()">--%>
    <%--this is infor for logged users--%>
<%--</security:authorize>--%>
<%--<security:authorize access="hasRole('ADMIN')">--%>
    <%--this is infor for admins--%>
<%--</security:authorize>--%>
<%--<security:authorize access="hasRole('MODERATOR')">--%>
    <%--this is infor for moderator--%>
<%--</security:authorize>--%>
<%--<security:authorize access="isAuthenticated() and hasRole('ADMIN')">--%>
    <%--INFO for admins that logged id--%>
<%--</security:authorize>--%>
<%--<security:authorize url="/admin">--%>
    <%--<spring:url value="/admin" var="admin_var"/>--%>
    <%--<a href="${admin_var}">go to admin</a>--%>
<%--</security:authorize>--%>
</body>
</html>
