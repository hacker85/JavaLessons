package ee.cdi;

import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Qualifier;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@WebServlet("/did")
public class Disposers extends HttpServlet {
    @Inject
    @Greetings
    private GreetingCardImpl greetingCard;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        greetingCard.sayHello();
    }
}

class GreetingCardImpl {
    public void sayHello() {
        System.out.println("Hello!!!");
    }
    public void sayGoodBye() {
        System.out.println("GoodBye!!!");

    }
}
@Qualifier
@Retention(RUNTIME)
@interface Greetings {}

class GreetingCardFactory {
    @Produces
    @Greetings
    public GreetingCardImpl getGreetingCard() {
        GreetingCardImpl greetingCard = new GreetingCardImpl();
        greetingCard.sayHello();
        return greetingCard;
    }
    public void disposeGreetingCard(@Disposes @Greetings  GreetingCardImpl greetingCard) {
        greetingCard.sayGoodBye();
    }
}
