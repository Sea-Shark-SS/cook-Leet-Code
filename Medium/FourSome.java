package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSome {
	 public static List<List<Integer>> fourSum(int[] nums, int target) {
	        List<List<Integer>> result = new ArrayList<>();
	        Arrays.sort(nums); // Sort the array to facilitate the two-pointer technique

	        int n = nums.length;

	        for (int i = 0; i < n - 3; i++) {
	            // Skip duplicate values for the first number
	            if (i > 0 && nums[i] == nums[i - 1]) continue;

	            for (int j = i + 1; j < n - 2; j++) {
	                // Skip duplicate values for the second number
	                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

	                int left = j + 1;
	                int right = n - 1;

	                while (left < right) {
	                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right]; // Use long to avoid overflow

	                    if (sum == target) {
	                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

	                        // Skip duplicate values for the third number
	                        while (left < right && nums[left] == nums[left + 1]) left++;
	                        // Skip duplicate values for the fourth number
	                        while (left < right && nums[right] == nums[right - 1]) right--;

	                        left++;
	                        right--;
	                    } else if (sum < target) {
	                        left++;
	                    } else {
	                        right--;
	                    }
	                }
	            }
	        }

	        return result;
	    }

	    public static void main(String[] args) {
	        int[] nums1 = {1, 0, -1, 0, -2, 2};
	        int target1 = 0;
	        System.out.println("Example 1 Output: " + fourSum(nums1, target1));

	        int[] nums2 = {2, 2, 2, 2, 2};
	        int target2 = 8;
	        System.out.println("Example 2 Output: " + fourSum(nums2, target2));
	    }
}
