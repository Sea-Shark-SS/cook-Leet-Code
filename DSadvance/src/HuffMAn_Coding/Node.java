package HuffMAn_Coding;

public class Node {
 int freq;
 char c;
 Node left,right;
 public Node(int freq,char c) {
	 this.c=c;
	 this.freq=freq;
	 this.right=null;
	 this.left=null;
 }
}
