package Sort;

import java.util.ArrayList;
import java.util.List;

public class BucketSort {
    // Insertion sort function to sort individual buckets
     public static void insertionsort(List<Double> bucket) {
    	for(int i=0 ; i<bucket.size() ; i++) {
		double key = bucket.get(i);
		int j=i-1;
		while(j>=0 && bucket.get(j)>key) {
			bucket.set(j+1,bucket.get(j));
			j--;
		}
		bucket.set(j+1,key);
	  }
   }
     // Function to sort arr[] of size n using bucket sort

     public static void bucketsort(double ar[]) {
     int n=ar.length;
  // 1) Create n empty buckets
     List<Double>[] bucket = new ArrayList[n];
     for(int i=0 ; i<n ; i++)
    	 bucket[i] = new ArrayList<>();
     // 2) Put array elements in different buckets
     for(int i=0 ; i<n ; i++) {
    	 int bi = (int)(n*ar[i]);
    	 bucket[bi].add(ar[i]);
     }
     // 3) Sort individual buckets using insertion sort
    for(int i=0 ; i<n ; i++)
    	insertionsort(bucket[i]);
 // 4) Concatenate all buckets into arr[]
    int index=0;
    for(int i=0 ; i<n;i++) 
    	for(int j=0 ; j<bucket[i].size();j++) 
    		ar[index++]=bucket[i].get(j);     
     }
     public static void main(String[] args) {
         double[] arr = {0.897, 0.565, 0.656, 0.1234, 0.665, 0.3434};
         bucketsort(arr);

         System.out.println("Sorted array is:");
         for (double num : arr) {
             System.out.print(num + " ");
         }
     }
}
