package ee.websockets;

import javax.websocket.*;
import java.io.IOException;
import java.net.URI;
import java.nio.ByteBuffer;

@ClientEndpoint
public class ClientLesson {
    @OnOpen
    public void onOpen(Session session) {
        System.out.println("Connected");
    }

    @OnMessage
    public void onMessage(String message) {
        System.out.println("Received msg: " + message);
    }

    @OnMessage
    public void binaryMessage(Session session, ByteBuffer msg) {
        System.out.println("Binary message: " + msg.toString());
    }
    @OnMessage
    public void pongMessage(Session session, PongMessage msg) {
        System.out.println("Pong message: " + msg.getApplicationData().toString());
    }

    @OnClose
    public void onClose(Session session) {
        System.out.println("close");
    }

    public static void main(String[] args) throws InterruptedException, IOException, DeploymentException, EncodeException {
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        Session session = container.connectToServer(ClientLesson.class, URI.create("ws://localhost:8080/messageLesson"));
//        Session session = container.connectToServer(ClientLesson.class, URI.create("ws://localhost:8080/paramsEndpoint/test"));
        session.getBasicRemote().sendText("hello world");
        session.getBasicRemote().sendText("hohoho");
        byte[] bytes = "hello world".getBytes();
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        session.getBasicRemote().sendPing(byteBuffer);
        session.getBasicRemote().sendBinary(byteBuffer);
        Thread.sleep(1000);
        session.close();
    }
}
