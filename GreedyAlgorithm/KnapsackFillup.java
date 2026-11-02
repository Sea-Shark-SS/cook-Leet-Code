package GreedyAlgorithm;

public class KnapsackFillup {
  static class Item{
	  double weight;
	  double value;
	  Item(double value,double weight){
		  this.weight=weight;
		  this.value=value;
	  }
  }
  static double getRatio(Item i) {
	  double r = i.value/i.weight;
	  return r;
  }
  static double getFraction(Item[] item,int capacity) {
	  int n=item.length;
	  for(int i =0 ; i<n ; i++) {
		  int min=i ;
		  for(int j=i+1 ; j<n ;j++) {
			  if(getRatio(item[j])>getRatio(item[min])) {
				  min=j;
			  }
		  }
		  Item temp = item[i];
		  item[i]=item[min];
		  item[min]=temp;
	  }
	  double total=0;
	  for(int i=0 ; i<n ;i++) {
		  if(capacity<=0)
			  break;
		  if(item[i].weight<=capacity) {
			  total+=item[i].value;
		      capacity-=item[i].weight;
		  }else {
			  total+=((double)capacity/item[i].weight)*item[i].value;
			  break;
		  }
	  }
	  
	  return total;
  }
  
  public static void main(String[] args) {
	Item[] a = {
		//new Item(20,55),
		//new Item(60, 10),
        //new Item(100, 20),
        new Item(120, 30)
    	};
	int capacity=7;
	System.out.println(getFraction(a,capacity));
	
  }
  
}
