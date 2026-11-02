package DivideAndConquer;

public class MergeSort {
   static void merge(int[] ar,int l,int m,int r) {
	// Find sizes of two subarrays to be merged
			int n1= m-l+1;
			int n2= r-m;
			 // Create temp arrays
			int[] l1 = new int[n1];
			int[] m1 = new int[n2];
			// Copy data to temp arrays
			for(int i =0 ; i<n1 ; i++)
				l1[i]=ar[l+i];
			for(int i=0 ; i<n2;i++)
				m1[i]=ar[m+1+i];
			int i=0,j=0;
			 // Initial index of merged subarray array
			int k =l;
			while(i<n1 && j <n2) {
				if(l1[i]<=m1[j]) {
					ar[k]=l1[i];
					i++;
				}else {
					ar[k]=m1[j];
					j++;
				}
				k++;
			}
			  // Copy remaining elements of L[] if any
			while(i<n1) {
				ar[k]=l1[i];
				i++;
				k++;
			}
			  // Copy remaining elements of M[] if any
			while(j<n2) {
				ar[k]=m1[j];
				j++;
				k++;
			}
	   }
   public static void mergeSort(int ar[],int l ,int r) {
		// Main function that sorts arr[l..r] using
	   if(l<r) {
		// Find the middle point
		   int m = l+(r-l)/2;
		   // Sort first and second halves
		   mergeSort(ar,l,m);
		   mergeSort(ar,m+1,r);
		// Merge the sorted halves
		   merge(ar,l,m,r);
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
	mergeSort(ar,0,ar.length-1);
	System.out.println("After sorting");
	printArray(ar);
}
}
