package GreedyAlgorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanCoding {
	static class Node implements Comparable<Node>{
		Character c;
		Integer freq;
		Node left;
		Node right;
		Node(Character c,Integer freq){
			this.freq=freq;
			this.c=c;
			this.left=this.right=null;
		}
		// For priority queue to sort nodes based on frequency
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.freq-o.freq;
		}
		
	}

 
 
  private static void buildHuffmanTree(String data) {
	   HashMap<Character,Integer> table = new HashMap<>();
		for(char c :data.toCharArray())
			table.put(c,table.getOrDefault(c, 0)+1);
		
		PriorityQueue<Node> p =new PriorityQueue<>();
		
		for (Map.Entry<Character, Integer> entry : table.entrySet()) {
            p.add(new Node(entry.getKey(), entry.getValue()));
        }
		while(p.size()>1) {
			Node left = p.poll();
		    Node right =p.poll();
		    Node newNode = new Node('\0',left.freq+right.freq);
		    newNode.left=left;
		    newNode.right=right;
		   p.add(newNode);
		}
		  // The remaining node is the root of the Huffman Tree
		Node root = p.poll();
		// Step 4: Generate codes
		Map<Character,String> h = new HashMap<>();
		generateCode(root,"",h);
		// Print the Huffman codes
		
		System.out.println("Huffman Code");
		for(Map.Entry<Character,String> t : h.entrySet())
			System.out.println(t.getKey()+" : "+t.getValue());
		// Step 5: encode the data
		StringBuilder encode = new StringBuilder();
		for(char c : data.toCharArray())
			encode.append(h.get(c));
		System.out.print("Encoded String : "+encode);
		 
		
	}
//Recursive method to generate codes
    private static void generateCode(Node node,String code,Map<Character,String> h) {
    	if(node==null) return;
    	// If it's a leaf node, add the code to the map
    	if(node.left==null && node.right==null)
    	h.put(node.c, code);
    	generateCode(node.left,code+"0",h);
    	generateCode(node.right,code+"1",h);
    }
    
	public static void main(String[] args) {
		String text = "huffman coding example";
        buildHuffmanTree(text);
	}
    
}
