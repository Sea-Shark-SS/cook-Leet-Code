package Sort;

public class BubbleSort {

	public static void bubbleSort(int ar[]) {
		int n =ar.length;
		for(int i =0 ; i<n ; i++) 
			for(int j = i+1 ; j<n ; j++)
				if(ar[i]>ar[j]) {
					int temp = ar[i];
					ar[i]=ar[j];
					ar[j]=temp;
			}
	}
	public static void printArray(int ar[]) {
		for(int i=0 ;i<ar.length;i++)
			System.out.print(ar[i]+" ");
		System.out.println();
	}
	public static void main(String[] args) {
	int ar[]= {25,26,24,10,8,20,15,5,7,9,11,6,13,12};
	System.out.println("before sorting");
	printArray(ar);
	bubbleSort(ar);
	System.out.println("After soritng");
	printArray(ar);
}
}
