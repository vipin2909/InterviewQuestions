package stackQuestions;

import java.util.Stack;

public class DecodeSequence {
    public static String decodeSequence(String str) {
        // base case
        if(str == null || str.length() == 0) {
            return str;
        }

        // result StringBuilder stores the output result
        StringBuilder result = new StringBuilder();

        // create an empty stack of integers
        Stack<Integer> stack = new Stack<Integer>();

        for(int i = 0; i <= str.length(); i++) {
            stack.push(i+1);
            // if all the characters of the input are processed, or input
            // the current character is I
            if(i == str.length() || str.charAt(i) == 'I') {
                while(!stack.empty()) {
                    result.append(stack.pop());
                }
            }
        }
        return result.toString();
    }
    public static void main(String[] args) {
        String seq = "IDIDII";
        System.out.println("The minimum number is " + decodeSequence(seq));
    }

    // 1 ->
     // I -> 1
    // D -> 1
    // I -> 132
    // D -> 132
    // I -> 13254
    // I -> 132546
    // I -> 1325467-> ans
}
