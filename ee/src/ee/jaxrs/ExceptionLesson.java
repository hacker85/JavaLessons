package ee.jaxrs;

import javax.persistence.EntityNotFoundException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Path("/exceptionRest")
public class ExceptionLesson {
    @GET
    @Path("/{name}")
    public String getName(@PathParam("name") String name) throws EntityNotFoundException {
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
            throw new EntityNotFoundException();
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
