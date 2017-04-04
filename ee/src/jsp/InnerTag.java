package jsp;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class InnerTag extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
//        JspTag parent = getParent();
        SimpleTag simpleTag = (SimpleTag) findAncestorWithClass(this, SimpleTag.class);
        if (simpleTag == null) {
            throw new JspTagException("nesting error");
        }
        JspContext jspContext = getJspContext();
        JspWriter out = jspContext.getOut();
        out.print(simpleTag.getName());
    }
}
