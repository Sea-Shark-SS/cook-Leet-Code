package DynamicProgramming;

import java.util.HashMap;

public class LongestCommonSubString {
	//using Tabulation
static int findLongest(String x,String y) {
	int m=x.length();
	int n = y.length();
	
	int[][] dp = new int[m+1][n+1];
	for(int i =1 ; i<=m ; i++) 
		for(int j=1 ;j<=n ; j++) 
			if(x.charAt(i-1)==y.charAt(j-1)) 
				dp[i][j]=dp[i-1][j-1]+1;
			else 
				dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);		
	return dp[m][n];
}

//Using Memoization
static HashMap<String,Integer> memo = new HashMap<>();
public static int lcs(String x,String y,int m,int n) {
	if(n==0 || m==0)
		return 0;
	// Create a unique key for the current state
	String key = m+"-"+n;
	 // Check if the result is already computed
	if(memo.containsKey(key))
		return memo.get(key);
	// If the characters match, move to the next characters in both strings
	if(x.charAt(m-1)==y.charAt(n-1)) 
	 memo.put(key,1+lcs(x,y,m-1,n-1));
	else 
		 // If the characters do not match,
		//find the maximum by excluding one character
	 memo.put(key,Math.max(lcs(x,y,m-1,n),lcs(x,y,m,n-1)));
	
	return memo.get(key);
}

public static void main(String[] args) {
	String X = "AGGTAB";
    String Y = "GXTXAYB";

    int length = findLongest(X, Y);
    System.out.println("Length of Longest Common Subsequence: " + length);
   System.out.println(lcs(X,Y,X.length(),Y.length()));
}
}
