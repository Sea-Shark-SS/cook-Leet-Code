package Easy;

public class LengthOfLastWord {

	public static int lengthOfLastWord(String s) {
        // Trim the string to remove leading and trailing spaces
        s = s.trim();
        return lengthOfLastWordHelper(s, s.length() - 1);
    }

    private static int lengthOfLastWordHelper(String s, int index) {
        // Base case: if index is less than 0, return 0 (no characters left)
        if (index < 0) {
            return 0;
        }

        // If we encounter a space and we are not at the end of the string,
        // it means we have finished counting the last word
        if (s.charAt(index) == ' ') {
            // If we are at the end of the string, return 0
            if (index == s.length() - 1) {
                return lengthOfLastWordHelper(s, index - 1);
            }
            // If we are not at the end, return the length of the last word
            return 0;
        }

        // Count the character and move to the previous character
        return 1 + lengthOfLastWordHelper(s, index - 1);
    }
	
/*	public static int lengthOfLastWord(String s) {
     int length=0;
     String[] word = s.split(" ");
     String temp=null;
     int i=0;
     while(i<word.length) {
    	 temp=word[i];
    	 i++;
     }
     length=temp.length();
     return length;
    }
    */
public static void main(String[] args) {
	String s ="Hello world";
	System.out.println(lengthOfLastWord(s));
}
}
