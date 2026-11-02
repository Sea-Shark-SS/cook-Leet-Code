package Easy;

public class IndexFirstOccurance {
public static int strStr(String haystack,String needle) {
	// If needle is an empty string, return 0
    if (needle.isEmpty()) {
        return 0;
    }
    // Use indexOf to find the first occurrence of needle in haystack
    return haystack.indexOf(needle);
}
public static void main(String[] args) {
	String s1="sadbutsad";
	String s2= "sad";
	int k=strStr(s1,s2);
	System.out.println(k);
}
}
