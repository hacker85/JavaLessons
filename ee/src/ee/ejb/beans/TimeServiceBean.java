package ee.ejb.beans;

import javax.annotation.Resource;
import javax.ejb.*;

@Singleton
public class TimeServiceBean {
//    @Resource
//    SessionContext sessionContext;
    @Resource
    TimerService timerService;
    public void setTimer() {
//        TimerService timerService = sessionContext.getTimerService();
        ScheduleExpression sayHello = new ScheduleExpression().second("*").minute("*").hour("*").dayOfMonth("*").month("*").year("*");
        timerService.createCalendarTimer(sayHello, new TimerConfig("this is serialized Object", false));
    }
    @Timeout
    public void sendBirthdayEmail(Timer timer) {
        System.out.println("it's time");
        System.out.println(timer.getInfo());
    }
//    @Schedule(second = "*", minute = "*", hour = "*", persistent = false)
    void print() {
        System.out.println("it worked");
    }
}
