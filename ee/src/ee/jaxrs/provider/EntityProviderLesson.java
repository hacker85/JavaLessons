package ee.jaxrs.provider;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/entityProvider")
public class EntityProviderLesson {
    @GET
    @Produces("my/format")
    public Student getCustomStudent() {
        return new Student("Max", "22");
    }
    @GET
    @Consumes("my/format")
    @Path("/getName/")
    public String getCustomStudent(Student student) {
        return student.getName();
    }
}