package DynamicProgramming;

import java.util.Arrays;

public class Rod {

	//using tabulation
	static int cutRod(int[] price,int rod) {
		int[] dp = new int[rod+1];// Fill the DP array
		for(int i=1 ; i<=rod ; i++){
			int max= Integer.MIN_VALUE;
			for(int j=0 ; j<i;j++)
				max=Math.max(max,price[j]+dp[i-j-1]);
		dp[i]=max;
		}
		return dp[rod];
	}
	//using memoization
	static int[] memo;
	static int meatRod(int []price,int rod) {
		memo=new int[rod+1];
		Arrays.fill(memo,-1);
		
		return help(price,rod);
	}
	 // Helper function for the recursive approach
	static int help(int[] price,int rod) {
        // Base case: If the length of the rod is 0, the revenue is 0
		if(rod==0)return 0;
		// Check if the result is already computed
		if(memo[rod]!=-1)
			return memo[rod];
		int max=Integer.MIN_VALUE;
		 // Try all possible cuts
		for(int i=0 ; i<rod ;i++)
			max=Math.max(max,price[i]+help(price,rod-i-1));
		memo[rod]=max;
		return memo[rod];
	}
	public static void main(String[] args) {
		int[] prices = {1, 5, 8, 9, 10, 17, 17, 20}; // Prices for lengths 1 to 8
        int n = 8; // Length of the rod

        int max= cutRod(prices, n);
    System.out.println(max);
    System.out.println(meatRod(prices,n));
	}
}
