package Medium2;

public class CountandSay {
	 public static String countAndSay(int n) {
	        if (n == 1) {
	            return "1"; // Base case
	        }

	        String result = "1"; // Start with the first term

	        for (int i = 2; i <= n; i++) {
	            StringBuilder nextTerm = new StringBuilder();
	            char currentChar = result.charAt(0);
	            int count = 0;

	            // Count consecutive characters
	            for (int j = 0; j < result.length(); j++) {
	                if (result.charAt(j) == currentChar) {
	                    count++;
	                } else {
	                    // Append count and character to the next term
	                    nextTerm.append(count).append(currentChar);
	                    currentChar = result.charAt(j);
	                    count = 1; // Reset count for the new character
	                }
	            }
	            // Append the last counted character
	            nextTerm.append(count).append(currentChar);
	            result = nextTerm.toString(); // Update result for the next iteration
	        }

	        return result; // Return the nth term
	    }

	    public static void main(String[] args) {
	       
	        int n = 5; // Example input
	        String result = countAndSay(n);
	        System.out.println("The " + n + "th term of the count-and-say sequence is: " + result); // Output: "111221"
	    }
}
