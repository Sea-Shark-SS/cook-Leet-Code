package Medium;

public class InetegerToRoman {
public static String toRoman(int x) {
	String[] roman= {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
	int[] values= {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
	StringBuilder result = new StringBuilder();
	// Iterate through the values and build the Roman numeral
	for(int i=0;i<values.length;i++) {
		while(x>=values[i]) {
			result.append(roman[i]);
			x-=values[i];
		}
	}
	
	return result.toString();
}

public static void main(String[] args) {
	int x = 3749;
	System.out.println(toRoman(x));
}
}
