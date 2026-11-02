package SetDataStructure;

public class Main {
public static void main(String[] args) {
	Treeset t = new Treeset();
	t.add(3);
	t.add(2);
	t.add(1);
	t.add(0);
	t.add(5);
	t.add(4);
	//t.print();
	//t.remove(5);
	//t.removeAll();
	System.out.println(t.contains(3));
	System.out.println("Max value  :"+t.maxValue());
	System.out.println("Min Value  :"+t.minValue());
	System.out.println("Size of set:"+t.sizeOfSet());
	System.out.println("Set is empty ? "+t.isEmpty());
	t.print();
	System.out.println();
	System.out.println("Hash Set");
	Hashset h = new Hashset();

    for(int i = 0 ; i<=20 ; i++) {
    	h.add(i);
    }
    
  	h.print();
  	System.out.println(h.isEmpty());
	System.out.println(h.sizeOfSet());
	System.out.println(h.minValue());
	System.err.println(h.maxValue());
	System.out.println(h.contains(25));
	h.removeAll();
	h.print();
	for(int i=0 ; i<=20;i++)
	h.remove(i);
	h.print();
}
}
