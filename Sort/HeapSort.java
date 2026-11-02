package Sort;

public class HeapSort {
	public static void heapify(int ar[],int n , int i) {
		 // Initialize largest as root
		int largest=i;
		 // left index = 2*i + 1
		int left=2*i+1;
		//right index  2*i+2
		int right=2*i+2;
		// If left child is larger than root
		if(left<n && ar[left]>ar[largest] ) {
			largest=left;
		}
		if(right<n && ar[right]>ar[largest]) {
			largest=right;
		}
		// If largest is not root
		if(largest!=i) {
			int temp=ar[i];
			ar[i]=ar[largest];
			ar[largest]=temp;
			heapify(ar,n,largest);
		}
		
	}
	public static void heapsort(int ar[]) {
		int n=ar.length;
		for(int i=n/2-1;i>=0;i--) {
			heapify(ar,n,i);
		}
		 // One by one extract an element from heap
		for(int i = n-1; i>0 ; i--) {
			int temp = ar[0];
			ar[0]=ar[i];
			ar[i]=temp;
			// Call max heapify on the reduced heap
			heapify(ar,i,0);
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
		heapsort(ar);
		System.out.println("After sorting");
		printArray(ar);
}
}
