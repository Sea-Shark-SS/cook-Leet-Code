package Medium;

import java.util.ArrayList;
import java.util.List;

public class MobileNumberCombination {
	private static final String[] digitToLetters = {
	        "",    // 0
	        "",    // 1
	        "abc", // 2
	        "def", // 3
	        "ghi", // 4
	        "jkl", // 5
	        "mno", // 6
	        "pqrs",// 7
	        "tuv", // 8
	        "wxyz" // 9
	    };

	    public static List<String> letterCombinations(String digits) {
	        List<String> combinations = new ArrayList<>();
	        if (digits.isEmpty()) {
	            return combinations; // Return empty list if input is empty
	        }
	        backtrack(combinations, new StringBuilder(), digits, 0);
	        return combinations;
	    }
 private static void backtrack(List<String> combinations, StringBuilder current, String digits, int index) {
	        // If the current combination is the same length as digits, add it to the list
	        if (index == digits.length()) {
	            combinations.add(current.toString());
	            return;
	        }

	        // Get the letters corresponding to the current digit
	        String letters = digitToLetters[digits.charAt(index) - '0'];

	        // Loop through the letters and backtrack
	        for (char letter : letters.toCharArray()) {
	            current.append(letter); // Add the letter to the current combination
	            backtrack(combinations, current, digits, index + 1); // Move to the next digit
	            current.deleteCharAt(current.length() - 1); // Remove the last letter for backtracking
	        }
	}
 public static void main(String[] args) {
     String digits = "23"; // Example input
     List<String> result = letterCombinations(digits);
     System.out.println("Possible letter combinations: " + result);
 }
	    
}
