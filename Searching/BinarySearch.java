package Searching;

public class BinarySearch {

	public static int binarySearch(int ar[],int element) {
		int low=0, high = ar.length-1;
		while(low<=high) {
			int mid = low+ (high-low)/2;
			if(ar[mid]==element)
				return mid;
			if(ar[mid]<element)
				low=mid+1;
			else
				high=mid-1;
				
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
	int[] ar= {2,8,6,7,9,10,15,18};
	int x=18;
	System.out.println("Index of "+x+" : "+binarySearch(ar,x));
}
}
