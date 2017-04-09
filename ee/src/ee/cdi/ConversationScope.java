package ee.cdi;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

@WebServlet("/cs")
public class ConversationScope extends HttpServlet {
    @Inject
    ConversationBean conversationBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(conversationBean.i);
        conversationBean.i = 1;
        conversationBean.conversationStart();
        System.out.println(conversationBean.i);
        conversationBean.i = 2;
        System.out.println("middle conversation");
        conversationBean.conversationStop();
        System.out.println(conversationBean.i);

    }
}
@ConversationScoped
class ConversationBean implements Serializable {
    int i;
    @Inject
    Conversation conversation;
    public void conversationStart() {
        System.out.println("start conversation");
        conversation.begin();
        i = 3;
    }
    public void conversationStop() {
        System.out.println(i);
        System.out.println("conversation stoped");
        conversation.end();
    }
}