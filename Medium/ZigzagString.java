package Medium;

public class ZigzagString {
	public static String convert(String s,int numRows) {
		if (numRows <= 1 || numRows >= s.length()) {
            return s; // No zigzag needed
        }

        StringBuilder[] rows = new StringBuilder[Math.min(numRows, s.length())];
        for (int i = 0; i < rows.length; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);
            if (currentRow == 0) {
                goingDown = true; // Start going down
            } else if (currentRow == numRows - 1) {
                goingDown = false; // Start going up
            }
            currentRow += goingDown ? 1 : -1; // Move up or down
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
	}
public static void main(String[] args) {
	String x = "PAYPALISHIRING";
	System.out.println(convert(x,3));
}
}
