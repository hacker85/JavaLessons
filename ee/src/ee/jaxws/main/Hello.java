package ee.jaxws.main;

import javax.jws.WebService;

@WebService
public interface Hello {
    String print(String name);
    boolean checkStudent(Student student);
}
