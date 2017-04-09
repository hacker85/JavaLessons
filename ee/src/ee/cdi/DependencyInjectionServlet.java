package ee.cdi;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cdi")
public class DependencyInjectionServlet extends HttpServlet {
    @Inject
    @Default
    Student student;

    @Inject
    DependencyInjectionServlet(Student student) {
        this.student = student;

    }

    @Inject
    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write(student.toString());
    }
}

@Default
class Student {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}