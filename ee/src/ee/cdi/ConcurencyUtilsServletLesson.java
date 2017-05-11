package ee.cdi;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.concurrent.ManagedScheduledExecutorService;
import javax.enterprise.concurrent.ManagedThreadFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.Callable;

@WebServlet("/concurencyUtilsLesson")
public class ConcurencyUtilsServletLesson extends HttpServlet {
    @Resource
    ManagedExecutorService managedExecutorService;
    @Resource
    ManagedScheduledExecutorService managedScheduledExecutorService;
    @Resource
    ManagedThreadFactory managedThreadFactory;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        managedExecutorService.submit(new MyRunnuble());
        try {
            System.out.println(managedExecutorService.submit(new MyCallble()).get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    class MyRunnuble implements Runnable {
        @Override
        public void run() {
            System.out.println(1);
        }
    }
    class MyCallble<T> implements Callable<String> {
        @Override
        public String call() throws Exception {
            return "2";
        }
    }
}
