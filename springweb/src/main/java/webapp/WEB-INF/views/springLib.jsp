<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<sf:form method="POST" commandName="user">
    Name: <sf:input path="name" /><br/>
    Age: <sf:input path="age" /><br/>
    <input type="submit" value="Submit" />
</sf:form>
</body>
</html>
