package ee.beanvalidation;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.*;
import java.io.IOException;
import java.util.Date;

@WebServlet("/comstraints")
public class Constraints extends HttpServlet {
    @Inject
    Student student;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(student.name);
        System.out.println(student.age);
        System.out.println(student.description);
    }
}

class Student {
    @NotNull
    @Pattern.List({
            @Pattern(regexp = "[A-Z][a-z]*"),
            @Pattern(regexp = "")
    })
    String name;
    @Min(18)
    int age;
    @Size(max = 200,min = 10)
    String description;
    @Past
    Date bithDate;
    @Future
    Date dathDate;
    String sername;
    @NotNull
    public String getSername() {
        return sername;
    }
    public void setSername(@NotNull @Pattern(regexp = "[A-Z]") String sername) {
        this.sername = sername;
    }
}