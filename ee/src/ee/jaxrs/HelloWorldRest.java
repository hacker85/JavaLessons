package ee.jaxrs;

import javax.ws.rs.*;

@Path("/rest")
public class HelloWorldRest {
    @GET
    public String sayHello() {
        return "Hello";
    }

    @GET
    @Path("/get")
    public String getGet() {
        return "Get";
    }

    @POST
    public String getPost() {
        return "Post";
    }

    @GET
    public String getString() {
        return "test";
    }

    @HEAD
//    @PUT
//    @DELETE
//    @OPTIONS
    public void getHead() {
    }
}
