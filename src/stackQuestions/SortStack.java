package stackQuestions;

import java.util.Stack;

public class SortStack {

    public void insertSorted(Stack<Integer> s, int val) {
        if(s.isEmpty() || val > s.peek()) {
            s.push(val);
            return;
        }
         int topEle = s.pop();
         insertSorted(s, val);
         s.push(topEle);
    }

    public void sortStack(Stack<Integer> s) {
        if(s.isEmpty()) {
            return;
        }
        else {
            int top = s.pop();
            sortStack(s);
            insertSorted(s, top);
        }
    }

    void printStackElements(Stack<Integer> stack) {
        while(!stack.isEmpty()) {
            System.out.print(stack.peek() + "\t\t");
            stack.pop();
        }
    }

    public static void main(String[] args) {
        int[] keys = {1, 10, 2, 9, 3, 8, 4, 7, 5, 6};
        Stack<Integer> stack = new Stack<>();
        for(int key: keys) {
            stack.push(key);
        }
        SortStack sortStack = new SortStack();
        sortStack.sortStack(stack);
        sortStack.printStackElements(stack);
    }
}
