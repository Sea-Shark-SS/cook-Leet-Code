package DynamicProgramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
//Using Tabulation
	static int longest(int ar[]) {
		int n=ar.length;
		if(n==0)
			return 0;
		
		int[] dp = new int[n];
		Arrays.fill(dp,1);
		for(int i=1 ; i<n ; i++) 
			for(int j = 0 ; j<i ; j++) 
				if(ar[i]>ar[j]) 
					dp[i]=Math.max(dp[i],dp[j]+1);
		
		int max=0;
		for(int l : dp)
			max=Math.max(max, l);
		
		return max;
	}
	//using memoization
    static int lisEndingAtIdx(int[] arr, int idx, int[] memo) {
        
        // Base case
        if (idx == 0)
            return 1;

        // Check if the result is already computed
        if (memo[idx] != -1)
            return memo[idx];

        // Consider all elements on left of i,
        // recursively compute LISs ending with 
        // them and consider the largest
        int mx = 1;
        for (int prev = 0; prev < idx; prev++)
            if (arr[prev] < arr[idx])
                mx = Math.max(mx, lisEndingAtIdx(arr, prev, memo) + 1);

        // Store the result in the memo array
        memo[idx] = mx;
        return memo[idx];
    }

    static int lis(int[] arr) {
        int n = arr.length;
      
        // Initialize memoization array with -1  
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
      
        int res = 1;
        for (int idx = 1; idx < n; idx++)
            res = Math.max(res, lisEndingAtIdx(arr, idx, memo));
        return res;
    }

	    public static void main(String[] args) {
	        int[] arr = {10, 22, 9,  21,  60, 80};
	        System.out.println(longest(arr));
	        // Call the LIS function
	        int length = lis(arr);
	        System.out.println("Length of Longest Increasing Subsequence: " + length);
	    }
}
