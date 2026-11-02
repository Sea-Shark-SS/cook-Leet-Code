package DivideAndConquer;

public class BinarySearch {
      //using iterative solution
	 public static int binarySearch(int[] a,int element) {
		 int r=a.length-1;
		 for(int l=0 ; l<=r ; ) {
			 int m=(l+r)/2;
             if(a[m]==element)
            	 return m;
             if(element>a[m])
            	 l=m+1;
             else
            	 r=m-1;
		 }
		 
		 return -1;
	 }
	 //recursive solution
	 static int binarysearch(int[] a,int element,int l,int r) {
		 if(l<=r) {
			int m=(l+r)/2;
			if(a[m]==element)
				return m;
			if(a[m]<element)
			 return binarysearch(a,element,m+1,r);
			else
			  return binarysearch(a,element,l,m-1);
		 }		
		 return -1;
	 }
	 
	 
	 public static void main(String[] args) {
		int[] a = {1,2,5,8,9,10,11,15,17};
		int element =17;
		System.out.println(binarysearch(a,element,0,8));
	}
}
