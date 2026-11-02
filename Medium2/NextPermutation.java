package Medium2;

import java.util.Arrays;

public class NextPermutation {
	public static void nextPermutation(int[] nums) {
        int n = nums.length;
        if (n <= 1) return;

        // Step 1: Find the longest non-increasing suffix
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // Step 2: If the entire array is non-increasing, reverse it
        if (i < 0) {
            reverse(nums, 0, n - 1);
            return;
        }

        // Step 3: Find the rightmost successor to the pivot
        int j = n - 1;
        while (nums[j] <= nums[i]) {
            j--;
        }

        // Step 4: Swap the pivot with the successor
        swap(nums, i, j);

        // Step 5: Reverse the suffix
        reverse(nums, i + 1, n - 1);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
    public static void main(String[] args) {
    	int[] nums = {1, 2, 3};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums)); // Output: [1, 3, 2]

        int[] nums2 = {3, 2, 1};
        nextPermutation(nums2);
        System.out.println(Arrays.toString(nums2)); // Output: [1, 2, 3]

        int[] nums3 = {1, 1, 5};
        nextPermutation(nums3);
        System.out.println(Arrays.toString(nums3)); // Output: [1, 5, 1]
	}
}
