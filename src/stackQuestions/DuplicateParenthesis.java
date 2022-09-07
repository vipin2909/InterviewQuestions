package stackQuestions;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class DuplicateParenthesis {

    // if our expression have something like this ((a+b))
    // then we can check for ( parenthesis to cancel it with )
    // and after that if stack.peek() still contains ( then return true
    // otherwise there is no duplicate parenthesis

    public boolean isDuplicateParenthesisPresent(String expression) {
        int expressionLength = expression.length();
        Stack<Character> stack = new Stack<>();
        for(int index = 0; index < expressionLength; index++) {
            char ch = expression.charAt(index);
            if(ch != ')') {
                stack.push(ch);
            }
            else {
                if(stack.peek() == '(') {
                    return true;
                }
                while(stack.peek() != '(') {
                    stack.pop();
                }
                stack.pop();
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String abc = "((a+b)+(c+d))";
        DuplicateParenthesis duplicateParenthesis = new DuplicateParenthesis();
        boolean ans = duplicateParenthesis.isDuplicateParenthesisPresent(abc);
        System.out.println(ans);
    }
    @Test
    public void test0() {
        String abc = "((a+b)+(c+d))";
        Assert.assertTrue("Test case failed for String " + abc, isDuplicateParenthesisPresent(abc));
    }

}
