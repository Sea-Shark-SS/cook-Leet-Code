package GreedyAlgorithm;

public class JobScheduledSequence {
 static class Job{
	 int id;
	 int deadline;
	 int profit;
	 Job(int id,int deadline,int profit){
		 this.id=id;
		 this.deadline=deadline;
		 this.profit=profit;
	 }
 }
   static void jobSchedule(Job[] j) {
	// Sort jobs based on profit in descending order
	   int n=j.length;
	   for(int i=0 ; i<n;i++) {
		   int max = i;
		   for(int k=i+1;k <n ; k++)
			   if(j[k].profit>j[max].profit)
				   max=k;
		   Job temp=j[i];
		   j[i]=j[max];
		   j[max]=temp;
	   }
	   boolean[] slot=new boolean[n];
      // To keep track of free time slots
	  // To store the result (job IDs)
	  int[] res = new int[n];
	  // To store total profit
	  int profit=0;
	  for(Job job: j) {
		  for(int k=Math.min(n, job.deadline)-1; k>=0; k--) {
			// If the slot is free, assign the job to this slot
			  if(!slot[k]) {
				// Mark this slot as occupied
				  slot[k]=true;
				// Store the job ID
				  res[k]=job.id;
				  // Add profit to total profit
				  profit+=job.profit;
				  // Break the loop as the job is scheduled
			     break;
			  }
		  }
	  }
	// Print the scheduled jobs and total profit
	  System.out.println("total profit : "+profit);
	  System.out.println("Scheduled Jobs");
	  int in=0;
	  for(int r :res) {
		  if(slot[in++])
		  System.out.println("Job Id : "+r);
	  }
	  
   }
   public static void main(String[] args) {
       Job[] jobs = {
           new Job(1, 4, 20),
           new Job(2, 1, 10),
           new Job(3, 1, 40),
           new Job(4, 1, 30)
       };

       jobSchedule(jobs);
   }
 
}
