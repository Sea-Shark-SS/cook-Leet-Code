package Hard;

import java.util.Stack;

public class LongestValidParenthesis {
	public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // Base for valid substring length calculation
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i); // Push the index of '('
            } else {
                stack.pop(); // Pop the last '(' index
                if (stack.isEmpty()) {
                    stack.push(i); // Push the index of the unmatched ')'
                } else {
                    // Calculate the length of the valid substring
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }

        return maxLength;
    }
	 public static void main(String[] args) {
	        
	        String s1 = "(()";
	        System.out.println(longestValidParentheses(s1)); // Output: 2

	        String s2 = ")()())";
	        System.out.println(longestValidParentheses(s2)); // Output: 4

	        String s3 = "";
	        System.out.println(longestValidParentheses(s3)); // Output: 0

	        String s4 = "()(())";
	        System.out.println(longestValidParentheses(s4)); // Output: 6
	    }
}
