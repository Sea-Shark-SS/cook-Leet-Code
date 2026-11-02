package Sort;

public class SelectionSort {

	public static void selectionSort(int ar[]) {
		int n = ar.length;
		
		for(int i=0 ;i<n-1;i++) {
			int min=i;
			for(int j = i+1;j<n;j++) {
				if(ar[j]<ar[min])
					min=j;
			}
			int temp = ar[i];
			ar[i]=ar[min];
			ar[min]=temp;
		}
	}
	public static void printArray(int ar[]) {
		for(int i =0 ; i<ar.length;i++)
			System.out.print(ar[i]+" ");
		System.out.println();
	}
	public static void main(String[] args) {
	int [] ar = {25,6,20,10,12,14,16,2,8,4,3,5,9,1};
	System.out.println("Before sorting");
	printArray(ar);
	selectionSort(ar);
	System.out.println("After sorting");
	printArray(ar);
}
}
