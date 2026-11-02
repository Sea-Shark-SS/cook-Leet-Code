package Sort;

import java.util.Arrays;

public class CountingSort {
	public static void countingsort(int ar[]) {
				
		int n=ar.length;
		if(n==0)
			return;
		// Step 1: Find the maximum value in the array
		int max = Arrays.stream(ar).max().getAsInt();
		 // Step 2: Create the counting array
		int[] count = new int[max+1];
		// Step 3: Count the occurrences of each element
		for(int num: ar)
			count[num]++;
		
		// Step 4: Modify the count array to be cumulative
		for(int i=1 ; i<count.length;i++)
			count[i]+=count[i-1];
		
		// Step 5: Build the output array
		int[] output = new int[n];
		for(int i=0 ; i<n ; i++) {
			output[count[ar[i]]-1]=ar[i];
			count[ar[i]]--;
		}
		 // Step 6: Copy the output array back to the original array
		System.arraycopy(output, 0, ar, 0, ar.length);	
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
		countingsort(ar);
		System.out.println("After sorting");
		printArray(ar);
}
}
