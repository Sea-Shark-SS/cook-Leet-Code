package Partition;

public class NaivePartition {

	public static void partition(int ar[]) {
		int pivot = ar[ar.length-1];
		int index = 0;
		int n = ar.length;
		int[] temp = new int[n];
		for(int i=0;i<n;i++)
			if(ar[i]<=pivot) {
				temp[index++]=ar[i];
			}
		
		for(int i=0 ; i<n ; i++)
			if(ar[i]>pivot) {
				temp[index++]=ar[i];
			}
		for(int i =0 ;i<n ;i++)
			ar[i]=temp[i];
	}
	static void print(int a[]) {
		for(int i=0 ; i <a.length;i++)
			System.out.print(a[i]+" ");
		System.out.println();
	}
	public static void main(String[] args) {
      int ar[] = {2,5,6,3,7,9,10,15,11,16,12,13};
      System.out.println("Before partition : ");
      print(ar);
      partition(ar);
      System.out.println("After partition : ");
      print(ar);
 }
}
