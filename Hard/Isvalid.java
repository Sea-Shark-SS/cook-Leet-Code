package Hard;

public class Isvalid {
public static boolean isNumber(String s) {
	s=s.trim();
	boolean num =false ,dot=false,exp=false;
	for(int i=0 ;i<s.length();i++) {
		char c =s.charAt(i);
		if(c>='0' && c<='9')
			num=true;
		else if(c=='.') {
			if(dot || exp ) return false;
			dot=true;
		}else if(c=='e' || c=='E') {
			if(exp || !num) return false;
			exp=true;
			num=false;
		}else if(c=='+' || c=='-') {
			if(i!=0 && s.charAt(i-1) !='e' && s.charAt(i-1)!='E' )	return false;
			else
				return false;
		}
			
			
	}
	return num;
}
public static void main(String[] args) {
	System.out.println(isNumber("0"));
	System.out.println(isNumber("e"));
	System.out.println(isNumber("."));
	System.out.println(isNumber("90E3"));
}
}
