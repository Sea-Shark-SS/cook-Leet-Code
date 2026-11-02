package Hard;

public class WildCardMatching {
	 public static boolean isMatch(String s, String p) {
	        int m = s.length();
	        int n = p.length();
	        
	        // Create a DP table
	        boolean[][] dp = new boolean[m + 1][n + 1];
	        
	        // Base case: empty pattern matches empty string
	        dp[0][0] = true;

	        // Fill the first row for patterns like "*", "**", etc.
	        for (int j = 1; j <= n; j++) {
	            if (p.charAt(j - 1) == '*') {
	                dp[0][j] = dp[0][j - 1];
	            }
	        }

	        // Fill the DP table
	        for (int i = 1; i <= m; i++) {
	            for (int j = 1; j <= n; j++) {
	                if (p.charAt(j - 1) == '*') {
	                    // '*' can match zero characters (dp[i][j-1]) or one/more characters (dp[i-1][j])
	                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
	                } else if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
	                    // Match single character or '?'
	                    dp[i][j] = dp[i - 1][j - 1];
	                }
	            }
	        }

	        return dp[m][n];
	    }

	    public static void main(String[] args) {
	        System.out.println(isMatch("aa", "a")); // Output: false
	        System.out.println(isMatch("aa", "*")); // Output: true
	        System.out.println(isMatch("cb", "?a")); // Output: false
	        System.out.println(isMatch("adceb", "*a*b")); // Output: true
	        System.out.println(isMatch("acdcb", "a*c?b")); // Output: false
	    }
}
