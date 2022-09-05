package stackQuestions;

import jdk.jfr.StackTrace;
import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

// in this program we are designing a min stack which returns the min element
// in constant time
public class MinStack {

    Stack<Integer> stack, aux;
    public MinStack() {
        stack = new Stack<>();
        aux = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if(aux.isEmpty() || val <= aux.peek()) {
            aux.push(val);
        }
    }

    public int pop() {
        if(isEmpty()) {
            System.out.println("Stack Underflow!!");
            System.exit(-1);
        }
        int top = stack.pop();
        if(aux.peek() == top) {
            aux.pop();
        }
        return top;
    }

    public int top() {
        return stack.peek();
    }

    public int size()
    {
        return stack.size();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int getMin() {
        if(aux.isEmpty()) {
            System.out.println("Stack Underflow !!");
            System.exit(-1);
        }
        return aux.peek();
    }

    public static void main(String[] args) {
        MinStack s = new MinStack();
        s.push(6);
        System.out.println(s.getMin());

        s.push(7);
        System.out.println(s.getMin());

        s.push(8);
        System.out.println(s.getMin());

        s.push(5);
        System.out.println(s.getMin());

        s.push(3);
        System.out.println(s.getMin());

        System.out.println(s.pop());
        System.out.println(s.getMin());

        s.push(10);
        System.out.println(s.getMin());

        System.out.println(s.pop());
        System.out.println(s.getMin());

        System.out.println(s.pop());
        System.out.println(s.getMin());
    }

    @Test
    public void test0() {
        int[] keys = {2, 4, -1, 7, 5, -3};
        MinStack minStack = new MinStack();
        for(int key: keys) {
            minStack.push(key);
        }
        Assert.assertEquals(-3, minStack.getMin());
    }
}
