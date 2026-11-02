package Searching;

public class BinarySearchRecursion {

	public static int binarySearch(int ar[],int low,int high,int key) {
		if(low<=high) {
			int mid=low+(high-low)/2;
			
			if(ar[mid]==key)
				return mid;
			
			if(ar[mid]<key) {
				return binarySearch(ar,mid+1,high,key);
			}else {
				return binarySearch(ar,low,mid-1,key);
			}
		}
		
		
		return -1;
	}
	public static void main(String[] args) {
	int ar[] = {2,4,6,8,10,12,15,18};
	int x=2;
	System.out.println("index of "+x+" : "+binarySearch(ar,0,ar.length-1,18));
}
}
