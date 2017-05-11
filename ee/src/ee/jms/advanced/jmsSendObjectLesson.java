package ee.jms.advanced;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

@WebServlet("/jmsSendObjectLesson")
public class jmsSendObjectLesson extends HttpServlet {
    @Inject
    private JMSContext context;
    @Resource(name = "queue")
    private Queue queue;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        context.createProducer().send(queue, new Student("Max"));
        Student student = context.createConsumer(queue).receiveBody(Student.class);
        System.out.println(student.name);
    }
}

class Student implements Serializable {
    String name;

    public Student(String name) {
        this.name = name;
    }
}