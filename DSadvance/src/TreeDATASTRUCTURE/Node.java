package TreeDATASTRUCTURE;

public class Node {
    //Binary tree has 3 important parts
    Node left ;
    Node right;
    int data;
    // Class containing left and right child
    // of current node and key value
    Node(int data){
        this.data=data;
        this.left=null;
        this.right=null;
    }
}
