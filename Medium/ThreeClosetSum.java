package Medium;

import java.util.Arrays;

public class ThreeClosetSum {
public static int threeClosetSum(int[] ar,int target) {
	Arrays.sort(ar);
	int closetsum=Integer.MAX_VALUE;
	for(int i=0;i<ar.length;i++) {
		int left=i+1;
		int right=ar.length-1;
		while(left<right) {
			int cur=ar[i]+ar[left]+ar[right];
			if(Math.abs(cur-target)<Math.abs(closetsum-target)) {
				closetsum=cur;
			}
			if(cur<target)
				left++;
			else if(cur>target)
				right--;
			else
				return cur;
			
		}
	}
	
	
	return closetsum;
}

public static void main(String[] args) {
	int[] ar = {-1, 2, 1, -4};
	int t = 1;
	System.out.println(threeClosetSum(ar,t));
}
}
