package stackQuestions;

import java.util.Stack;

public class MinIntStack {

    // in this problem there is one trick which is while
    // inserting when a number is less then minEle
    // then we need to store 2 * num - minEle so that
    // we can retrieve minEle after popping out an element

    // and while popping out when number we are popping is less then
    // minEle then we need to store 2 * minEle - num as minEle
    

    private Stack<Integer> stack = new Stack<>();
    private int min;

    public void push(int val) {
        if(stack.empty()) {
            stack.push(val);
            System.out.println("Inserting " + val + " in empty stack");
            min = val;
        }
        else if(val > min) {
            stack.push(val);
            System.out.println("Inserting " + val + " in stack");
        }
        else {
            stack.push(2 * val - min);
            System.out.println("Inserting " + (2*val-min) + " and min value equals to " + val);
            min = val;
        }
    }

    public void pop() {
        if(stack.empty()) {
            System.out.println("Stack Underflow !!");
            System.exit(-1);
        }
        int top = stack.peek();
        if(top < min) {
            System.out.println("Removing " + top);
            System.out.println("Min element is setting equals to " + (2 * min - top));
            min = 2 * min - top;
        }
        stack.pop();
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        MinIntStack s = new MinIntStack();

        s.push(6);
        System.out.println("min element is equals to " + s.getMin());
        s.push(7);
        System.out.println("min element is equals to " + s.getMin());

        s.push(5);
        System.out.println("min element is equals to " + s.getMin());

        s.push(3);
        System.out.println("min element is equals to " + s.getMin());

        s.pop();
        System.out.println("min element is equals to " + s.getMin());
    }
}
