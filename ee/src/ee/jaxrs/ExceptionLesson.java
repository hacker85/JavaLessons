package ee.jaxrs;

import javax.persistence.EntityNotFoundException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Path("/exceptionRest")
public class ExceptionLesson {
    @GET
    @Path("/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getName(@PathParam("name") String name) throws IOException {
        if(name.equals("Max")) {
//            throw new ServletException();
//            throw new WebServiceException();
//            throw new WebApplicationException();

//            throw new BadRequestException();
//            throw new ForbiddenException();
//            throw new NotAcceptableException();
//            throw new NotAllowedException("wrond credentials");
//            throw new NotAuthorizedException("wrond credentials");
//            throw new NotFoundException();
//            throw new NotSupportedException();
            throw new IOException("qwer");
        } else if(name.equals("Mike")) {
            throw new RuntimeException("asdf");
        }
        return name;
    }
}

@Provider
class EntityNotFoundMapper implements ExceptionMapper<EntityNotFoundException> {

    public Response toResponse(EntityNotFoundException ex) {
        return Response.status(404).entity(ex.getMessage()).type(MediaType.TEXT_PLAIN).build();
    }
}
