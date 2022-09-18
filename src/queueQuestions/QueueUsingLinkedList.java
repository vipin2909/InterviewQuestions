package queueQuestions;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedQueue {
    private static Node rear = null, front = null;
    private static int count = 0;

    // dequeue means delete at beginning
    public static int dequeue() {
        if(front == null) {
            System.out.println("\nQueue Underflow");
            System.exit(-1);
        }

        Node temp = front;
        System.out.println("Removing " + temp.data);

        front = front.next;

        // if the list becomes empty
        if(front == null) {
            rear = null;
        }

        // decrease count by 1
        count -= 1;
        return temp.data;
    }

    public static void enqueue(int item) {
        Node node = new Node(item);

        System.out.println("Inserting " + item);
        if(front == null) {
            front = node;
            rear = node;
        }
        else {
            rear.next = node;
            rear = node;
        }

        count += 1;
    }
    public static int peek() {
        if(front == null) {
            System.exit(-1);
        }
        return front.data;
    }

    public boolean isEmpty() {
        return rear == null && front == null;
    }

    private static int size() {
        return count;
    }
}
public class QueueUsingLinkedList {
    private static Node rear = null, front = null;
    private static int count = 0;
}
