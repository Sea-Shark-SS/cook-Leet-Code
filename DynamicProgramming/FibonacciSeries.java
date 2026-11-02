package DynamicProgramming;

import java.util.Arrays;

public class FibonacciSeries {
   //using memoization
	public static int fib(int n,int[] memo) {
	   if(n<=1) 
		   return n;
	   if(memo[n]!=-1)
		   return memo[n];
	   
	   memo[n]=fib(n-2,memo)+fib(n-1,memo);
	   
	   return memo[n];
   }
	//using tabulation
	public static int tab(int n) {
		if(n<=1) return n;
		int [] dp = new int[n+1];
		dp[0]=0;
		dp[1]=1;
		for(int i=2 ; i<n+1; i++) {
			dp[i]=dp[i-2]+dp[i-1];
		}
		return dp[n];
	}
   public static void main(String[] args) {
	int n = 10;
	int[] memo = new int[n+1];
	Arrays.fill(memo,-1);
	System.out.println(fib(n,memo));
	System.out.println(tab(n));
  }
}
