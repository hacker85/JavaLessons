package advanced;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

public class StackAndQueueLesson {
    public static void main(String[] args) {
        Stack<String> stack = new Stack();
        stack.push("one");
        stack.push("two");
        System.out.println(stack.peek());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println("----------------");

        Queue<String> queue = new PriorityQueue<>();
        queue.add("one");
        queue.offer("two");
        queue.offer("three");
        queue.offer("four");
        queue.remove("two");
        queue.remove("two");
        queue.remove();
        for(String s : queue) {
            System.out.println(s);
        }
        System.out.println("---------");
        System.out.println(queue.peek());
        System.out.println(queue.element());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println("-------");

        ArrayQueue<String> arrayQueue = new ArrayQueue<>(10);
        arrayQueue.add("One");
        arrayQueue.add("Two");
        boolean b = arrayQueue.remove("One");
        arrayQueue.get(0);

        ArrayDeque<String> arrayDeque = new ArrayDeque<>(10);
        LinkedList<String> linkedList = new LinkedList<>();
        arrayDeque.add("one");
        arrayDeque.offer("two");
        arrayDeque.push("three");
        arrayDeque.addFirst("zero");
        arrayDeque.addLast("four");
        for(String s : arrayDeque) {
            System.out.println(s);
        }
        //remove
        arrayDeque.remove();
        arrayDeque.pop();
        ///get
        arrayDeque.element();
        arrayDeque.peek();
        arrayDeque.getFirst();
        //get and remove
        arrayDeque.poll();

    }
}
