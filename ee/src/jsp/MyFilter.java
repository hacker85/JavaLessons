package jsp;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;

public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println(filterConfig.getInitParameter("name"));
        System.out.println("init filter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.getServletContext().log("this is log message");
        System.out.println(servletRequest.getRemoteHost());
        servletResponse.getWriter().write("before ");
        if(true) {
            filterChain.doFilter(servletRequest, new MyWrapper((HttpServletResponse)servletResponse));
        }
        servletResponse.getWriter().write(" after");
    }

    @Override
    public void destroy() {
        System.out.println("destroy filter");
    }
}
class MyWrapper extends HttpServletResponseWrapper {
    public MyWrapper(HttpServletResponse response) {
        super(response);
    }
}
