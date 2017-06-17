package ee.jaxrs;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/returnTypes")
@Produces(MediaType.TEXT_PLAIN)
public class ReturnTypesLesson {
    @GET
    @Path("/string")
    @Produces(MediaType.TEXT_PLAIN)
//    @Produces({"image/jpeg,image/png"})
    public String getString() {
        return "hello";
    }
    @GET
    @Path("/string2")
//    @Produces("text/plain")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    public String sayHello() {
        return "Hello";
    }

    @GET
    @Path("/int")
    @Produces(MediaType.TEXT_PLAIN)
    public int getInt() {
        return 5;
    }

    @GET
    @Path("/xml")
    @Produces(MediaType.APPLICATION_XML)
    public Student getAsXML() {
        return new Student("Max");
    }

    @GET
    @Path("/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAsJson() {
        return Response.ok(new Student("Max"), MediaType.APPLICATION_JSON).build();
    }
}

abstract class A{
    A() {

    }
}