package Medium2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum1 {
	 public static List<List<Integer>> combinationSum(int[] candidates, int target) {
	        Arrays.sort(candidates); // Sort candidates for easier pruning
	        List<List<Integer>> result = new ArrayList<>();
	        backtrack(result, new ArrayList<>(), candidates, target, 0);
	        return result;
	    }

	    private static void backtrack(List<List<Integer>> result, List<Integer> current, int[] candidates, int remaining, int start) {
	        if (remaining == 0) {
	            result.add(new ArrayList<>(current)); // Found a valid combination
	            return;
	        }

	        for (int i = start; i < candidates.length; i++) {
	            if (candidates[i] > remaining) {
	                break; // Prune branches with numbers greater than the remaining target
	            }
	            current.add(candidates[i]); // Add the current number to the combination
	            backtrack(result, current, candidates, remaining - candidates[i], i); // Recursively try the next number
	            current.remove(current.size() - 1); // Backtrack by removing the last added number
	        }
	    }

	    public static void main(String[] args) {
	        
	        int[] candidates = {2, 3, 5};
	        int target = 8;
	        List<List<Integer>> result = combinationSum(candidates, target);
	        System.out.println("Combinations that sum up to " + target + ": " + result); // Output: [[2, 2, 2, 2], [2, 3, 3], [3, 5]]
	    }
}
