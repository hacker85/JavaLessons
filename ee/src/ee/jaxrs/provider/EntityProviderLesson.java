package ee.jaxrs.provider;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/entityProvider")
public class EntityProviderLesson {
    @GET
    @Produces("my/format")
    public Student getCustomStudent() {
        return new Student("Max", "22");
    }
    @POST
    @Consumes("my/format")
    @Path("/getName/")
    @Produces(MediaType.TEXT_PLAIN)
    public String getCustomStudent(Student student) {
        return student.getName();
    }
}