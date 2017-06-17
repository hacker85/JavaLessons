package ee.jaxrs.provider;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

@Provider
@Produces("my/format")
public class CustomStudentWriter implements MessageBodyWriter<Student> {

    @Override
    public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return Student.class.isAssignableFrom(type);
    }
    @Override
    public void writeTo(Student student, Class<?> type, Type gType, Annotation[]
            annotations, MediaType mediaType, MultivaluedMap<String, Object> httpHeaders,
                        OutputStream outputStream) throws IOException, WebApplicationException {
        outputStream.write(student.getName().getBytes());
        outputStream.write('/');
        outputStream.write(student.getAge().getBytes());
    }
    @Override
    public long getSize(Student student, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return student.getName().length() + 1 + student.getAge().length();
    }
}