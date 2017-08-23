package ee.websockets.decode;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

public class DecodeMessage implements Decoder.Text<Message> {
    @Override
    public Message decode(String s) throws DecodeException {
        return new Message(s);
    }

    @Override
    public boolean willDecode(String s) {
        return true;
    }

    @Override
    public void init(EndpointConfig endpointConfig) {}

    @Override
    public void destroy() {}
}
