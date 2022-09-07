package stackQuestions;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class Postfix {

    public static int evalPostfix(String str) {
        // base case when string has no character
        if(str == null || str.length() == 0) {
            System.exit(-1);
        }
        Stack<Integer> stack = new Stack<Integer>();

        // traverse the given expression
        for(char c: str.toCharArray()) {
            // if the current character is an operand, push it into the stack
            if(Character.isDigit(c)) {
                stack.push(c - '0');
            }
            // if the current character is an operator
            else {
                int x = stack.pop();
                int y = stack.pop();

                if(c == '+') {
                    stack.push(y + x);
                }
                else if(c == '-') {
                    stack.push(y - x);
                }
                else if(c == '*') {
                    stack.push(x * y);
                }
                else if(c == '/') {
                    stack.push(y / x);
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String expression = "138*/";
        System.out.println(evalPostfix(expression));
    }

    @Test
    public void test0() {
        String str = "545*+5/";
        Assert.assertEquals(5, evalPostfix(str));
    }

    @Test
    public void test1() {
        String str = "82/";
        Assert.assertEquals(4, evalPostfix(str));
    }
}
