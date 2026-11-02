package Hard;

import java.util.ArrayList;
import java.util.List;

public class Permutations2 {
	 public static String getPermutation(int n, int k) {
	        // Precompute factorials
	        int[] factorials = new int[n];
	        factorials[0] = 1;
	        for (int i = 1; i < n; i++) {
	            factorials[i] = factorials[i - 1] * i;
	        }

	        // Create a list of numbers to get the k-th permutation
	        List<Integer> numbers = new ArrayList<>();
	        for (int i = 1; i <= n; i++) {
	            numbers.add(i);
	        }

	        // Adjust k to be zero-based
	        k--; 
	        StringBuilder permutation = new StringBuilder();

	        // Build the k-th permutation
	        for (int i = 0; i < n; i++) {
	            int index = k / factorials[n - 1 - i]; // Determine the index of the next number
	            permutation.append(numbers.get(index)); // Append the number to the result
	            numbers.remove(index); // Remove the used number
	            k %= factorials[n - 1 - i]; // Update k for the next iteration
	        }

	        return permutation.toString();
	    }

	    public static void main(String[] args) {
	        System.out.println(getPermutation(3, 3)); // Output: "213"
	        System.out.println(getPermutation(4, 9)); // Output: "2314"
	        System.out.println(getPermutation(3, 1)); // Output: "123"
	    }	
}
