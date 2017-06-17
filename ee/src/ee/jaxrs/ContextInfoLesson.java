package ee.jaxrs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.*;
import javax.ws.rs.ext.Providers;

@Path("/contextInfo")
public class ContextInfoLesson {
    @Context
    UriInfo uriInfo;
    @GET
    public String getString(@Context HttpHeaders headers, @Context Request request, @Context SecurityContext securityContext, @Context Providers providers) {
        return "Hello";
    }
}
