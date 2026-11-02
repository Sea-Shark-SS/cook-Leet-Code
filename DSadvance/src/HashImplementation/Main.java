package HashImplementation;

import java.util.HashMap;

public class Main {
public static void main(String[] args) {
	HashMap<Integer,Integer> m = new HashMap<>();
	HashTable table = new HashTable(7);
	table.insert(10);
	table.insert(15);
	table.insert(17);
	table.insert(7);
	table.insert(49);
	table.insert(5);
	table.insert(27);
	table.insert(25);
	table.insert(8);
	table.insert(16);
	//table.delete(100);
	table.printHashTable();
	//int x=table.indexOf(25);
	//System.out.println("Index of 25 : "+x);
	//System.out.println("After sorting the hashtable");
	//table.sortHash();
	//table.printHashTable();
	//System.out.println("After reverseorder");
	//table.sortHashReverse();
	//table.printHashTable();
	System.out.println(table.search(7));
	System.out.println(table.sizeOf());
	
}
}
