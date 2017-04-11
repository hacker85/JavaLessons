package ee.beanvalidation;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.Set;

@WebServlet("/inheritanceValidation")
public class InheritanceValidation extends HttpServlet {
    @Inject
    Validator validator;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Set<ConstraintViolation<Child>> name = validator.validateValue(Child.class, "name", null);
        for (ConstraintViolation violation : name) {
            System.out.println(violation.getMessage());
            System.out.println(violation.getInvalidValue());
        }
    }
}
class Parent {
    @NotNull
    protected String name;
}
class Child extends Parent {
    String getName() {
        return name;
    }
    void setName(String name) {
        this.name = name;
    }
}