package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/status")
public class StatusServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.sendRedirect("/temp");//302
        resp.sendError(HttpServletResponse.SC_NOT_FOUND, "someting wend wrong");

        resp.setHeader("Refresh", "1");
        resp.setHeader("Refresh", "5;URL=https://google.com");
        resp.containsHeader("Refresh");
        resp.setContentType("");
        resp.setContentLength(1000);

//        resp.setIntHeader("Refresh", 1);

    }
}
