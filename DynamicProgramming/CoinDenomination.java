package DynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;

public class CoinDenomination {
 
 	//using memoization
	static HashMap<Integer,Integer> memo= new HashMap<>();
	//function to find min coin
	static int getmin(int[] a,int amount) {
		if(amount<=0)
			return 0;
		
		// Check if the result is already computed
	   if(memo.containsKey(amount))
		   return memo.get(amount);
	   int min = Integer.MAX_VALUE;
	   // Try each coin and find the minimum
	   for(int coin :a) {
		   int res = getmin(a,amount-coin);
		   if(res>=0) 
			   min = Math.min(res+1, min);
	   }
	// If minCoins was not updated, return -1
	   min=(min==Integer.MAX_VALUE) ? -1 :min;
	   memo.put(amount, min);
		return min;
	}
	
	//using tabulation
	public static int min(int a[],int amount) {
		int[] dp = new int[amount+1];
		// Initialize the DP array with a large value
		Arrays.fill(dp, Integer.MAX_VALUE);
		// Base case: 0 coins are needed to make amount 0
		dp[0]=0; // Fill the DP array
		for(int i =1 ; i<=amount ; i++)
			for(int coin: a) 
				if(i-coin>=0 && dp[i-1]!=Integer.MAX_VALUE)
					dp[i]=Math.min(dp[i],dp[i-coin]+1);
			
        // If dp[amount] is still Integer.MAX_VALUE, return -1 (not possible)
		dp[amount]=(dp[amount]==Integer.MAX_VALUE)?-1:dp[amount];
		return dp[amount];
	}
	public static void main(String[] args) {
		int[] coins = {1, 3, 4};
        int amount = 6;

        int result = getmin(coins, amount);
        System.out.println(result);
        System.out.println(min(coins,amount));
	}
}
