package ee.beanvalidation;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.io.IOException;
import java.util.Set;

@WebServlet("/descriptionValidate")
public class DescriptionValidate extends HttpServlet {
    @Inject
    Validator validator;
    @Inject
    StudentClass studentClass;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Set<ConstraintViolation<StudentClass>> name = validator.validate(studentClass);
        for (ConstraintViolation violation : name) {
            System.out.println(violation.getMessage());
            System.out.println(violation.getInvalidValue());
        }
    }
}
class StudentClass {
    String name;
    int age;
    String description;
}