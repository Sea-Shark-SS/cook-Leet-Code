package Medium3;

public class MaximumSubArray {
	 public static int maxSubArray(int[] nums) {
	        if (nums == null || nums.length == 0) {
	            return 0; // Handle empty array case
	        }

	        int maxCurrent = nums[0];
	        int maxGlobal = nums[0];

	        for (int i = 1; i < nums.length; i++) {
	            maxCurrent = Math.max(nums[i], maxCurrent + nums[i]);
	            if (maxCurrent > maxGlobal) {
	                maxGlobal = maxCurrent;
	            }
	        }

	        return maxGlobal;
	    }

	    public static void main(String[] args) {
	        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
	        int result = maxSubArray(nums);
	        System.out.println(result); // Output: 6 (the subarray [4, -1, 2, 1] has the largest sum)
	    }
}
