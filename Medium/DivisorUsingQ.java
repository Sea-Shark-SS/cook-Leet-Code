package Medium;

public class DivisorUsingQ {
	 public static int divide(int dividend, int divisor) {
	        // Handle overflow case
	        if (dividend == Integer.MIN_VALUE && divisor == -1) {
	            return Integer.MAX_VALUE; // Overflow case
	        }

	        // Determine the sign of the result
	        boolean negative = (dividend < 0) ^ (divisor < 0);

	        // Work with absolute values
	        long absDividend = Math.abs((long) dividend);
	        long absDivisor = Math.abs((long) divisor);
	        long quotient = 0;

	        // Perform the division using bit manipulation
	        while (absDividend >= absDivisor) {
	            long temp = absDivisor, multiple = 1;
	            // Shift the divisor left until it is larger than the dividend
	            while (absDividend >= (temp << 1)) {
	                temp <<= 1; // Double the divisor
	                multiple <<= 1; // Double the count
	            }
	            absDividend -= temp; // Subtract the largest shifted divisor
	            quotient += multiple; // Add the count to the quotient
	        }

	        // Apply the sign to the quotient
	        quotient = negative ? -quotient : quotient;

	        // Return the result within the 32-bit signed integer range
	        return (int) quotient;
	    }
	 public static void main(String[] args) {
		 int dividend = 10;
	        int divisor = 3;
	        int result = divide(dividend, divisor);
	        
	        System.out.println("Result: " + result); // Output: 3
	}
}
