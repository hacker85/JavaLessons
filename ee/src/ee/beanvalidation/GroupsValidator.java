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
import javax.validation.groups.Default;
import java.io.IOException;
import java.util.Set;

@WebServlet("/groupValidator")
public class GroupsValidator extends HttpServlet {
    @Inject
    Validator validator;
    @Inject
    GroupsStrings groupsStrings;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        groupsStrings.s = "";
        groupsStrings.s2 = "";
        groupsStrings.s3 = null;
        groupsStrings.s4 = null;

        Set<ConstraintViolation<GroupsStrings>> name = validator.validate(groupsStrings, Group1.class);
        for (ConstraintViolation violation : name) {
            System.out.println(violation.getMessage());
            System.out.println(violation.getInvalidValue());
        }
    }
}

interface Group1 {}
interface Group2 {}
interface Group3 {}

class GroupsStrings {
    @NotNull(groups = Group1.class)
    String s;
    @NotNull(groups = {Group1.class,Group2.class,Default.class})
    String s2;
    @NotNull(groups = Group3.class)
    String s3;
    @NotNull(groups = Default.class) //the same as @NutNull
    String s4;
}
