package Sort;

public class QuickSort {

	public static int partition(int ar[],int low,int high) {
		int pivot = ar[high];
		int i = low-1;
		for(int j=low ; j<high; j++) {
			if(ar[j]<pivot) {
				i++;
				swap(ar,i,j);
			}
		}
		// Move pivot after smaller elements and
        // return its position
		swap(ar,i+1,high);
		
		return i+1;
	}
	public static void swap(int ar[],int i,int j) {
		int temp =ar[i];
		ar[i]=ar[j];
		ar[j]=temp;
		
	}
	public static void quicksort(int ar[],int low, int high) {
       if(low<high) {
    	   // pi is the partition return index of pivot
           int pi = partition(ar,low,high);
        // Recursion calls for smaller elements
           // and greater or equals elements
           quicksort(ar,low,pi-1);
           quicksort(ar,pi+1,high);
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
		quicksort(ar,0,ar.length-1);
	 	System.out.println("After sorting");
		printArray(ar);
}
}
