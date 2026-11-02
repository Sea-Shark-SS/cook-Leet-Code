package Partition;

public class LumotoPartition {

	public static void partition(int ar[]) {
		int n = ar.length;
		int pivot=ar[n-1];
		int i=-1;
		for(int j=0 ; j<n ; j++) {
			if(ar[j]<pivot) {
				i++;
				int temp = ar[i];
				ar[i]=ar[j];
				ar[j]=temp;
			}
		}
		int temp =ar[i+1];
		ar[i+1]=ar[n-1];
		ar[n-1]=temp;
	}
	static void print(int ar[]) {
		for(int i=0 ; i<ar.length;i++)
			System.out.print(ar[i]+" ");
		System.out.println();
	}
	public static void main(String[] args) {
	int ar[] = {2,5,6,4,1,10,7,15,13,14,12,8};
    System.out.print("Before artition : ");
    print(ar);
    partition(ar);
    System.out.print("After partition : ");
    print(ar);
	}
}
