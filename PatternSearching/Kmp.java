package PatternSearching;

import java.util.ArrayList;

public class Kmp {
  
	static void lps(String pat,int[] lps){
   // len stores the length of longest prefix which 
   // is also a suffix for the previous index
		int len=0;
	 // lps[0] is always 0
     lps[0]=0;
     int i=1;
     while(i<pat.length())
     {
    	 if(pat.charAt(i)==pat.charAt(len)) {
    		 len++;
    		 lps[i]=len;
    		 i++;
    	 }else {
    		 if(len!=0) {
    		 // If there is a mismatch
    		 // Update len to the previous lps value 
             // to avoid redundant comparisons
    		 len= lps[len-1];
    	 }else
    	 {
    		 // If no matching prefix found, set lps[i] to 0
    		 lps[i]=0;
    		 i++;
    	 }
       }
     }
	}
	
	static ArrayList<Integer> kmp(String txt,String pat){
	//create 2 limiters for txt and pat
		int m = txt.length();
		int n = pat.length();
		int[] lps = new int[n];
		ArrayList<Integer> res = new ArrayList<>();
		lps(pat,lps);
		//Printing lps for pattern
		System.out.println("Lps of Pattern ");
		for(int i=0; i<n ;i++)
			System.out.print(lps[i]+" ");
		System.out.println();
		//Construction of lps done
		// Pointers i and j, for traversing 
        // the text and pattern
		int i=0;
		int j = 0;
		while(i<m) {
	 // If characters match, move both pointers forward
	 if(txt.charAt(i)==pat.charAt(j)) {
		 i++;
		 j++;
		// If the entire pattern is matched 
         // store the start index in result
		 if(j==n) {
			 res.add(i-j);
			// Use LPS of previous index to 
             // skip unnecessary comparisons
			 j = lps[j-1];
		 }
	 }else {
		// Use lps value of previous index
         // to avoid redundant comparisons
		 if(j!=0)
			 j = lps[j-1];
		 else
			 i++;
	   }
		
   }
				
		return res;
}
	
	public static void main(String[] args) {
	String txt = "ABAABABAAABABABAA";
	String pat = "ABA";
	ArrayList<Integer> r = kmp(txt,pat);
   for(int x : r)
	   System.out.print(x+" ");
   System.out.println();
	}
}
