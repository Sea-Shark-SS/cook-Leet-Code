package Hard;

public class Nqueens2 {
    public static int totalNQueens(int n) {
        int[] cols = new int[n];
        int[] hills = new int[2 * n - 1];
        int[] dales = new int[2 * n - 1];
        return backtrack(cols, hills, dales, 0, n);
    }

    private static int backtrack(int[] cols, int[] hills, int[] dales, int row, int n) {
        if (row == n) {
            return 1;
        }
        int count = 0;
        for (int col = 0; col < n; col++) {
            int hill = row - col + n - 1;
            int dale = row + col;
            if (cols[col] == 0 && hills[hill] == 0 && dales[dale] == 0) {
                cols[col] = 1;
                hills[hill] = 1;
                dales[dale] = 1;
                count += backtrack(cols, hills, dales, row + 1, n);
                cols[col] = 0;
                hills[hill] = 0;
                dales[dale] = 0;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        
        System.out.println(totalNQueens(4)); // Output: 2
    }

}
