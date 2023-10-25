
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Node implements Comparable<Node> {
		int r;
		int c;
		int cost;
		boolean bomb;

		public Node(int r, int c, int cost, boolean bomb) {
			super();
			this.r = r;
			this.c = c;
			this.cost = cost;
			this.bomb = bomb;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}

		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + ", cost=" + cost + ", bomb=" + bomb + "]";
		}
		
		

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		PriorityQueue<Node> pq = new PriorityQueue<>();
		int answer = Integer.MAX_VALUE;
		map = new int[N][M];
		int[][][] cnt = new int[N][M][2];
		for (int i = 0; i < N; i++) {
			String in = sc.next();
			for (int j = 0; j < M; j++) {
				map[i][j] = in.charAt(j) - '0';
				cnt[i][j][0] = Integer.MAX_VALUE;
			}
		}

		int r = 0;
		int c = 0;
		int cost = 1;
		cnt[r][c][0] = cost;
		boolean chk = false;
		pq.add(new Node(r, c, cost, chk));
		while (!pq.isEmpty()) {
			Node curr = pq.poll();
			r = curr.r;
			c = curr.c;
			cost = curr.cost;
			chk = curr.bomb;

			if (r == N-1 && c == M-1) {
				answer = cost;
				break;
			}
			
			int nr;
			int nc;
			

			for (int d = 0; d < 4; d++) {
				nr = r + dr[d];
				nc = c + dc[d];
				if (!isValid(nr, nc))
					continue;
				if (map[nr][nc] == 0) {
					if (cnt[nr][nc][1] == 1 && !chk) {
						pq.add(new Node(nr, nc, cost + 1, chk));
						cnt[nr][nc][0] = cost + 1;
						cnt[nr][nc][1] = 0;
					} else if (cnt[nr][nc][0] > cost+1) {
						pq.add(new Node(nr, nc, cost + 1, chk));
						cnt[nr][nc][0] = cost + 1;
						cnt[nr][nc][1] = (chk) ? 1 : 0; 
					}
				}
				else if (map[nr][nc] == 1 && !chk && cnt[nr][nc][0] > cost+1) {
					pq.add(new Node(nr, nc, cost + 1, true));
					cnt[nr][nc][0] = cost + 1;
					cnt[nr][nc][1] = 1;
				}
			}

		}
		


		if (cnt[N-1][M-1][0] == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(cnt[N-1][M-1][0]);

	}

	static boolean isValid(int r, int c) {
		if (r < 0 || r >= N || c < 0 || c >= M)
			return false;
		return true;
	}

}
