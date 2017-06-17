package ee.websockets;

import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/clientState")
public class ClientStateLesson {
    @OnMessage
    public void onMessage(Session session, String msg) {
        String name = session.getUserProperties().get("name").toString();
        System.out.println(name);
        session.getUserProperties().put("name", "Max");
    }
}
