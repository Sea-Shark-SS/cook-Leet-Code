package GraphAlgorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SnakeLadder {

	static class qentry{
		int v;//vertex
		int dist; //current dist
	}
	static int numOfStep(int[] move,int N) {
		//step 1 :
		int[] visited = new int[N];
		Arrays.fill(visited,-1);
		//step 2 set first cell as start point
		qentry qe = new qentry();
		qe.v=0;
		qe.dist=0;
		//create a queue to perform bfs
		Queue<qentry> q = new LinkedList<>();
		q.add(qe);//add the start in the q
		while(!q.isEmpty()) {
			qe=q.poll();
			int v =qe.v;//current vertex
			//check if qe.v is ==N or not
			if(qe.v==N-1)
				break;//all cells are visited
			//step 3 : check all the adjacent vertices
			for(int i=v+1 ; i<v+6 && i<N ;i++) {
				// Otherwise dequeue the front vertex and
	            // enqueue its adjacent vertices (or cell
	            // numbers reachable through a dice throw)
				 // If this cell is already visited, then
                // ignore
				if(visited[i]==-1) {
					 // Otherwise calculate its distance and
                    // mark it as visited
                    visited[i]=1;
					qentry a = new qentry();
					a.dist=qe.dist+1;
					// Check if there a snake or ladder at
                    // 'i' then tail of snake or top of
                    // ladder become the adjacent of v
					if(move[i]!=-1)
						a.v=move[i];
					else
						a.v=i;
					//add the adjacent in queue
					q.add(a);
				}
			}
		}
		
		
		return qe.dist;
	}
	 public static void main(String[] args)
	    {
	        // Let us construct the board given in above diagram
	        int N = 30;
	        int moves[] = new int[N];
	        for (int i = 0; i < N; i++)
	            moves[i] = -1;

	        // Ladders
	        moves[2] = 21;
	        moves[4] = 7;
	        moves[10] = 25;
	        moves[19] = 28;

	        // Snakes
	        moves[26] = 0;
	        moves[20] = 8;
	        moves[16] = 3;
	        moves[18] = 6;

	        System.out.println("Min Dice throws required is "
	                           + numOfStep(moves, N));
	    }
}
