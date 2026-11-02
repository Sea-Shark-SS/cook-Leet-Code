package LZ77;

import java.util.ArrayList;
import java.util.List;

public class L77 {
	private String in;
	private int window;
	private int buffer;
	public L77(String in,int w,int b) {
		this.in=in;
		this.buffer=b;
		this.window=w;
	}
public List<Lz> compress(){
	List<Lz> result = new ArrayList<>();
	int position=0;
	while(position<in.length()) {
		int mlength=0;
		int moffset=0;
		int start=Math.max(0,position-window);
		int Lend=Math.max(position+buffer,in.length());
		for(int i =start;i<position;i++) {
			int length=0;
			while(length<Lend-position && in.charAt(i+length)==in.charAt(position+length)) {
				length++;
			}
			if(length>mlength) {
				mlength=length;
				moffset=position-i;
			}
		}
	char nextchar = (position+mlength<in.length()) ? in.charAt(position+mlength) : '\0';
	result.add(new Lz(moffset,mlength,nextchar));
	position+=mlength+1;
	}
	return result;
}
public String decompress(List<Lz> data){
	StringBuilder dc = new StringBuilder();
	for(Lz entry : data) {
		int offset = entry.offset;
		int length = entry.length;
		char next = entry.next;
		 // Copy the sequence from the decompressed data
		int start = dc.length()-offset;
		for(int i =0 ; i<length ;i++) {
			dc.append(dc.charAt(start+i));
		}
		// Append the next character
		dc.append(next);
	}
	return dc.toString();
  }
   

}
