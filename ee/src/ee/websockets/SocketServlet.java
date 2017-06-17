package ee.websockets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.ServerEndpointConfig;
import java.io.IOException;

@WebServlet("/runSocket")
public class SocketServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServerEndpointConfig.Builder.create(ProgrammaticEndpointLesson.class, "/echo").build();
    }
}
