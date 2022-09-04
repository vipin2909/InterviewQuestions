package stackQuestions;

public class StackUsingArray {
    private int[] arr;
    private int top;
    private int capacity;

    StackUsingArray(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    public void push(int x) {
        if(isFull()) {
            System.out.println("Overflow\nProgram Terminated\n");
            System.exit(-1);
        }

        System.out.println("Inserting " + x);
        arr[++top] = x;
    }

    public int pop() {
        if(isEmpty()) {
            System.out.println("Underflow\nProgram Terminated");
            System.exit(-1);
        }
        System.out.println("Removing " + peek());
        return arr[top--];
    }

    public int peek() {
        if(!isEmpty()) {
            return arr[top];
        }
        else {
            System.exit(-1);
        }
        return -1;
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public static void main(String[] args) {
        StackUsingArray stackUsingArray = new StackUsingArray(3);

        stackUsingArray.push(1);
        stackUsingArray.push(2);

        stackUsingArray.pop();
        stackUsingArray.pop();

        stackUsingArray.push(3);
        System.out.println("The top element is " + stackUsingArray.peek());
        System.out.println("The stack size is " + stackUsingArray.size());

        stackUsingArray.pop();
        if(stackUsingArray.isEmpty()) {
            System.out.println("The stack is empty");
        }
        else {
            System.out.println("The stack is not empty");
        }
    }

}
