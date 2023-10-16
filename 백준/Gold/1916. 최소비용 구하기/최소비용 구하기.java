
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static class Node implements Comparable<Node> {
		int num;
		int cost;
		
		public Node(int num, int cost) {
			super();
			this.num = num;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.cost, o.cost);
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		ArrayList<Node>[] graph = new ArrayList[N+1];
		int[] dis = new int[N+1];
		for (int i=0; i<=N; i++) {
			dis[i] = Integer.MAX_VALUE;
			graph[i] = new ArrayList<>();
		}
		
		for (int i=0; i<M; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			int cost = sc.nextInt();
			
			graph[start].add(new Node(end, cost));
		}
		
		int start = sc.nextInt();
		int end = sc.nextInt();
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		dis[start] = 0;
		
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			
			if (curr.num == end) break;
			
			for (Node node: graph[curr.num]) {
				if (dis[node.num] > node.cost + dis[curr.num] ) {
					dis[node.num]= node.cost + dis[curr.num]; 
					pq.add(new Node(node.num, dis[node.num]));
				}
			}
			
		}
		
		System.out.println(dis[end]);
		
	}

}
