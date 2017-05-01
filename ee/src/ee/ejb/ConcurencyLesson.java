package ee.ejb;

import ee.ejb.beans.ConcurencyBean;

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

@WebServlet("/concurencyLesson")
public class ConcurencyLesson extends HttpServlet {
    @EJB
    ConcurencyBean concurencyBean;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write(concurencyBean.increseAndGetI() + " ");
//        resp.getWriter().write(concurencyBean.setI(concurencyBean.getI() + 1) + " ");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread() {
                @Override
                public void run() {
                    URLConnection urlConnection = null;
                    try {
                        urlConnection = new URL("http://localhost:8080/concurencyLesson").openConnection();
                        Scanner scanner = new Scanner(urlConnection.getInputStream());
                        while(scanner.hasNext()) {
                            System.out.println(scanner.next());
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }
}
