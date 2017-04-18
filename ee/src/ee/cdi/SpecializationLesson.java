package ee.cdi;

import javax.enterprise.inject.Specializes;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/spec")
public class SpecializationLesson extends HttpServlet {
    @Inject
    Spec spec;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        spec.print();
    }
}
class Spec {
    public void print() {
        System.out.println("spec");
    }
}
class ASpec extends Spec {
    public void print() {
        System.out.println("a");
    }
}
@Specializes
class BSpec extends ASpec {
    @Override
    public void print() {
        System.out.println("b");
    }
}