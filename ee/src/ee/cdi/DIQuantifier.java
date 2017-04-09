package ee.cdi;

import javax.inject.Inject;
import javax.inject.Qualifier;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@WebServlet("/diq")
public class DIQuantifier extends HttpServlet {
    @Inject
    @ChildOneQualifier
    Parent parent;

    @Inject
    @ChildTwoQualifier
    Parent parent2;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write(parent.doJob());
    }
}

@Qualifier
@Retention(RUNTIME)
@Target({FIELD, TYPE, METHOD})
@interface ChildOneQualifier { }

@Qualifier
@Retention(RUNTIME)
@Target({FIELD, TYPE, METHOD})
@interface ChildTwoQualifier { }

interface Parent {
    String doJob();
}

@ChildOneQualifier
class ChildOne implements Parent {
    @Override
    public String doJob() {
        return "one";
    }
}
@ChildTwoQualifier
class ChildTwo implements Parent {
    @Override
    public String doJob() {
        return "two";
    }
}