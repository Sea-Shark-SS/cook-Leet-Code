package HeapDataStructure;

public class Main {
public static void main(String[] args) {
	MinHeap heap1 = new MinHeap();
	heap1.insert(1);
	heap1.insert(5);
	heap1.insert(6);
	heap1.insert(2);
	heap1.insert(9);
	heap1.insert(0);
	heap1.printMinHeap();
	heap1.Heapify(0);
	heap1.printMinHeap();
	MaxHeap h = new MaxHeap();
    h.insert(0);
    h.insert(2);
    h.insert(1);
    h.insert(7);
    h.insert(8);
    h.insert(9);
    h.insert(5);
    h.printMinHeap();
    h.Heapify(0);
    h.printMinHeap();

   }
}
