package patterns.web;

import java.util.ArrayList;
import java.util.List;

public class InterceptingFilterLesson {
    public static void main(String[] args) {
        FilterManager filterManager = new FilterManager(new Target());
        filterManager.setFilter(new AuthenticationFilter());
        filterManager.setFilter(new DebugFilter());
        filterManager.filterRequest("HOME");
    }
}
interface Filter {
    void execute(String request);
}

class AuthenticationFilter implements Filter {
    public void execute(String request) {
        System.out.println("Authenticating request: " + request);
    }
}
class DebugFilter implements Filter {
    public void execute(String request){
        System.out.println("request log: " + request);
    }
}

class Target {
    public void execute(String request){
        System.out.println("Executing request: " + request);
    }
}
class FilterChain {
    private List<Filter> filters = new ArrayList<Filter>();
    private Target target;
    public void addFilter(Filter filter){
        filters.add(filter);
    }
    public void execute(String request){
        for (Filter filter : filters) {
            filter.execute(request);
        }
        target.execute(request);
    }
    public void setTarget(Target target){
        this.target = target;
    }
}
class FilterManager {
    FilterChain filterChain = new FilterChain();
    public FilterManager(Target target){
        filterChain.setTarget(target);
    }
    public void setFilter(Filter filter){
        filterChain.addFilter(filter);
    }
    public void filterRequest(String request){
        filterChain.execute(request);
    }
}