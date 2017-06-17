package ee.jaxws.main;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Student {
    int avarageMark;

    public Student() {
    }

    public Student(int avarageMark) {
        this.avarageMark = avarageMark;
    }
}
