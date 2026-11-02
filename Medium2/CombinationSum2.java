package Medium2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
	 public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
	        Arrays.sort(candidates);
	        List<List<Integer>> result = new ArrayList<>();
	        backtrack(result, new ArrayList<>(), candidates, target, 0);
	        return result;
	    }

	    private static void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int remain, int start) {
	        if (remain < 0) return;
	        else if (remain == 0) result.add(new ArrayList<>(tempList));
	        else {
	            for (int i = start; i < nums.length; i++) {
	                // Skip duplicates
	                if (i > start && nums[i] == nums[i - 1]) continue;
	                tempList.add(nums[i]);
	                backtrack(result, tempList, nums, remain - nums[i], i + 1);
	                tempList.remove(tempList.size() - 1);
	            }
	        }
	    }
	  public static void main(String[] args) {
		  int[] candidates = {10, 1, 2, 7, 6, 1, 5};
	        int target = 8;
	        List<List<Integer>> result = combinationSum2(candidates, target);
	        System.out.println("Result: " + result);
	}
}
