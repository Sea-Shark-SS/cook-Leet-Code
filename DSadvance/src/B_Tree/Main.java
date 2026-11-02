package B_Tree;

public class Main {
/*
 * The limitations of traditional binary
 *  search trees can be frustrating.
 *  properties of binary tree
 * 1.When it comes to storing and searching large amounts 
 * of data, traditional binary search trees 
 * can become impractical due to 
 * their poor performance and high memory usage. 
 * 2.B-Trees, also known as B-Tree or Balanced Tree,
 * are a type of self-balancing tree that was specifically
 * designed to overcome these limitations.
 * 3.Unlike traditional binary search trees,
 * B-Trees are characterized by the large number of keys
 * that they can store in a single node,
 * which is why they are also known as “large key” trees.
 * 4.Each node in a B-Tree can contain multiple keys,
 * which allows the tree to have a larger branching factor
 * and thus a shallower height.
 * 5.B-Trees are particularly well suited
 * for storage systems that have slow,
 * bulky data access such as hard drives, flash memory, and CD-ROMs.
 * 6.B-Trees maintains balance by ensuring
 * that each node has a minimum number of keys,
 * so the tree is always balanced. 
 * 7.(Complexity for each operations)
 *   1.	Search	O(log n)
     2.	Insert	O(log n)
     3.	Delete	O(log n)
 *8.All leaves are at the same level.
B-Tree is defined by the term minimum degree ‘t‘. The value of
 ‘t‘ depends upon disk block size.
Every node except the root must contain at least t-1 keys.
 The root may contain a minimum of 1 key.
All nodes (including root) may contain at most (2*t – 1) keys.
Number of children of a node is equal to the number of keys in it plus 1.
All keys of a node are sorted in increasing order.
The child between two keys k1 and k2 contains all keys
 in the range from k1 and k2.
B-Tree grows and shrinks from the root which is unlike Binary Search Tree.
Binary Search Trees grow downward and also shrink from downward.
Like other balanced Binary Search Trees,
 the time complexity to search, insert, and delete is O(log n).
Insertion of a Node in B-Tree happens only at Leaf Node.
 *
 *   
 */
	
}
