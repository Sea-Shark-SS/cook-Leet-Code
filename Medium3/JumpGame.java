package Medium3;

public class JumpGame {
	public static boolean canJump(int[] nums) {
        int maxReach = 0; // The farthest index we can reach
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // If the current index is greater than the farthest reachable index, return false
            if (i > maxReach) {
                return false;
            }
            // Update the farthest reachable index
            maxReach = Math.max(maxReach, i + nums[i]);
            // If we can reach or exceed the last index, return true
            if (maxReach >= n - 1) {
                return true;
            }
        }

        return false; // If we finish the loop and haven't returned true, return false
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println(canJump(nums1)); // Output: true

        int[] nums2 = {3, 2, 1, 0, 4};
        System.out.println(canJump(nums2)); // Output: false
    }
}
