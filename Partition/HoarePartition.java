package Partition;

public class HoarePartition {
	
	public static void partition(int ar[]) {
		int n=ar.length;
		int pivot = ar[n-1];
		int j=n,i=-1;
		while(true) {
			do {
				i++;
			}while(ar[i]<pivot);
			do {
				j--;
			}while(ar[j]>pivot);
			
			if(i>j)break;
			 // swap larger and smaller elements
			int temp = ar[i];
			ar[i]=ar[j];
			ar[j]=temp;
			
		}
		
	}
	static void print(int ar[]) {
		for(int i=0 ; i<ar.length;i++)
			System.out.print(ar[i]+" ");
		System.out.println();
	}
	public static void main(String[] args) {
	int ar[] = {2,5,6,4,1,10,7,15,13,14,12,8};
    System.out.print("Before partition : ");
    print(ar);
    partition(ar);
    System.out.print("After partition : ");
    print(ar);
	}
}
