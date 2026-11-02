package HuffMAn_Coding;

public class Main {
public static void main(String[] args) {
	String x= "ABASDGDFASDFD";
	HuffMan h= new HuffMan();
	h.buildhuffmantree(x);
    System.out.println(h.getH());
    h.encode(x);
    System.out.println(h.encodeString());
    String y=h.encodeString();
    h.decode(y);
    String z=h.decodeString();
    System.out.println(z);
    
}
}
