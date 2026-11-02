package Easy;

import java.util.Stack;

public class ValidParenthesis {
	 public static boolean isValid(String s) {
	        // Create a stack to keep track of opening brackets
	        Stack<Character> stack = new Stack<>();
	        
	        // Iterate through each character in the string
	        for (char c : s.toCharArray()) {
	            // If it's an opening bracket, push it onto the stack
	            if (c == '(' || c == '{' || c == '[') {
	                stack.push(c);
	            } 
	            // If it's a closing bracket
	            else if (c == ')' || c == '}' || c == ']') {
	                // Check if the stack is empty or the top of the stack doesn't match
	                if (stack.isEmpty()) {
	                    return false; // Invalid
	                }
	                char top = stack.pop();
	                // Check for matching pairs
	                if ((c == ')' && top != '(') || 
	                    (c == '}' && top != '{') || 
	                    (c == ']' && top != '[')) {
	                    return false; // Invalid
	                }
	            }
	        }
	        
	        // If the stack is empty, all brackets were matched correctly
	        return stack.isEmpty();
	    }
	 public static void main(String[] args) {
	        String s1 = "()"; // Example 1
	        String s2 = "()[]{}"; // Example 2
	        String s3 = "(]"; // Example 3
	        String s4 = "([)]"; // Example 4
	        String s5 = "{[]}"; // Example 5

	        System.out.println("Example 1: " + isValid(s1)); // true
	        System.out.println("Example 2: " + isValid(s2)); // true
	        System.out.println("Example 3: " + isValid(s3)); // false
	        System.out.println("Example 4: " + isValid(s4)); // false
	        System.out.println("Example 5: " + isValid(s5)); // true
	    }
}
