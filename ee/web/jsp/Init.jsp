<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    init jsp
    <%!
        public void jspInit()
        {
            System.out.println("initialize jsp");
        };
        public void jspDestroy() {
            System.out.println("destroy jsp");
        }
    %>
</body>
</html>
