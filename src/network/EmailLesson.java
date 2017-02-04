package network;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Properties;

public class EmailLesson {
    public static void main(String[] args) throws IOException, MessagingException {
        final Properties properties = new Properties();
        properties.load(EmailLesson.class.getClassLoader().getResourceAsStream("mail.properties"));

        Session mailSession = Session.getDefaultInstance(properties);
        MimeMessage message = new MimeMessage(mailSession);
        message.setFrom(new InternetAddress("myemail"));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress("youremail@mail.ru "));
        message.setSubject("hello");
        message.setText("Hi this is my test message");

        Transport tr = mailSession.getTransport();
        tr.connect(null, "123");
        tr.sendMessage(message, message.getAllRecipients());
        tr.close();
    }
}
