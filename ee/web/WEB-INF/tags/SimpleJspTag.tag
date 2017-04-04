<%@ attribute name="name" required="false" %>
<b>hello world</b></br>
<b><%=name%></b></br>
<%
    out.print("<b>");
    getJspBody().invoke(null);
    out.print("</b>");
%>