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
import java.net.MalformedURLException;
import java.util.Set;

@WebServlet("/customValidator2")
public class CustomValidator2 extends HttpServlet {
    @Inject
    Validator validator;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Set<ConstraintViolation<Site>> url = validator.validateValue(Site.class, "resourceURL", "asddfsdaf");
        for (ConstraintViolation violation : url) {
            System.out.println(violation.getMessage());
            System.out.println(violation.getInvalidValue());
        }
        Set<ConstraintViolation<Site>> url2 = validator.validateValue(Site.class, "url", "https://www.mysite.com");
        for (ConstraintViolation violation : url2) {
            System.out.println(violation.getMessage());
            System.out.println(violation.getInvalidValue());
        }
        Set<ConstraintViolation<Site>> url3 = validator.validateValue(Site.class, "itemURL", "https://www.mysite.com");
        for (ConstraintViolation violation : url3) {
            System.out.println(violation.getMessage());
            System.out.println(violation.getInvalidValue());
        }
        Set<ConstraintViolation<Site>> url4 = validator.validateValue(Site.class, "ftpServerURL", "ftp://www.mysite.com:22");
        for (ConstraintViolation violation : url4) {
            System.out.println(violation.getMessage());
            System.out.println(violation.getInvalidValue());
        }
    }
}
class Site {
    @URL
    private String resourceURL;
    @URL(host = "myhost")
    private String url;
    @URL(protocol = "http", host = "www.mysite.com")
    private String itemURL;
    @URL(protocol = "ftp", port = 21)
    private String ftpServerURL;
}

class URLValidator implements ConstraintValidator<URL, String> {

    private String protocol;
    private String host;
    private int port;

    public void initialize(URL url) {
        this.protocol = url.protocol();
        this.host = url.host();
        this.port = url.port();
    }

    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.length() == 0) {
            return true;
        }
        java.net.URL url;
        try {
            url = new java.net.URL(value);
        } catch (MalformedURLException e) {
            return false;
        }

        if (protocol != null && protocol.length() > 0 && !url.getProtocol().equals(protocol)) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Invalid protocol").addConstraintViolation();
            return false;
        }

        if (host != null && host.length() > 0 && !url.getHost().startsWith(host) ) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Invalid host").addConstraintViolation();
            return false;
        }

        if (port != -1 && url.getPort() != port) {
//            context.disableDefaultConstraintViolation();
//            context.buildConstraintViolationWithTemplate("Invalid port").addConstraintViolation();
            return false;
        }

        return true;
    }
}