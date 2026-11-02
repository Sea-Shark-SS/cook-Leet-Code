package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
 
public static List<List<Integer>> threeSum(int[] nums) {
	List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums); // Sort the array

    for (int i = 0; i < nums.length - 2; i++) {
        // Skip duplicate values for the first element
        if (i > 0 && nums[i] == nums[i - 1]) {
            continue;
        }

        int left = i + 1; // Start pointer
        int right = nums.length - 1; // End pointer

        while (left < right) {
            int sum = nums[i] + nums[left] + nums[right];

            if (sum == 0) {
                // Found a triplet
                result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                // Skip duplicates for the second element
                while (left < right && nums[left] == nums[left + 1]) {
                    left++;
                }
                // Skip duplicates for the third element
                while (left < right && nums[right] == nums[right - 1]) {
                    right--;
                }

                // Move both pointers
                left++;
                right--;
            } else if (sum < 0) {
                left++; // We need a larger sum
            } else {
                right--; // We need a smaller sum
            }
        }
    }

    return result;
}
	public static void main(String[] args) {
	int[] x = {-1, 0, 1, 2, -1, -4};
	System.out.println(threeSum(x));
}
}
