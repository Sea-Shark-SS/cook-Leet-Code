package Hard;

import java.util.ArrayList;
import java.util.List;

public class Nqueens1 {
	 public static List<List<String>> solveNQueens(int n) {
	        List<List<String>> result = new ArrayList<>();
	        char[][] board = new char[n][n];
	        for (int i = 0; i < n; i++) {
	            for (int j = 0; j < n; j++) {
	                board[i][j] = '.';
	            }
	        }
	        backtrack(result, board, 0);
	        return result;
	    }

	    private static void backtrack(List<List<String>> result, char[][] board, int row) {
	        if (row == board.length) {
	            List<String> solution = new ArrayList<>();
	            for (char[] rowArray : board) {
	                solution.add(new String(rowArray));
	            }
	            result.add(solution);
	            return;
	        }
	        for (int col = 0; col < board.length; col++) {
	            if (isValid(board, row, col)) {
	                board[row][col] = 'Q';
	                backtrack(result, board, row + 1);
	                board[row][col] = '.';
	            }
	        }
	    }

	    private static boolean isValid(char[][] board, int row, int col) {
	        for (int i = 0; i < row; i++) {
	            if (board[i][col] == 'Q') {
	                return false;
	            }
	            if (col - (row - i) >= 0 && board[i][col - (row - i)] == 'Q') {
	                return false;
	            }
	            if (col + (row - i) < board.length && board[i][col + (row - i)] == 'Q') {
	                return false;
	            }
	        }
	        return true;
	    }

	    public static void main(String[] args) {
	       
	        List<List<String>> result = solveNQueens(4);
	        for (List<String> solutionArray : result) {
	            for (String row : solutionArray) {
	                System.out.println(row);
	            }
	            System.out.println();
	        }
	    }
}
