package HuffMAn_Coding;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffMan {
 private Map<Character,String> h = new HashMap<>();
 private Map<String,Character> rh=new HashMap<>();
public void buildhuffmantree(String text) {
	Map<Character,Integer> fmap = new HashMap<>();
	for(char c : text.toCharArray()) {
		fmap.put(c,fmap.getOrDefault(c,0)+1);
	}
	// PriorityQueue to hold the nodes of the Huffman tree
	PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
	public int compare(Node a, Node b) {
	return 	a.freq-b.freq;
	}
	});
	
	// Add all characters to the priority queue
	for(Map.Entry<Character,Integer> entry : fmap.entrySet()){
		pq.add(new Node(entry.getValue(),entry.getKey()));
	}
	// Build the Huffman tree
	while(pq.size()>1) {
		Node left = pq.poll();
		Node right=pq.poll();
		Node newNode = new Node(left.freq+right.freq,'\0');
		newNode.left=left;
		newNode.right=right;
		pq.add(newNode);
		 
	}
	generateHuffmanCodes(pq.poll(), "");
}
public void generateHuffmanCodes(Node root,String code) {
	if (root == null) return;
	if (root.left == null && root.right == null) {
        h.put(root.c, code);
        rh.put(code,root.c );
    }
	generateHuffmanCodes(root.left,code+'0');
	generateHuffmanCodes(root.right,code+'1');
}
public Map<Character,String> getH(){
	return h;
}
StringBuilder encode = new StringBuilder();
public void encode(String text) {
	for(char c: text.toCharArray()) {
		encode.append(h.get(c));
	}
}
public String encodeString() {
	return encode.toString();
}
StringBuilder decode = new StringBuilder();
public void decode(String encode) {
	StringBuilder temp = new StringBuilder();
	for(char c : encode.toCharArray()) {
		temp.append(c);
		if(rh.containsKey(temp.toString())) {
			decode.append(rh.get(temp.toString()));
			temp.setLength(0);
		}
	}
}
public String decodeString() {
	return decode.toString();
}
}
