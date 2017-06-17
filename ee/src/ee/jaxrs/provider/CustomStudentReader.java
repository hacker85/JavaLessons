package ee.jaxrs.provider;

import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Scanner;
import java.util.StringTokenizer;

@Provider
@Consumes("my/format")
public class CustomStudentReader implements MessageBodyReader<Student> {
    @Override
    public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return Student.class.isAssignableFrom(type);
    }
    @Override
    public Student readFrom(Class<Student> type, Type gType, Annotation[] annotations,
                             MediaType mediaType, MultivaluedMap<String, String> httpHeaders,
                             InputStream inputStream) throws IOException, WebApplicationException {
        String str = convertStreamToString(inputStream);
        StringTokenizer s = new StringTokenizer(str, "/");
        Student student = new Student();
        student.setName(s.nextToken());
        student.setAge(s.nextToken());
        return student;
    }

    private String convertStreamToString(InputStream inputStream) {
        Scanner s = new Scanner(inputStream).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
}
