package DynamicProgramming;

import java.util.HashMap;

public class isSubsetSum {
  
	//USING TABULATION
	static boolean isSubset(int a[],int sum) {
boolean[][] dp = new boolean[a.length+1][sum+1];
       // Initialize: A sum of 0 can always be formed with an empty subset
for(int i =0 ; i<a.length;i++)
			dp[i][0]=true;
		// Fill the DP table
 for(int i = 1; i<=a.length;i++)
     for(int j=1 ; j<=sum ;j++) {
			if(a[i-1]<=j)
				dp[i][j]=dp[i-1][j] || dp[i-1][j-a[i-1]];
			else
				dp[i][j]=dp[i-1][j];
		// Include the current element or exclude it
		
     }
		
		return dp[a.length][sum];
	}
	//usng memoization
	static HashMap<String,Boolean> memo=new HashMap<>();
	
	static boolean isSum(int a[],int n,int sum) {
		if(n==0 )return false;
		if(sum==0) return true;
		String key = n+"-"+sum;
		if(memo.containsKey(key))
			return memo.get(key);
		// If the last element is greater than the target, ignore it
		if(a[n-1]>sum) {
			boolean res = isSum(a,n-1,sum);
			memo.put(key,res);
			return memo.get(key);
		}
		//Include the last element or exclude it
		boolean res= isSum(a,n-1,sum) || isSum(a,n-1,sum-a[n-1]);
		memo.put(key,res);
		return memo.get(key);
	}
	public static void main(String[] args) {
		int[] set = {3, 34, 12,4, 5, 2};
        int target = 9;

        boolean result = isSubset(set, target);
        System.out.println(result);
        System.out.println(isSum(set,set.length,target));
}
}
