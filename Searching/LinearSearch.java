package Searching;

public class LinearSearch {
public static int linearSearch(int ar[],int element) {
	for(int i=0 ; i<ar.length ;i++) {
		if(ar[i]==element)
			return i;
	}
	return -1;
}
	
	
	public static void main(String[] args) {
	int[] ar= {1,5,3,6,4};
    System.out.println(linearSearch(ar,6));
	
	}
}
