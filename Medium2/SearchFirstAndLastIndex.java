package Medium2;

public class SearchFirstAndLastIndex {
	public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findLeftIndex(nums, target);
        result[1] = findRightIndex(nums, target);
        return result;
    }

    private static int findLeftIndex(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int leftIndex = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                leftIndex = mid; // Found target, but continue searching left
                right = mid - 1; // Move left to find the first occurrence
            } else if (nums[mid] < target) {
                left = mid + 1; // Move right
            } else {
                right = mid - 1; // Move left
            }
        }

        return leftIndex;
    }

    private static int findRightIndex(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int rightIndex = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                rightIndex = mid; // Found target, but continue searching right
                left = mid + 1; // Move right to find the last occurrence
            } else if (nums[mid] < target) {
                left = mid + 1; // Move right
            } else {
                right = mid - 1; // Move left
            }
        }

        return rightIndex;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;

        int[] result = searchRange(nums, target);
        System.out.println("Starting and ending positions: [" + result[0] + ", " + result[1] + "]"); // Output: [3, 4]

        int targetNotFound = 6;
        int[] resultNotFound = searchRange(nums, targetNotFound);
        System.out.println("Starting and ending positions: [" + resultNotFound[0] + ", " + resultNotFound[1] + "]"); // Output: [-1, -1]
    }
}
