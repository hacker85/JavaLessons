package ee.jaxrs;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;

public class CallRestLesson {
    public static void main(String[] args) throws URISyntaxException {
        Client client = ClientBuilder.newClient();
//        URI uri = new URI("http://localhost:8080/exceptionRest/Max");
//        WebTarget target = client.target(uri);
        WebTarget target = client.target("http://localhost:8080/exceptionRest/Max");
        Invocation invocation = target.request().buildGet();
        target.request().buildDelete();
        target.path("userId").resolveTemplate("userId", "1").request().buildGet();
        target.queryParam("author", "Eloise").request().buildGet();
        target.request(MediaType.APPLICATION_XML).buildGet();
        target.request(MediaType.APPLICATION_XML).acceptLanguage("pt").buildGet();
        target.request().buildPost(Entity.entity("Max", "text/plain"));

        Response response = invocation.invoke();
        if(response.getStatusInfo().getStatusCode() == Response.Status.OK.getStatusCode()) {
            System.out.println(response.readEntity(String.class));
        }

        System.out.println(client.target("").request().get(String.class));

        client.close();
    }
}
