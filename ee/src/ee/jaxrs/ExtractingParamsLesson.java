package ee.jaxrs;

import javax.ws.rs.*;

@Path("/extract")
@Produces("text/plain")
public class ExtractingParamsLesson {
    //[^/]+?
    @GET
    @Path("/{id}/")
    public String returnId(@PathParam("id") String id) {
        return id;
    }
    @GET
    @Path("/id/{id}")
    public String returnById(@PathParam("id") String id) {
        return "id = " + id;
    }
    @GET
    @Path("userName/{name: [a-zA-Z]*}")
    public String getName(@PathParam("name") String name) {
        return "name is " + name;
    }

    @GET
    @Path("/age/")
    public String getAge(@QueryParam("userAge") int userAge) {
        return "user age " + userAge;
    }

    @GET
    @Path("/city/")
    public String getCity(@DefaultValue("Kiev") @MatrixParam("userCity") String city) {
        return "City is " + city;
    }

    @GET
    @Path("/sessionId/")
    public String extractSessionID(@DefaultValue("null") @CookieParam("sessionID") String sessionID) {
        return sessionID;
    }
    @GET
    @Path("/userAgent")
    public String extractUserAgent(@HeaderParam("User-Agent") String userAgent) {
        return userAgent;
    }
    @POST
    @Path("/form")
    public String extractForm(@FormParam("test") String test) {
        return "test value is: " + test;
    }
}
