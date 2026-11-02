package Medium;

public class REGEXP {
	public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        
        // Create a DP table
        boolean[][] dp = new boolean[m + 1][n + 1];
        
        // Base case: empty string and empty pattern
        dp[0][0] = true;
        
        // Handle patterns like a*, a*b*, etc. that can match an empty string
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        
        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sChar = s.charAt(i - 1);
                char pChar = p.charAt(j - 1);
                
                if (sChar == pChar || pChar == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pChar == '*') {
                    dp[i][j] = dp[i][j - 2] || (matches(sChar, p.charAt(j - 2)) && dp[i - 1][j]);
                }
            }
        }
        
        return dp[m][n];
    }
    
    private static boolean matches(char sChar, char pChar) {
        return sChar == pChar || pChar == '.';
    }
    public static void main(String[] args) {

        System.out.println(isMatch("aa", "a"));          // Output: false
        System.out.println(isMatch("aa", "a*"));         // Output: true
        System.out.println(isMatch("ab", ".*"));         // Output: true
        System.out.println(isMatch("aab", "c*a*b"));     // Output: true
        System.out.println(isMatch("mississippi", "mis*is*p*.")); // Output: false
    }
}
