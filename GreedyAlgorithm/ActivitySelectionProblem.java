package GreedyAlgorithm;


public class ActivitySelectionProblem {
	static class Activity{
		int start;
		int finish;
		Activity(int start,int finish){
			this.start=start;
			this.finish=finish;
		}
	}

	static void getActivity(Activity[] a) {
		int n=a.length;
		for(int i=0 ; i<n ; i++) {
			int min=i;
			for(int j=i+1 ; j<n;j++) {
				if(a[j].finish<a[min].finish) {
					min=j;
				}
			}
			Activity temp=a[i];
			a[i]=a[min];
			a[min]=temp;
		}
		int last=0;
		System.out.println("Selected Activities");
		System.out.println("Activity "+last+" : start "+a[last].start+" finish "+a[last].finish);
		for(int i=1 ; i<n;i++) {
			if(a[i].start>=a[last].finish) {
				System.out.println("Activity "+i+" : start "+a[i].start+" finish "+a[i].finish);
				last=i;
			}
		}
	}
	public static void main(String[] args) {
		Activity[] a = {
			new Activity(0,6),
			new Activity(1,2),
			new Activity(2,4),
			new Activity(5,6),
			new Activity(6,9),
			new Activity(10,15)
			   };
		getActivity(a);
		
		
	  }
}
