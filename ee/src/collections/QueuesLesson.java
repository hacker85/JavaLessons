package collections;

import java.util.*;

public class QueuesLesson {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        Deque<String> deque = new LinkedList<>();
        Queue<String> priorityQueue = new PriorityQueue<>();
        Deque<String> arrayDeque = new ArrayDeque<>();
        priorityQueue.add("a");
        priorityQueue.add("c");
        priorityQueue.add("b");
        while (priorityQueue.size() != 0)
        {
            System.out.println(priorityQueue.remove());
        }
    }
}
