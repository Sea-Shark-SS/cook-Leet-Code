package Easy;

public class PlusOne {
public static int[] plusOne(int[] digits) {
	int n=digits.length;
	for(int i=n-1;i>=0;i--) {
		if(digits[i]<9) {
			digits[i]++;
			return digits;
		}
		digits[i]=0;
	}
	int[] newNumber = new int[n-1];
	newNumber[0]=1;
	return newNumber;
}
public static void main(String[] args) {
	int[] d = {4,5,7,6,5,4,5,1,4,5,5,4,7,9,6,3,5,1,4,9,3,0,2,0,1,0,2,9};
	d=plusOne(d);
	for(int x :d)
		System.out.print(x+" ");
}
}
