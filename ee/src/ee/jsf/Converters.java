package ee.jsf;

import javax.faces.bean.ManagedBean;
import java.util.Date;

@ManagedBean
public class Converters {
    float price;
    Date date;
    String euro;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEuro() {
        return euro;
    }

    public void setEuro(String euro) {
        this.euro = euro;
    }

    public void print() {
        System.out.println("price: " + price);
        System.out.println("date: " + date);
        System.out.println("euro: " + euro);
    }
}
