package Medium2;

public class JumpGame2 {
	public static int jump(int[] nums) {
        int n = nums.length;
       if (n <= 1) return 0;

       int maxReach = nums[0];
       int step = nums[0];
       int jumps = 1;

       for (int i = 1; i < n; i++) {
           if (i == n - 1) return jumps;

           maxReach = Math.max(maxReach, i + nums[i]);
           step--;

           if (step == 0) {
               jumps++;
               step = maxReach - i;
           }
       }

       return jumps;
   }
	public static void main(String[] args) {
		int[] nums = {2, 3, 1, 1, 4};
        int result = jump(nums);
        System.out.println("Result: " + result);
	}
}
