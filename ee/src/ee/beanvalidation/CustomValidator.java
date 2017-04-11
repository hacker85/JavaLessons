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

@WebServlet("/customValidator")
public class CustomValidator extends HttpServlet {
    @Inject
    Validator validator;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Set<ConstraintViolation<StudentA>> emailValidation = validator.validateValue(StudentA.class, "email", "mymail@gmail.com");
        for(ConstraintViolation<StudentA> violation : emailValidation) {
            System.out.println(violation.getMessage());
            System.out.println(violation.getInvalidValue());
        }
        Set<ConstraintViolation<StudentA>> emailValidation2 = validator.validateValue(StudentA.class, "email", "mymail@gmail.ru");
        for(ConstraintViolation<StudentA> violation : emailValidation2) {
            System.out.println(violation.getMessage());
            System.out.println(violation.getInvalidValue());
        }
    }
}
class StudentA {
    @Email
    String email;
}