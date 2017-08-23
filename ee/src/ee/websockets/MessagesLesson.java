package ee.websockets;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.nio.ByteBuffer;

@ServerEndpoint("/messageLesson")
public class MessagesLesson {
    @OnOpen
    public void onOpen(Session session) {
        session.getUserProperties().put("previousMsg", " ");
    }
    @OnMessage
    public void onMessage(Session session, String msg) throws IOException {
        String prev = (String) session.getUserProperties().get("previousMsg");
        session.getUserProperties().put("previousMsg", msg);
        session.getBasicRemote().sendText(prev);
    }
    @OnMessage
    public void binaryMessage(Session session, ByteBuffer msg) throws IOException {
        System.out.println("Binary message: " + msg.toString());
        session.getBasicRemote().sendBinary(msg);
    }
    @OnMessage
    public void pongMessage(Session session, PongMessage msg) {
        System.out.println("Pong message: " + msg.getApplicationData().toString());
    }
    @OnClose
    public void onClose(Session session) {
    }
    @OnError
    public void error(Session session, Throwable t) {
        t.printStackTrace();
    }
}
