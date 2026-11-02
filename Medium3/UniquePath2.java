package Medium3;

public class UniquePath2 {
	public static int uniquePathsWithObstacles(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0][0] == 1) {
            return 0; // If the grid is empty or the starting cell is an obstacle
        }

        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];

        dp[0] = 1; // Start position

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) { // Obstacle
                    dp[j] = 0;
                } else {
                    if (j > 0) {
                        dp[j] += dp[j - 1]; // From left
                    }
                    // dp[j] already has the value from the previous row (i-1)
                }
            }
        }

        return dp[n - 1]; // Return the number of unique paths to the bottom-right corner
    }

    public static void main(String[] args) {
        
        int[][] grid = {
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0}
        };
        System.out.println(uniquePathsWithObstacles(grid)); // Output: 2
    }
}
