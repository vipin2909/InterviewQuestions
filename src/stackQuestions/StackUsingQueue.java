package stackQuestions;

import java.util.ArrayDeque;
import java.util.Queue;

// implementing a stack using two queues;
public class StackUsingQueue<T> {

    Queue<T> queue1, queue2;

    public StackUsingQueue() {
        queue1 = new ArrayDeque<>();
        queue2 = new ArrayDeque<>();
    }

    void add(T x) {
        while(!queue1.isEmpty()) {
            queue2.add(queue1.peek());
            queue1.poll();
        }
        queue1.add(x);
        while(!queue2.isEmpty()) {
            queue1.add(queue2.peek());
            queue2.poll();
        }
    }

    public T pop() {
        if(queue1.isEmpty()) {
            System.out.println("Underflow !!");
            System.exit(0);
        }

        T frontOfQueue = queue1.peek();
        queue1.poll();
        return frontOfQueue;
    }

    public static void main(String[] args) {
        int[] keys = {1, 2, 3, 4, 5, 6};
        StackUsingQueue<Integer> s = new StackUsingQueue<>();
        for(int key: keys) {
            s.add(key);
        }
        // to pop() the top element of the stack using pop() method
        for(int i = 0; i <= keys.length; i++) {
            System.out.println(s.pop());
        }
        // first 0, 1, 2, 3, 4, 5, 6,
        // total elements are 6 only then it print underflow !! also

    }
}
