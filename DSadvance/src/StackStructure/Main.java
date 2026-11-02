package StackStructure;

public class Main {
public static void main(String[] args) {
	Stacks s = new Stacks(5);
	s.push(0);
	s.push(1);
	s.push(2);
	s.push(3);
	s.push(4);
	System.out.println(s.isFull());
	s.pop();

	System.out.println(s.isEmpty());
	System.out.println(s.isFull());
	
}
}
