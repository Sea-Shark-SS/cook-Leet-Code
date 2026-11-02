package Medium;

public class SpacialArray_II {
	static boolean isSpecial(int[] num,int from,int to) {
		for(int i=from;i<to;i++) {
			if(num[i]%2==num[i+1]%2)
				return false;
		}
		return true;
	}
public static boolean[] isArraySpecial(int[] nums, int[][] queries) {
	
        boolean[] answer = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int from = queries[i][0];
            int to = queries[i][1];
            answer[i] = isSpecial(nums, from, to);
        }
        
        return answer;
    }
public static void main(String[] args) {
	int[] x = {2,2};
	int[][] y = {{0,0}};
	System.out.println(isArraySpecial(x,y)[0]);
	//System.out.println(isArraySpecial(x,y)[1]);
	
}
}
