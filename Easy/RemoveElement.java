package Easy;

public class RemoveElement {
public static int removeElement(int[] nums,int val) {
	 int k = 0; // Pointer for the position of the next non-val element
     for (int i = 0; i < nums.length; i++) {
         if (nums[i] != val) {
             nums[k] = nums[i]; // Place the non-val element at index k
             k++; // Move the pointer forward
         }
     }
     return k; 

}

public static void main(String[] args) {
	int[] ar = {1,0,1,2,2,3,0,4,2};
	int[] a= {3,2,2,3};
	System.out.println("sdfas");
	System.out.println(removeElement(ar,3));
	int k=removeElement(ar,3);
	for(int i=0;i<k;i++)
		System.out.print(ar[i]+" ");
}
}
