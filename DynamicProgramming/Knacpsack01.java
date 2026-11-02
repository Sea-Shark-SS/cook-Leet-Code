package DynamicProgramming;

import java.util.HashMap;

public class Knacpsack01 {
	static class Item{
		int weight;
		int value;
		Item(int weight,int value){
			this.weight=weight;
			this.value=value;
		}
	}
	
 static	HashMap<String ,Integer> memo = new HashMap<>();
	
//using memoization 
	//n=length of Item array 
public static int getMax(int capacity,Item[] item,int n) {
		// Base case
	if(n==0 || capacity == 0)
	return 0;
		// Create a unique key for the current state
	String key = n+"-"+capacity;
	
	if(memo.containsKey(key))
		return memo.get(key);
     // If the weight of the nth item is more than the capacity, skip it
	if(item[n-1].weight>capacity)
		return getMax(capacity,item,n-1);
	else {
			 // Return the maximum of including or excluding the nth item
	int include = item[n-1].value+ getMax(capacity-item[n-1].weight,item,n-1);
	int exclude = getMax(capacity,item,n-1);
	int result = Math.max(include, exclude);
	// Store the result in the memoization map
	memo.put(key, result);
	System.out.println("Result "+n+" : "+memo.get(key));
	return result;
		}
	}
// applying Tabulation
  public static int knapsack(int capacity,Item[] item,int n) {
	  if(n==0 || capacity==0)
		  return 0;
      // Create a 2D array to store the maximum value for each subproblem
    int[][] dp = new int[n+1][capacity+1];
    // Build the dp array
    for(int i= 1 ;i<=n;i++) 
    	for(int j=0 ; j<=capacity;j++)
    		if(item[i-1].weight<=j) {
    			// Item can be included
    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-item[i-1].weight]+item[i-1].value);
    	}  else {
    		// Item cannot be included
    		dp[i][j]=dp[i-1][j];
    		}
    	
    
    // The maximum value is in the bottom-right cell of the dp array
    return dp[n][capacity];
  }


	public static void main(String[] args) {
		Item[] items = {
	            new Item(2, 3),
	            new Item(3, 4),
	            new Item(4, 5),
	            new Item(5, 6)
	        };
	        int capacity = 5;
	        int n = items.length;
   System.out.println(knapsack(capacity,items,n));
	        //int maxValue = getMax(capacity, items, n);
	        //System.out.println(maxValue);
	}
}
