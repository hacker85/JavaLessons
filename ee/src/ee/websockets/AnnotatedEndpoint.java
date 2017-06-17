package ee.websockets;

import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@ServerEndpoint("/echoEndpoint")
public class AnnotatedEndpoint {
    @OnMessage
    public void onMessage(Session session, String msg) throws IOException {
        session.getBasicRemote().sendText(msg);
    }
}
