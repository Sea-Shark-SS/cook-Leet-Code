package Sort;

public class InsertionSort {

	public static void insertionSort(int ar[]) {
		int n = ar.length;
		for(int i =1 ; i<n ;i++) {
			int key= ar[i];
			int j=i-1;
          while(j>=0 && ar[j]>key) {
        	  ar[j+1]=ar[j];
        	  j=j-1;
          }
          ar[j+1]=key;
		}
	}
	public static void print(int ar[]) {
		for(int i=0 ; i<ar.length;i++)
			System.out.print(ar[i]+" ");
		System.out.println();
	}
	public static void main(String[] args) {
		int [] ar = {2,6,20,10,12,14,16,2,8,4,3,5,9,1};
		System.out.println("Before sorting");
		print(ar);
		insertionSort(ar);
		System.out.println("After sorting");
		print(ar);
}
}
