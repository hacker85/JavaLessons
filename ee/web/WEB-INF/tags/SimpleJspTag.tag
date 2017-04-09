<%@ attribute title="title" required="false" %>
<b>hello world</b></br>
<b><%=title%></b></br>
<%
    out.print("<b>");
    getJspBody().invoke(null);
    out.print("</b>");
%>