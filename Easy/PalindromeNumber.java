package Easy;

public class PalindromeNumber {
public static boolean isPalindrome(int x) {
	String temp = Integer.toString(x);
	String[] t = temp.split("");
	String p="";
	int i=t.length-1;
	while(i>=0) {
		p=p.concat(t[i]);
		i--;
	}
	if(temp.endsWith(p))
		return true;
	else
	return false;
}
	
	public static void main(String[] args) {
    int x =10;
    System.out.println(isPalindrome(x));
  }
}
