package ee.cdi;

import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.inject.Qualifier;
import javax.inject.Singleton;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@WebServlet("/eventEx")
public class EventExample extends HttpServlet {
    @Inject
    BookService bookService;
    @Inject
    InventoryService inventoryService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book inferno = new Book("Inferno");
        bookService.addBook(inferno);
        bookService.addBook(new Book("Code DaVinchi"));
        bookService.removeBook(inferno);
        System.out.println(inventoryService.inventory.size());
    }
}

class Book {
    String title;

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

@Qualifier
@Retention(RUNTIME)
@Target({FIELD, TYPE, METHOD, PARAMETER})
@interface Added {}

@Qualifier
@Retention(RUNTIME)
@Target({FIELD, TYPE, METHOD, PARAMETER})
@interface Removed {}

class BookService {
    @Inject
    @Added
    private Event<Book> addEvent;
    @Inject
    @Removed
    private Event<Book> removedEvent;
    public void addBook(Book book) {
        addEvent.fire(book);
    }
    public void removeBook(Book book) {
        removedEvent.fire(book);
    }
}
@Singleton
class InventoryService {
    List<Book> inventory = new ArrayList<>();
    public void addBook(@Observes @Added Book book) {
        System.out.println("add book to inventory " + book.getTitle());
        inventory.add(book);
    }
    public void removeBook(@Observes @Removed Book book) {
        System.out.println("remove book from inventory " + book.getTitle());
        inventory.remove(book);
    }
}