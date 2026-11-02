package DynamicProgramming;

import java.util.Arrays;

public class MatrixChainMultiplication {

	//using memoization
	static int minRec(int[] a){
		if(a.length==0)
			return 0;
		int n=a.length;
		int[][] memo =  new int[n][n];
		for(int[] row:memo)
		Arrays.fill(row, -1);
		
		memo[0][n-1]=rec(a,0,n-1,memo);
		return memo[0][n-1];
	}
	// Function to compute minimum multiplication
    // recursively (Helping function)
	static int rec(int[] a,int i,int j,int[][] memo) {
		
        // If there is only one matrix
        if(i+1==j)
        	return 0;
        if(memo[i][j]!=-1)
        	return memo[i][j];
        int res=Integer.MAX_VALUE;
        
        // Place the first bracket at different positions or
        // k and for every placed first bracket, recursively
        // compute minimum cost for remaining brackets (or
        // subproblems)
        for(int k=i+1;k<j;k++) {
        	int cur = rec(a,i,k,memo)+rec(a,k,j,memo)+a[i]*a[j]*a[k];
        	res=Math.min(cur, res);
        	
        }
        // Store the result in memo table
        memo[i][j]=res;
        return res;
	}
	//using tabulaion
	static int getmin(int[] a) {
		int n=a.length;
		if(n==0)return 0;
		// Create a 2D DP array to store minimum
        // multiplication costs
		int[][] dp = new int[n][n];
		// Fill the DP array
        // len is the chain length
		for(int len=2 ; len<n;len++ )
			for(int i=0 ; i<n-len; i++) {
				int j=i+len;
				dp[i][j]=Integer.MAX_VALUE;
				for(int k=i+1; k<j;k++) {
					int cost=dp[i][k]+dp[k][j]+a[i]*a[j]*a[k];
					if(cost<dp[i][j])
						dp[i][j]=cost;
				}
			}
	// Function to calculate min multiplication cost
	return dp[0][n-1];
	}
	public static void main(String[] args) {
		int [] a= {1, 2, 3, 4, 3};
		int r =minRec(a);
	System.out.println(r);
	System.out.println(getmin(a));
	}
	
}
