package HeapDataStructure;

import java.util.ArrayList;

public class MinHeap {
 private ArrayList<Integer> heap ;
 public MinHeap() {
	 heap= new ArrayList<Integer>();
 }
 private int leftChild(int index) {
	 return 2*index+1;
 }
 private int rightChild(int index) {
	 return 2*index+2;
 }
 private int parent(int index) {
	 return (index-1)/2;
 }
 private void swap(int i ,int j) {
	 int temp =heap.get(i);
	 heap.set(i,heap.get(j));
	 heap.set(j,temp);
 }
 public void printMinHeap() {
	 for(Integer val:heap) {
		 System.out.print(val+" ");
	 }
	 System.out.println();
 }
 public void insert(int value) {
	// Add the new value at the end
	 heap.add(value);
	// Get the index of the newly added value
	 int index=heap.size()-1;
	// Restore the min heap property
	 while(index>0 && heap.get(parent(index))>heap.get(index)) {
		 swap(index,parent(index));
		 index=parent(index);
	 }
	}
 public void Heapify(int index) {
	  int smallest=index;
	  int left = leftChild(index);
	  int right = rightChild(index);
	  if(left<heap.size() && heap.get(left)<heap.get(smallest))
	   smallest=left;
	  if(right<heap.size() && heap.get(right)<heap.get(smallest))
		  smallest=right;
	  if(smallest!=index) {
		 swap(index,smallest); 
	     Heapify(smallest);
	  }
  }
 
 
}
