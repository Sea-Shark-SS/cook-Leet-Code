package Medium;

public class RemoveDuplicatefromSortedArray {
	public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0; // If the array is empty, return 0
        }

        int k = 1; // Start with the first unique element

        // Iterate through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // If the current element is different from the last unique element
            if (nums[i] != nums[k - 1]) {
                nums[k] = nums[i]; // Update the position of the unique element
                k++; // Move the pointer for unique elements
            }
        }

        return k; // Return the count of unique elements
    }

    public static void main(String[] args) {
        
        // Example input
        int[] nums = {1, 1, 2, 2, 3, 4, 4, 5};
        
        // Call the method
        int k = removeDuplicates(nums);
        
        // Print the result
        System.out.println("Number of unique elements: " + k);
        System.out.print("Unique elements: ");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
        // Output: Number of unique elements: 5
        // Unique elements: 1 2 3 4 5
    }
}
