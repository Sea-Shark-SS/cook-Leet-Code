package Medium2;

import java.util.ArrayList;
import java.util.List;

public class Parmutation1 {
	public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int num : nums) {
                if (!tempList.contains(num)) {
                    tempList.add(num);
                    backtrack(result, tempList, nums);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }
    public static void main(String[] args) {
    	int[] nums = {1, 2, 3};
        List<List<Integer>> result = permute(nums);
        System.out.println("Result: " + result);
	}
}
