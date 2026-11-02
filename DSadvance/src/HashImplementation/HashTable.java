package HashImplementation;

import java.util.Collections;
import java.util.LinkedList;

public class HashTable {
/*	
	
m = Number of slots in hash table
n = Number of keys to be inserted in hash table


Load factor α = n/m
Expected time to search = O(1 + α)
Expected time to delete = O(1 + α)


Time to insert = O(1)
Time complexity of search insert and delete is O(1) if  α is O(1)
*/	
	//Static Bucket size
	private final int bucket;
		
LinkedList<Integer>[] table ;
  public HashTable(int b){
	this.bucket=b;
	table = new LinkedList[this.bucket];
	
	for(int i =0 ; i<this.bucket;i++) {
		table[i] = new LinkedList<>();
	    } 
     }
  public int hashfunction(int val) {
	  return val%(this.bucket);
  }
  public int indexOf(int value) {
	  return hashfunction(value);
  }
  public void insert(int value) {
	  int key = hashfunction(value);
	  table[key].add(value);
  }
  public void delete(int value) {
	  int key = hashfunction(value);
	  //if the value doesnt exists
	  if(!table[key].contains(value)) {
		  System.out.println("Value does not belong to the table");
		  return;
	  }
		  
	  int index=table[key].indexOf(value);
	  table[key].remove(index);
  }
  public Boolean search(int value) {
	  int key=hashfunction(value);
	  return table[key].contains(value);
  }
  public void sortHash() {
	  for(int i =0 ; i<this.bucket;i++) {
		  Collections.sort(table[i]);
	  }
  }
  public void sortHashReverse() {
	  for(int i =0;i<this.bucket;i++) {
		  Collections.sort(table[i]);;
	  }
  }
  public int sizeOf() {
	  int s=0;
	  for(int i =0 ; i<this.bucket;i++) {
		  Integer x=table[i].size();
		  s+=x.BYTES*8;
	  }
	  
	  return s;
  }
  public void printHashTable() {
	  System.out.println("Key   value");
	  for(int i =0 ; i<this.bucket;i++) {
		  System.out.print(i+" :");
		  for(Integer t : table[i]) {
			System.out.print(" "+t);  
		  }
		  System.out.println();
	  }
  }
}
