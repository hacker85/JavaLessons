<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--title = ${requestScope.get("stud").title}--%>
    <%--${sessionScope}--%>
    <%--${applicationScope}--%>
    <%--<jsp:useBean id="Student" class="jsp.Student" ><jsp:setProperty title="Student" property="title" value="Alex"/> </jsp:useBean>--%>
    ${stud.title}
    ${stud["title"]}

names: ${names[1]}
map: ${map[one]}
map: ${map.one}
${1 + 2 + 3 * 5 / 2}
${stud.title == "hello"}
${ 5 > 4}
${ true && false }
${ true ? hello : world }
<jsp:setProperty title="stud" property="title" value="${Mr}.${Max}"/>
\${hello}

${pageContext.session.id}
${param.get("title")}
${param.title}
${header.get("")}
${cookie.get("JSESSIONID").value}
${initParam.get("")}
</body>
</html>
