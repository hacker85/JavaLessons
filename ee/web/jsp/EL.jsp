<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--name = ${requestScope.get("stud").name}--%>
    <%--${sessionScope}--%>
    <%--${applicationScope}--%>
    <%--<jsp:useBean id="Student" class="jsp.Student" ><jsp:setProperty name="Student" property="name" value="Alex"/> </jsp:useBean>--%>
    ${stud.name}
    ${stud["name"]}

names: ${names[1]}
map: ${map[one]}
map: ${map.one}
${1 + 2 + 3 * 5 / 2}
${stud.name == "hello"}
${ 5 > 4}
${ true && false }
${ true ? hello : world }
<jsp:setProperty name="stud" property="name" value="${Mr}.${Max}"/>
\${hello}

${pageContext.session.id}
${param.get("name")}
${param.name}
${header.get("")}
${cookie.get("JSESSIONID").value}
${initParam.get("")}
</body>
</html>
