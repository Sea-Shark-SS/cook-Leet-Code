package Medium3;

public class UniquePath1 {
	public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        // Initialize the starting point
        dp[0][0] = 1;

        // Fill the dp array
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0) {
                    dp[i][j] += dp[i - 1][j];  // From the cell above
                }
                if (j > 0) {
                    dp[i][j] += dp[i][j - 1];  // From the cell to the left
                }
            }
        }

        return dp[m - 1][n - 1];
    }
	public static void main(String[] args) {
		int m=3 ;
		int n=2 ;
		
		System.out.println(uniquePaths(m,n));
	}
}
