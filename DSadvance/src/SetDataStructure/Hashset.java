package SetDataStructure;

import java.util.ArrayList;

public class Hashset implements Set {
	ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		Hashset(){
			for(int i=0 ; i<10 ; i++) {
				list.add(new ArrayList<>());
			}
		}
	
	public void add(int data) {
		int key = data%10;
		list.get(key).add(data);
	}
	
	   public void remove(int data) {
		   int key = data%10;
		   for(int i =0 ; i<list.get(key).size();i++) {
			   if(data==list.get(key).get(i))
				   list.get(key).remove(i);
		   }
	   }
	   public void removeAll() {
		   for(int i=0 ; i<10 ; i++)
			  list.get(i).removeAll(list.get(i));
	   }
	   public boolean contains(int x) {
		   int key = x%10;
		   for(int  i =0 ;i<list.get(key).size();i++)
			   if(x ==list.get(key).get(i))
				   return true;
		   return false;
	   }
	   public int maxValue() {
		   int max = list.get(0).get(0);
		   for(int  i =0; i<10;i++) {
			   for(int j=0 ; j<list.get(i).size() ; j++) {
				   if(max<list.get(i).get(j))
					   max=list.get(i).get(j);
			   }
		   }

		   return max;
	   }
	   public int minValue() {
		   int min=list.get(0).get(0);
		   for(int  i =0; i<10;i++) {
			   for(int j=0 ; j<list.get(i).size() ; j++) {
				   if(min>list.get(i).get(j))
					   min=list.get(i).get(j);
			   }
		   }
		   return min;
	   }
	   public int sizeOfSet() {
		   int size=0;
		   for(int i=0 ; i<10 ; i++) {
			   size=size+list.get(i).size();
		   }
		   return size;
	   }
	   public boolean isEmpty() {
		   boolean flag = false;
		   for(int i = 0 ; i<10;i++) {
			   if(list.get(i).isEmpty())
				   flag=true;
			   else
				   continue;
		   }
		   return flag;
	   }
	   
	   void printlist(ArrayList<ArrayList<Integer>> list) {
		   for(int i = 0 ; i<10 ; i++) {
			   if(!list.get(i).isEmpty()) {
			   for(Integer x : list.get(i)) {
				   System.out.print(x+" ");
			   }
			   System.out.println();
			   }
		   }
	   }
	   void print() {
		    printlist(list);
	   }
}
