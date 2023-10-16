import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static int V;
	static int E;
	static int K;
	static ArrayList<Node>[] graph;

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
		V = sc.nextInt();
		E = sc.nextInt();
		K = sc.nextInt();
		graph = new ArrayList[V + 1];
		boolean[] visited = new boolean[V + 1];
		int[] dis = new int[V + 1];
		Arrays.fill(dis, Integer.MAX_VALUE);
		
		for (int i=1; i<=V; i++) graph[i] = new ArrayList<>();
		
		for (int i = 0; i < E; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			int cost = sc.nextInt();
			graph[start].add(new Node(end, cost));
		}

		PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(K, 0));
        dis[K] = 0;
        while (!pq.isEmpty()) {
            Node now = pq.poll();
				if (visited[now.num])
					continue;

				for (Node n : graph[now.num]) {
                    if (n.cost + dis[now.num] < dis[n.num]) {
                    dis[n.num] = Math.min(n.cost + dis[now.num], dis[n.num]);
					pq.add(new Node(n.num, dis[n.num]));
                    }

				}
				visited[now.num] = true;
			}
		
		
		for (int i=1; i<=V; i++) {
			if (dis[i] == Integer.MAX_VALUE) System.out.println("INF");
			else System.out.println(dis[i]);
		}

	}

}
