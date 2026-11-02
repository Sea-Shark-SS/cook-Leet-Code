package LZ77;

public class Lz {
  int offset;
  int length;
  char next;
  public Lz(int o,int l,char n) {
	  this.offset=o;
	  this.length=l;
	  this.next=n;
  }
  
  public String toString() {
	  String s = "("+offset+","+length+","+next+")";
	  return s;
  }
}
