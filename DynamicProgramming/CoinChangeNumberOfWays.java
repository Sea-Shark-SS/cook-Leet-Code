package DynamicProgramming;

public class CoinChangeNumberOfWays {

	static void coinChange(int coin[],int amount) {
		int dp[][] = new int[coin.length+1][amount+1];
		dp[0][0]=1;
		for(int i=1 ; i<=coin.length; i++)
			for(int j=0 ; j<=amount ; j++) {
				dp[i][j]+=dp[i-1][j];
				if(j-coin[i-1]>=0)
					dp[i][j]+=dp[i][j-coin[i-1]];
			}
		System.out.println("Table of the dp result");
		for(int i=0 ; i<=coin.length ;i++)
		{
			for(int j=0 ; j<=amount ;j++)
				System.out.print(dp[i][j]+" ");
			System.out.println();
		}
 System.out.println("Result for the number of ways "+dp[coin.length][amount]);
	  
	}
	
	
	public static void main(String[] args) {
      int[] coin = {1,2,3};
      int amount =6;
      coinChange(coin,amount);
    }
}
