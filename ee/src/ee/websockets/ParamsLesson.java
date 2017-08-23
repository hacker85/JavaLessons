package ee.websockets;

import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@ServerEndpoint("/paramsEndpoint/{param}")
public class ParamsLesson {
    @OnMessage
    public void onMessage(Session session, String msg, @PathParam("param") String param) throws IOException {
        System.out.println(param);
        System.out.println(msg);
        session.getBasicRemote().sendText(param);
    }
}
