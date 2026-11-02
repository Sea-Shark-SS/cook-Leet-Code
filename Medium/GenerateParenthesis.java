package Medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
	 public static List<String> generateParenthesis(int n) {
	        List<String> result = new ArrayList<>();
	        backtrack(result, new StringBuilder(), 0, 0, n);
	        return result;
	    }

	    private static void backtrack(List<String> result, StringBuilder current, int open, int close, int max) {
	        // If the length of the current combination is equal to 2 * max, add it to the result
	        if (current.length() == max * 2) {
	            result.add(current.toString());
	            return;
	        }

	        // If the number of opening parentheses is less than max, add an opening parenthesis
	        if (open < max) {
	            current.append("(");
	            backtrack(result, current, open + 1, close, max);
	            current.deleteCharAt(current.length() - 1); // Backtrack
	        }

	        // If the number of closing parentheses is less than the number of opening parentheses, add a closing parenthesis
	        if (close < open) {
	            current.append(")");
	            backtrack(result, current, open, close + 1, max);
	            current.deleteCharAt(current.length() - 1); // Backtrack
	        }
	    }

	    public static void main(String[] args) {
	        int n = 3; // Example
	        System.out.println("Combinations of well-formed parentheses for n = " + n + ": " + generateParenthesis(n));
	    }
}
