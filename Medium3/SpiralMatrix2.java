package Medium3;

public class SpiralMatrix2 {
	 public static int[][] generateMatrix(int n) {
	        int[][] matrix = new int[n][n];
	        int top = 0, bottom = n - 1;
	        int left = 0, right = n - 1;
	        int num = 1;

	        while (top <= bottom && left <= right) {
	            // Fill top row
	            for (int i = left; i <= right; i++) {
	                matrix[top][i] = num++;
	            }
	            top++;

	            // Fill right column
	            for (int i = top; i <= bottom; i++) {
	                matrix[i][right] = num++;
	            }
	            right--;

	            // Fill bottom row if applicable
	            if (top <= bottom) {
	                for (int i = right; i >= left; i--) {
	                    matrix[bottom][i] = num++;
	                }
	                bottom--;
	            }

	            // Fill left column if applicable
	            if (left <= right) {
	                for (int i = bottom; i >= top; i--) {
	                    matrix[i][left] = num++;
	                }
	                left++;
	            }
	        }

	        return matrix;
	    }

	    public static void main(String[] args) {
	        int n = 3;
	        int[][] result = generateMatrix(n);
	        
	        // Print the generated matrix
	        for (int[] row : result) {
	            for (int val : row) {
	                System.out.print(val + " ");
	            }
	            System.out.println();
	        }
	    }
}
