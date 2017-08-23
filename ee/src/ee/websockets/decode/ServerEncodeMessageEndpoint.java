package ee.websockets.decode;

import javax.websocket.EncodeException;
import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@ServerEndpoint(value = "/decodeEndpoint", decoders = DecodeMessage.class, encoders = EncodeMessage.class)
public class ServerEncodeMessageEndpoint {
    @OnMessage
    public void onMessage(Session session, Message message) throws IOException, EncodeException {
        System.out.println(message.s);
        session.getBasicRemote().sendObject(message);
    }
}
