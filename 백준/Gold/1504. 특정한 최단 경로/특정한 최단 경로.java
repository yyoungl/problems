
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static class Node implements Comparable<Node> {
	int num;
	long cost;
		public Node(int r, long c) {
			super();
			this.num = r;
			this.cost = c;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return Long.compare(this.cost, o.cost);
		}
		
	}
	
	static int N;
	static int E;
	static ArrayList<Node>[] graph;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		E = sc.nextInt();
		long answer1 = 0;
		long answer2 = 0;
		graph = new ArrayList[N+1];
		
		int[][] cnt = new int[N+1][N+1];
		for (int i=1; i<=N; i++) {
			graph[i] = new ArrayList<>();
			for (int j=1; j<=N; j++) {
				cnt[i][j] = Integer.MAX_VALUE;
			}
		}
		for (int i=0; i<E; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			int cost = sc.nextInt();
			graph[start].add(new Node(end, cost));
			graph[end].add(new Node(start, cost));
		}
		boolean flag1 = true;
		boolean flag2 = true;
		int mid1 = sc.nextInt();
		int mid2 = sc.nextInt();
		
		if (bfs(1, mid1) == Integer.MAX_VALUE || bfs(mid1, mid2) == Integer.MAX_VALUE || bfs(mid2, N) == Integer.MAX_VALUE) {
			flag1 = false;
		}
		if (bfs(1, mid2) == Integer.MAX_VALUE || bfs(mid2, mid1) == Integer.MAX_VALUE || bfs(mid1, N) == Integer.MAX_VALUE) {
			flag2 = false;
		}

		answer1 = bfs(1, mid1) + bfs(mid1, mid2) + bfs(mid2, N);
		answer2 = bfs(1, mid2) + bfs(mid2, mid1) + bfs(mid1, N);
		
		if (!flag1 && !flag2) System.out.println(-1);
		else System.out.println(Math.min(answer1, answer2));
		
	}
	
	public static long bfs(int start, int end) {
		long[] dis = new long[N+1];
		for (int i=0; i<=N; i++) dis[i] = (long) Integer.MAX_VALUE;
		dis[start] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			if (curr.num == end) break;
			
			for (Node node: graph[curr.num]) {
				if (dis[node.num] > dis[curr.num] + node.cost) {
					dis[node.num] = dis[curr.num] + node.cost;
					pq.add(new Node(node.num, dis[node.num]));
				}
			}
			
		}
		return dis[end];
	}
}
