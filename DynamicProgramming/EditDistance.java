package DynamicProgramming;

import java.util.HashMap;

public class EditDistance {
  public static int getD(String x,String y) {
	  int m= x.length();
	  int n=y.length();
	  int[][] dp = new int[m+1][n+1];
	  
	// Initialize the first row and column
	// Deleting all characters from str1
	  for(int i=0 ;i <=m ; i++)
		  dp[i][0]=i;
	  for(int i=0 ; i<=n;i++)
		  dp[0][i]=i;
	// Inserting all characters to str1
	  // Fill the dp array
	  for(int i=1 ; i<=m ; i++) 
		  for(int j=1 ; j<=n ; j++) 
			  if(x.charAt(i-1)==y.charAt(j-1))
			  dp[i][j]=dp[i-1][j-1];
			  else {
				  dp[i][j]=1+Math.min(dp[i-1][j]// Deletion
						  	  , Math.min( dp[i][j-1]// Insertion
						  			  , dp[i-1][j-1]));//substitution
			  }
		  
	  
	  return dp[m][n];
  }
  
  //using memoization
  private static HashMap<String ,Integer> memo = new HashMap<>();
  static int getd(String x,String y,int i,int j) {
	  //base case
	  if(i==0 || j==0)
		  return 0;
	  String key = i+""+j;
	  if(memo.containsKey(key))
		  return memo.get(key);
	// Check if the result is already computed
	// If the characters are the same, no operation is needed
	  if(x.charAt(i-1)==y.charAt(j-1))
		  memo.put(key, getd(x,y,i-1,j-1));
	  else {
		  // Calculate the minimum of the three operations
		  int insert = getd(x,y,i,j-1);
		  int delete= getd(x,y,i-1,j);
		  int sub=getd(x,y,i-1,j-1);
		  memo.put(key, 1+Math.min(insert, Math.min(delete, sub)));
	  }
	  return memo.get(key);
  }
  
  public static void main(String[] args) {
	  String str1 = "kitten";
      String str2 = "sitting";

      int distance =getd(str1, str2,str1.length(),str2.length());
      System.out.println("Edit Distance: " + distance);
}
}
