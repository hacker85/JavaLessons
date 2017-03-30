package servlets;

import jsp.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/controller")
public class Controller extends HttpServlet {
    Model model = new Model();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student student = model.getData();
        req.setAttribute("student", student);
        req.getSession().setAttribute("sutdent", student);
        req.getServletContext().setAttribute("student", student);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/View.jsp");
        requestDispatcher.forward(req, resp);
        //post cant forwart to html, need to rename to jsp
    }
}
