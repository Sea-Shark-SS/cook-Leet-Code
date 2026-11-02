package Medium;

public class ContainerMaxWater {
public static int maxArea(int[] height) {
	int maxArea=0;
	int left=0;
	int right=height.length-1;
	for(;left<right;) {
		int h=right-left;
		int w=Math.min(height[left], height[right]);
		int curArea=h*w;
		maxArea=Math.max(maxArea, curArea);
		if(height[left]<height[right])
			left++;
		else {
			right--;
		}
	}
	
	return maxArea;
}
public static void main(String[] args) {
	int[] x = {1,8,6,2,5,4,8,3,7};
	System.out.println(maxArea(x));
	
}
}
