package ee.beanvalidation;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.executable.ExecutableValidator;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Set;

@WebServlet("/validationExample")
public class ValidationExample extends HttpServlet {
    @Inject
    Validator validator;
    @Inject
    NewStudent student;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        student.name = "max";

        Set<ConstraintViolation<NewStudent>> validate = validator.validate(student);
        if(validate.size() > 0) {
            System.out.println("there was error");
        }
        for(ConstraintViolation<NewStudent> violation : validate) {
            System.out.println(violation.getMessage());
            System.out.println(violation.getInvalidValue());
        }

        Set<ConstraintViolation<NewStudent>> name = validator.validateProperty(student, "name");

        Set<? extends ConstraintViolation<? extends NewStudent>> max = validator.validateValue(student.getClass(), "name", "max");
        if(max.size() > 0) {
            System.out.println("max is not correct");
        }

        try {
            Method setName = NewStudent.class.getMethod("setName", String.class);
            ExecutableValidator executableValidator = validator.forExecutables();
            Set<ConstraintViolation<NewStudent>> constraintViolations = executableValidator.validateParameters(student, setName, new Object[]{null});
            if(constraintViolations.size() > 0) {
                System.out.println("wrong setName parameter");
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        factory.close();
    }
}
class NewStudent {
    @Pattern(regexp = "[A-Z][a-z]*")
    String name;
    @Min(18)
    int age;

    public void setName(@NotNull String name) {
        this.name = name;
    }
}