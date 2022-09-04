package stackQuestions;

class Node {
    int data;
    Node next;
}
public class StackUsingLinkedList {
    private Node top;
    private int nodesCount;

    public StackUsingLinkedList() {
        this.top = null;
        this.nodesCount = 0;
    }

    public void push(int x) {
        Node node = new Node();

        if(node == null) {
            System.out.println("Heap Overflow");
            return;
        }
        System.out.println("Inserting " + x);
        node.data = x;
        node.next = top;
        top = node;
        this.nodesCount += 1;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int peek() {
        if(isEmpty()) {
            System.out.println("The stack is empty");
            System.exit(-1);
        }
        return top.data;
    }

    public int pop() {
        if(isEmpty()) {
            System.out.println("Stack Underflow");
            System.exit(-1);
        }
        int top = peek();
        System.out.println("Removing " + top);
        this.nodesCount -= 1;
        this.top = (this.top).next;
        return top;
    }

    public int size() {
        return this.nodesCount;
    }

    public static void main(String[] args) {
        Node hell = new Node();
//        hell.data = 4;
        Node chips = new Node();
//        chips.data = 4;
//        chips.next = null;
        if(chips.next == hell.next) {
            System.out.println("Chips == hel");
            System.out.println("And their next element is " + chips.next);
            System.out.println("And their data is something like sort of 0 " + (chips.data == hell.data));
        }

//        chips = chips.next;
        if(chips.data == hell.data) {
            System.out.println("Hell;");
        }

        StackUsingLinkedList stack = new StackUsingLinkedList();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("The top element is " + stack.peek());
        stack.pop();
        stack.pop();
        stack.pop();
        if(stack.isEmpty()) {
            System.out.println("The stack is empty");
        }
        else {
            System.out.println("The stack is not empty");
        }
    }
}
