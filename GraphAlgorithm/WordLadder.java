package GraphAlgorithm;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class WordLadder {

	public static int wordLevel(String start,String target,String[] ar) {
		int res=0;
		HashSet<String> st = new HashSet<>();
		for(int i=0 ; i<ar.length ; i++)
			st.add(ar[i]);
		// If the target is not in the set, return 0
        if (!st.contains(target)) {
            return 0;
        }
		
		Queue<String> q = new LinkedList<>();
		q.add(start);
		int m=start.length();
		while(!q.isEmpty()) {
			res++;
			int  l =q.size();
			// Iterate through all words at the same level --BFS
	for(int i=0 ; i<l ;i++) {
				String w=q.poll();
			 // For every character of the word
		for(int j=0 ; j<m ;j++) {
					// Retain the original character
               // at the current position
	   char[] temp=w.toCharArray();
		char ch =temp[j];
	for(char k='a' ; k<='z' ;k++) {
					temp[j]=k;
					String n = new String(temp);
	if(!st.contains(n))//condition 1 : check if the new word is found in set
	     continue;
	if(n.equals(target))//condition 2: check if the word matches the taarget
				      return res+1;
		st.remove(n);//remove the matched string
		q.add(n);//add the new String
				
				}
	  temp[j]=ch;
				}
			}
		}
		
		return res;
	}
	public static void main(String[] args) {
		String[] arr = new String[]{"poon", "plee", "same", 
                "poie", "plie", "poin", "plea"};
               String start = "toon";
               String target = "plea";
           System.out.println(wordLevel(start, target, arr));
	}
}
