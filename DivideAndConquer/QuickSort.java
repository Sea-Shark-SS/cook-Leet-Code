package DivideAndConquer;

public class QuickSort {
   static int partition(int[] a,int l,int r) {
	   int pivot=a[l];
	   int i=l;
	   int j=r+1;
	   while(i<j) {
	   do {
		  i++;
	   }while(i<=r && a[i]<pivot);
	   do {
		   j--;
	   }while(j>=l && a[j]>pivot);
	    if(i<j) {
	    	int temp=a[i];
		    a[i]=a[j];
		    a[j]=temp;	
	    }	    	
	   }
	   int temp =a[l];
	   a[l]=a[j];
	   a[j]=temp;
	   return j;
   }
	static void quicksort(int[] a,int l,int r) {
		if(l<r) {
			int pi=partition(a,l,r);
			quicksort(a,l,pi-1);
			quicksort(a,pi+1,r);
		}
	}
	public static void main(String[] args) {
		int a[]= {10,5,7,15,25,1,9,8,6,4};
		quicksort(a,0,a.length-1);
		for(int b :a)
			System.out.print(b+" ");
	}
}
