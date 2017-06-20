package lombok;

import lombok.extern.java.Log;

@Log
//@Slf4j
//@CommonsLog(topic="CounterLog")
public class LoggerLesson {
    public static void main(String[] args) {
        log.warning("test warning");
    }
}
