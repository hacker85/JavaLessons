package ee.jsf;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Validations {
    double price;
    String title;
    String custom;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCustom() {
        return custom;
    }

    public void setCustom(String custom) {
        this.custom = custom;
    }

    public void print() {
        System.out.println(custom);
    }
}
