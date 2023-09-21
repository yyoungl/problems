import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static class Node implements Comparable<Node>{
		int r;
		int c;
		int cost;
		
		public Node(int r, int c, int cost) {
			super();
			this.r = r;
			this.c = c;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] dr = { 0, 0, -1, 1 };
		int[] dc = { -1, 1, 0, 0 };

		for (int test_case = 1; test_case <= T; test_case++) {
			PriorityQueue<Node> q = new PriorityQueue<>();
			int N = sc.nextInt();
			int[][] map = new int[N][N];
			int[][] weight = new int[N][N];
			boolean[][] visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				String s = sc.next();
				for (int j = 0; j < N; j++) {
					map[i][j] = s.charAt(j) - '0';
					weight[i][j] = Integer.MAX_VALUE;
				}
			}

			int r = 0;
			int c = 0;
			q.add(new Node(r, c, 0));
			weight[r][c] = map[r][c];

			while (true) {
				Node curr = q.poll();
				r = curr.r;
				c = curr.c;
				if (r == N - 1 && c == N - 1)
					break;
				
				if (visited[r][c]) continue;
				
				visited[r][c] = true;
				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];

					if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc])
						continue;

					if (weight[nr][nc] > map[nr][nc] + weight[r][c]) {
						weight[nr][nc] = map[nr][nc] + weight[r][c]; 
						q.add(new Node(nr, nc, weight[nr][nc]));
					}
					
					
				}
			}

			System.out.println("#" + test_case + " " + weight[N - 1][N - 1]);

		}
	}

}
