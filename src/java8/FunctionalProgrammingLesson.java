package java8;

import sun.plugin2.message.Conversation;
import sun.plugin2.message.Message;
import sun.plugin2.message.Serializer;

import java.io.IOException;
import java.nio.channels.Channel;
import java.util.Date;
import java.util.function.Function;

public class FunctionalProgrammingLesson {
    public static void main(String[] args) {
        for(String s : args) {

        }

    }

    public int square(int x) {
        return x * x;
    }

    public void processNext() {
        Message message = InboxQueue.popMessage();

        if (message != null) {
            process(message);
        }
    }

    public boolean processMessage(Channel channel) {
        //...
        return true || false;
    }

    public Program getCurrentProgram(TVGuide guide, int channel) {
        Schedule schedule = guide.getSchedule(channel);

        Program current = schedule.programAt(new Date());

        return current;
    }

    public Program getProgramAt(TVGuide guide, int channel, Date when) {
        Schedule schedule = guide.getSchedule(channel);

        Program program = schedule.programAt(when);

        return program;
    }

    Function<Integer,Integer> add1 = x -> x * x;

    void process(Message message) {

    }
}











class Schedule{
    public Program programAt(Date date) {
        return new Program();
    }
}

class TVGuide{
    public Schedule getSchedule(int ch) {return new Schedule();}

}

class Program{

}


class InboxQueue {
    static Message popMessage() {
        return new Message(5, new Conversation()) {
            @Override
            public void writeFields(Serializer serializer) throws IOException {

            }

            @Override
            public void readFields(Serializer serializer) throws IOException {

            }
        };
    }
}