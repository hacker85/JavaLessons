package ee.jsf;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Navigate {
    public String goToNewPage() {
        return "NewPage.xhtml";
    }
}
