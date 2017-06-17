package ee.jaxws.container;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import java.io.IOException;

@WebServlet("/tempServlet")
public class WSContainerServlet extends HttpServlet {
    @WebServiceRef
    ContainerService containerService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write(containerService.sayHello());
    }
}
