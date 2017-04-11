package ee.beanvalidation;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Set;

@WebServlet("/classValidation")
public class ClassValidation extends HttpServlet {
    @Inject
    Order order;
    @Inject
    Validator validator;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        order.setCreationDate(LocalDate.of(2017, 01, 01));
        order.setPaymentDate(LocalDate.of(2017, 01, 02));
        order.setDeliveryDate(LocalDate.of(2017, 01, 01));

        Set<ConstraintViolation<Order>> constraintViolations = validator.validate(order);
        for (ConstraintViolation violation : constraintViolations) {
            System.out.println(violation.getMessage());
            System.out.println(violation.getInvalidValue());
        }
    }
}

@ChronologicalDates
class Order {
    private LocalDate creationDate;
    private LocalDate paymentDate;
    private LocalDate deliveryDate;

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
}

class ChronologicalDatesValidator implements ConstraintValidator<ChronologicalDates, Order> {

    @Override
    public void initialize(ChronologicalDates constraintAnnotation) {
    }
    @Override
    public boolean isValid(Order order, ConstraintValidatorContext context) {
        return order.getCreationDate().isBefore(order.getPaymentDate()) &&
        order.getPaymentDate().isBefore(order.getDeliveryDate());
    }
}