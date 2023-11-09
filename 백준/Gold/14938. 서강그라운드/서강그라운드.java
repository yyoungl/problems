
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int R;
	static int[] items;
	static int[][] graph;

	static class Node implements Comparable<Node> {
		int pos;
		int dis;

		public Node(int pos, int dis) {
			super();
			this.pos = pos;
			this.dis = dis;
		}

		public int compareTo(Node o) {
			return Integer.compare(this.dis, o.dis);
		}

		@Override
		public String toString() {
			return "Node [pos=" + pos + ", dis=" + dis + "]";
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		R = sc.nextInt();
		items = new int[N + 1];
		graph = new int[N + 1][N + 1];
		int answer = 0;
		for (int i = 1; i <= N; i++)
			items[i] = sc.nextInt();
		for (int i = 0; i < R; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int cost = sc.nextInt();
			graph[x][y] = cost;
			graph[y][x] = cost;
		}

		for (int start = 1; start <= N; start++) {
			answer = Math.max(answer, dijkstra(start));
		}

		System.out.println(answer);

	}

	static int dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		int[] dist = new int[N + 1];
		boolean[] visited = new boolean[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		int answer = items[start];

		pq.add(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node curr = pq.poll();
			int now = curr.pos;
			int dis = curr.dis;
//			System.out.println(curr.toString());

			for (int i = 1; i <= N; i++) {
				if (graph[now][i] > 0 && dist[i] > dist[now] + graph[now][i] && M >= (graph[now][i] + dist[now])) {
					pq.add(new Node(i, dis + graph[now][i]));
					if (dist[i] == Integer.MAX_VALUE)
						answer += items[i];
					dist[i] = dist[now] + graph[now][i];
				}
			}

//			System.out.println("중간 answer: "+answer);

		}
//		System.out.println("answer: "+answer);
//		System.out.println("------------");

		return answer;

	}

}
