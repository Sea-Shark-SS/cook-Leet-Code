package GreedyAlgorithm;

import java.util.Arrays;

public class MinimumCoin {
	public static int minCoin(int a[],int amount) {
		int res=0;
		Arrays.sort(a);
		for(int i=a.length-1 ; i>=0 ; i--) {
			if(amount!=0) {
				int count = amount/a[i];
				res+=count;
				amount-=(count*a[i]);
				
			}
		}
		return res;
	}
	public static void main(String[] args) {
	int[] coin = {5,10,2,1};
	int result = minCoin(coin,51);
	System.out.println(result);
 }
}
