package Medium;

import java.util.HashMap;

public class SubString {
    public static int lengthOfLongestSubstring(String s) {
    	int maxlen=0;
    	HashMap<Character,Integer> c = new HashMap<>();
    	int start=0;
    	for(int i=0;i<s.length();i++) {
    		char ch = s.charAt(i);
    		if(c.containsKey(ch)) {
    			start=Math.max(start, c.get(ch)+1);
    		}
    		c.put(ch, i);
    		maxlen=Math.max(maxlen,i-start+1);
    	}
    	return maxlen;
    }
	public static void main(String[] args) {
	String s = "abcabcbb";
	int x=lengthOfLongestSubstring(s);
	System.out.println(x);
 }
}
