package stackQuestions;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class BalancedExpression {

    public boolean checkIfExpressionIsBalanced(String expression) {
        Stack<Character> stack = new Stack<Character>()
                ;
        for(int index = 0; index < expression.length(); index++) {
            char ch = expression.charAt(index);
            if(ch == '{' || ch == '[' || ch == '(') {
                stack.push(ch);
            }
            if(ch == ']') {
                if(!stack.isEmpty() && stack.peek() != '[') {
                    return false;
                }
                else {
                    stack.pop();
                }
            }
            if(ch == ')') {
                if(!stack.isEmpty() && stack.peek() != '(') {
                    return false;
                }
                else {
                    stack.pop();
                }
            }
            if(ch == '}') {
                if(!stack.isEmpty() && stack.peek() != '{') {
                    return false;
                }
                else {
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();


    }
    public static void main(String[] args) {
        BalancedExpression balancedExpression = new BalancedExpression();
        boolean ans  = balancedExpression.checkIfExpressionIsBalanced("{}{((()))[]([()({}{{}{([])}})][][][])}");
        System.out.println("Expression is balanced ? " + ans);
    }

    @Test
    public void test0() {
        Assert.assertTrue(checkIfExpressionIsBalanced("{[({}{}{}[][()()({}{()([][{}{()()}])})][])]}{}{}"));
    }
}
