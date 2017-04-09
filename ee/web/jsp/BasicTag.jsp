<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/tld/SimpleTagDescriptor.tld" prefix="simple"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="simpleJsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <simple:HelloWorldTag title="Max">
        yohoho ${title} 5 - 4 = ${simple:Minus(5, 4)}
        <simple:InnerTag>

        </simple:InnerTag>
    </simple:HelloWorldTag>
    <simpleJsp:SimpleJspTag title="Max">yohoho</simpleJsp:SimpleJspTag>
</body>
</html>
