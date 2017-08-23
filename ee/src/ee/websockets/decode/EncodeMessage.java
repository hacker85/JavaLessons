package ee.websockets.decode;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class EncodeMessage implements Encoder.Text<Message> {
    @Override
    public String encode(Message message) throws EncodeException {
        return message.s;
    }

    @Override
    public void init(EndpointConfig endpointConfig) {}

    @Override
    public void destroy() {}
}
