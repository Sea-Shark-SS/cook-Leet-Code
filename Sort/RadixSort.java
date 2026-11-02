package Sort;

import java.util.Arrays;

public class RadixSort {
	public static void radixsort(int ar[]) {
		int n= ar.length;
		int max = Arrays.stream(ar).max().getAsInt();
		for(int exp = 1 ; max/exp>0;exp*=10) {
			countingsort(ar,n,exp);
		System.out.println(max/exp);
		}
	}
	public static void countingsort(int ar[],int n,int exp) {
		int[] output = new int[n];
		int[] count = new int[10];
		int i;
		Arrays.fill(count,0);
		// Store count of occurrences in count[]
		for( i=0 ; i<n ; i++)
			count[(ar[i]/exp)%10]++;
		
        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for(i=1; i<10 ; i++)
        	count[i]+=count[i-1];
        // Build the output array
        for(i =n-1; i>=0 ; i--) {
        	output[count[(ar[i]/exp)%10]-1]=ar[i];
        	count[(ar[i]/exp)%10]--;
        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to current
        // digit
        
		System.arraycopy(output, 0, ar, 0, n);
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
		radixsort(ar);
		System.out.println("After sorting");
		printArray(ar);
}
}
