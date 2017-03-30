<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%@ include file="hello.jsp" %>
    <%= i %>
    <jsp:include page="Included.jsp" />
    <jsp:include page="/jsp/Included.jsp" />
    <jsp:include page="/WEB-INF/Inc.jsp" flush="true" />
    <jsp:include page="/hello" />
    <jsp:include page="/WEB-INF/text.txt" />
    <%--<%= k %>--%>
</body>
</html>
