package stackQuestions;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class ReverseString {

    public static String reverse(String str) {
        Stack<Character> s = new Stack<>();
        char[] chars = str.toCharArray();
        for(char c: chars) {
            s.push(c);
        }


        for(int i = 0; i < str.length(); i++) {
            chars[i] = s.peek();
            s.pop();
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        String str = "abcde";
        String ans = reverse(str);
        System.out.println(ans);
    }

    @Test
    public void test0() {
        Assert.assertEquals("edcba", reverse("abcde"));
    }
}
