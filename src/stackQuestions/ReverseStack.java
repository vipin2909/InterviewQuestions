package stackQuestions;

import java.util.Stack;

public class  ReverseStack {

    static void insertBottom(Stack<Integer> s, int val) {
        if(s.isEmpty()) {
            s.push(val);
            return;
        }
        int top = s.pop();
        insertBottom(s, val);
        s.push(top);
    }
    static void reverseStack(Stack<Integer> s) {
        if(s.isEmpty()) {
            return;
        }
        else {
            int top = s.pop();
            reverseStack(s);
            insertBottom(s, top);
        }
    }

    public static void main(String[] args) {
        int[] keys = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Stack<Integer> stack = new Stack<Integer>();
        for(int key: keys) {
            stack.push(key);
        }
        System.out.println("Initial Stack " + stack);
        reverseStack(stack);
        System.out.println("Final Stack " + stack);
    }
}
