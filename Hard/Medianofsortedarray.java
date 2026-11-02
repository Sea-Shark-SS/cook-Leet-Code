package Hard;

import java.util.Arrays;

public class Medianofsortedarray {

public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    double median=0;
    int count=0;
    int[] merge = new int[nums1.length+nums2.length];
    
    for(int i=0;i<nums1.length;i++) {
    	merge[i]=nums1[i];
    	count++;
    }
    for(int i=0;i<nums2.length;i++,count++) {
    	merge[count]=nums2[i];    		
    }
    Arrays.sort(merge);
    if(merge.length%2!=0) {
    	median=merge[(0+merge.length)/2];
    }else {
    	int l=((1+merge.length)/2)-1;
    	int r=((1+merge.length)/2);
    	
    	median=merge[l]+merge[r];
    	median/=2;
    }
    
	return median;
    }
	
	public static void main(String[] args) {
	int[] n1  = {1,3};
	int[] n2 = {2,4};
	double m=findMedianSortedArrays(n1,n2);
	System.out.println(m);
}
}
