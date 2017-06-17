package ee.jaxrs;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;

public class UriBuilderLesson {
    public static void main(String[] args) {
        URI uri = UriBuilder.fromUri("http:/localhost").path("book").path("1234").queryParam("author", "Goncalves").build();
        uri = UriBuilder.fromUri("http:/localhost").path("book").path("1234").matrixParam("author", "Goncalves").build();
        uri = UriBuilder.fromUri("http:/localhost").path("{path}").queryParam("author", "{value}").build("book", "Goncalves");
        uri = UriBuilder.fromResource(Student.class).path("1234").build();
        uri = UriBuilder.fromUri("http://www.myserver.com").fragment("book").build();
        System.out.println(uri);
    }
}
