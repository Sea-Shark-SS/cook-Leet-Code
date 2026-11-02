package Medium;

public class FindSmallestPositiveInArray {
	public static int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: Place each number in its right place
        for (int i = 0; i < n; i++) {
            // While the current number is in the range and not in the correct position
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // Swap nums[i] with nums[nums[i] - 1]
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }

        // Step 2: Find the first missing positive
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1; // The first missing positive integer
            }
        }

        // If all positions are correct, return n + 1
        return n + 1;
    }

    public static void main(String[] args) {
        
        // Example usage
        int[] nums = {3, 4, -1, 1};
        int result =firstMissingPositive(nums);
        
        System.out.println("Smallest missing positive integer: " + result); // Output: 2
    }
}
