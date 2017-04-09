package ee.cdi;

import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;
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
import java.util.Random;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@WebServlet("/dip")
public class DIProducers extends HttpServlet {
    @Inject
    String one;
    @Inject
    @Str
    String string;
    @Inject
    int i;
    @Inject
    double d;
    @Inject
    Stud stud;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write(one + " " + string + " " + i + " " + d + " " + stud.name);
    }
}

@Qualifier
@Retention(RUNTIME)
@Target({FIELD, TYPE, METHOD})
@interface Str { }


class InjectableValues {
    @Produces
    @Default
    private String one = "one";
    @Produces
    @Str
    private String str = "two";
    @Produces @Default
    private int two = 2;
    @Produces
    public double random() {
        return Math.abs(new Random().nextInt());
    }
    public Stud getStudent() {
        return new Stud();
    }
}

class Stud {
    String name = "Max";
}