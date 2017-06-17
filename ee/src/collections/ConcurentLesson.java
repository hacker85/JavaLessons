package collections;

import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

public class ConcurentLesson {
    public static void main(String[] args) {
        List<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        Set<String> copyOnWriteArraySet = new CopyOnWriteArraySet<>();
        BlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<>();
        BlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(5);
        BlockingQueue<String> priorityBlockingQueue = new PriorityBlockingQueue<>();
//        BlockingQueue<String> delayQueue = new DelayQueue<>();
        BlockingQueue<String> synchronousQueue = new SynchronousQueue<>();
        TransferQueue<String> transferQueue2 = new LinkedTransferQueue<>();
        BlockingDeque<String> blockingDeque = new LinkedBlockingDeque<>();
        ConcurrentMap<String,String> concurrentMap = new ConcurrentHashMap();
    }
}
