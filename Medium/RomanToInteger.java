package Medium;

public class RomanToInteger {
public static int toInteger(String s) {
	int result=0;
	int pre=0;
	for(int i = s.length()-1 ;i>=0;i--) {
		char c = s.charAt(i);
		int cur;
		switch(c) {
		case 'I':
			cur=1;
			break;
		case 'V':
			cur=5;
			break;
		case 'X':
			cur=10;
			break;
		case 'L':
			cur=50;
			break;
		case 'C':
			cur=100;
			break;
		case 'D':
			cur=500;
			break;
		case 'M':
			cur=1000;
			break;
			default :
				cur=0;
				
		}
		if(cur<pre) {
			result-=cur;
		}else {
			result+=cur;
		}
		pre=cur;
	}
	
	return result;
}
public static void main(String[] args) {
	String roman = "MMMDCCXLIX";

   System.out.println(toInteger(roman));
}
}
