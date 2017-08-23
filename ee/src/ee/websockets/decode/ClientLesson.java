package ee.websockets.decode;

import javax.websocket.*;
import java.io.IOException;
import java.net.URI;

@ClientEndpoint(encoders = EncodeMessage.class, decoders = DecodeMessage.class)
public class ClientLesson {
    @OnMessage
    public void onMessage(Message message) {
        System.out.println("Received msg: " + message.s);
    }

    @OnClose
    public void onClose(Session session) {
        System.out.println("close");
    }

    public static void main(String[] args) throws InterruptedException, IOException, DeploymentException, EncodeException {
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        Session session = container.connectToServer(ClientLesson.class, URI.create("ws://localhost:8080/decodeEndpoint"));

        Message message = new Message("hello world");
        session.getBasicRemote().sendObject(message);

        Thread.sleep(1000);
        session.close();
    }
}
