package Medium;

public class ReverseInteger {
public static int reverse(int x) {
	int reversed = 0;
    int sign = (x < 0) ? -1 : 1; // Determine the sign of x
    x = Math.abs(x); // Work with the absolute value of x

    while (x != 0) {
        int digit = x % 10; // Get the last digit
        x /= 10; // Remove the last digit

        // Check for overflow before adding the digit
        if (reversed > (Integer.MAX_VALUE - digit) / 10) {
            return 0; // Overflow will occur
        }

        reversed = reversed * 10 + digit; // Build the reversed number
    }

    return reversed * sign; // Restore the original sign
    
}
public static void main(String[] args) {
	 int input = -123; // Example input
     int result = reverse(input);
     System.out.println("Reversed integer: " + result);
}
}
