package Medium;

public class MyAtoi {
public static int atoi(String s) {
	 // Step 1: Trim leading whitespace
    s = s.trim();
    
    if (s.isEmpty()) {
        return 0; // If the string is empty after trimming, return 0
    }
    
    // Step 2: Determine the sign
    int sign = 1;
    int index = 0;
    char firstChar = s.charAt(index);
    
    if (firstChar == '-') {
        sign = -1;
        index++;
    } else if (firstChar == '+') {
        index++;
    }
    
    // Step 3: Convert characters to integer
    long result = 0; // Use long to handle overflow
    while (index < s.length() && Character.isDigit(s.charAt(index))) {
        int digit = s.charAt(index) - '0'; // Convert char to int
        
        // Step 4: Check for overflow before adding the digit
        if (result > (Integer.MAX_VALUE - digit) / 10) {
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        
        result = result * 10 + digit;
        index++;
    }
    
    // Step 5: Apply the sign and return the result
    return (int) (sign * result);
}
public static void main(String[] args) {
    
    System.out.println(atoi("   -42"));        // Output: -42
    System.out.println(atoi("4193 with words"));  // Output: 4193
    System.out.println(atoi("words and 987"));  // Output: 0
    System.out.println(atoi("-91283472332"));   // Output: -2147483648 (clamped)
}

}
