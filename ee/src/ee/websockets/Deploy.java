package ee.websockets;

import javax.websocket.server.ServerEndpointConfig;

public class Deploy {
    public static void main(String[] args) {
        ServerEndpointConfig.Builder.create(ProgrammaticEndpointLesson.class, "/echo").build();
    }
}
