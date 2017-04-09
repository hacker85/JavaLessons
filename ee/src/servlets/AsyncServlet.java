package servlets;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/syncServlet", asyncSupported = true)
public class AsyncServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AsyncContext asyncContext = req.startAsync();
        //do job
        asyncContext.complete();

        AsyncContext asyncContext2 = req.getAsyncContext();
        asyncContext2.start(new Runnable() {
            @Override
            public void run() {
                //awaid event
            }
        });
        asyncContext2.complete();
    }
}
