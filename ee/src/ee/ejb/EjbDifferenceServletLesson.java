package ee.ejb;

import ee.ejb.beans.EjbDifferenceSessionBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

@WebServlet("/ejbDifference")
public class EjbDifferenceServletLesson extends HttpServlet {
    @EJB
    EjbDifferenceSessionBean ejbDifferenceSessionBean;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write(ejbDifferenceSessionBean.getI() + " ");
        ejbDifferenceSessionBean.setI(ejbDifferenceSessionBean.getI() + 1);
    }

    public static void main(String[] args) throws IOException {
        URLConnection urlConnection = new URL("http://localhost:8080/ejbDifference").openConnection();
        Scanner scanner = new Scanner(urlConnection.getInputStream());
        while (scanner.hasNext()) {
            System.out.println(scanner.next());
        }
    }
}