package jsp;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class SimpleTag extends SimpleTagSupport {
    String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspContext jspContext = getJspContext();
        JspWriter out = jspContext.getOut();
        getJspContext().setAttribute("name", "Max");
        out.print("<b>hello world</b><br/>");
        out.print("<b>" + name + "</b><br/>");
        out.print("<b>");
        getJspBody().invoke(null);
        out.print("</br></b>");

//        StringWriter stringWriter = new StringWriter();
//        getJspBody().invoke(stringWriter);
//        String body = stringWriter.toString();
//        out.print("<b>" + body + "</b><br/>");
    }
}
