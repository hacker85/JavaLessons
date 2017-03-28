package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

@WebServlet("/singleThread")
public class SingleThreadServlet extends HttpServlet  {//implements SingleThreadModel
    static int i = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        synchronized (SingleThreadServlet.class) {
            for (int j = 0; j < 1_000_000; j++) {
                i++;
            }
            System.out.println(Thread.currentThread().getName());
            System.out.println(i);
        }
    }

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 100; i++) {
            new Thread() {
                @Override
                public void run() {
                    URLConnection urlConnection = null;
                    try {
                        urlConnection = new URL("http://localhost:8080/temp").openConnection();
                        urlConnection.getInputStream();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }
}